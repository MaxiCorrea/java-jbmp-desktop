package com.maxicorrea.jbmp.controllers;

import java.io.File;
import com.maxicorrea.jbmp.io.BmpOutputException;
import com.maxicorrea.jbmp.io.ImageWriter;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

public class SaveController extends Controller {

  public SaveController(EditorView view, Editor model) {
    super(view, model);
  }

  @Override
  public void control(String actionCommand) {
    if ("Save".equals(actionCommand)) {
      File file = getView().showSaveChooser();
      if (file == null) {
        return;
      }
      if (getModel().getSourceImage() == null) {
        getView().showErrorMessage(MessagesConstants.SAVE_NO_IMAGE);
        return;
      }
      try {
        new ImageWriter().write(getModel().getEditedImage(), file);
        getView().showMessage(MessagesConstants.SAVE_OK);
      } catch (BmpOutputException e) {
        getView().showErrorMessage(MessagesConstants.SAVE_ERROR);
      }
    } else {
      super.control(actionCommand);
    }
  }

}
