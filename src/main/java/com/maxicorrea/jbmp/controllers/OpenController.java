package com.maxicorrea.jbmp.controllers;

import java.io.File;
import com.maxicorrea.jbmp.io.BmpInputException;
import com.maxicorrea.jbmp.io.ImageReader;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

public class OpenController extends Controller {


  public OpenController(EditorView view, Editor model, Controller controller) {
    super(view, model , controller);
  }

  @Override
  public void control(String actionCommand) {
    if ("Open".equals(actionCommand)) {
      File file = getView().showOpenChooser();
      if (file == null || !file.exists()) {
        return;
      }
      try {
        getModel().setSourceImage(new ImageReader().read(file));
        getView().showMessage(MessagesConstants.LOAD_OK);
      } catch (BmpInputException e) {
        getView().showErrorMessage(MessagesConstants.LOAD_ERROR);
      }
    } else {
      super.control(actionCommand);
    }
  }

}
