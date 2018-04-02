package com.maxicorrea.jbmp.controllers;

import java.io.File;
import com.maxicorrea.jbmp.io.BmpInputException;
import com.maxicorrea.jbmp.io.BmpOutputException;
import com.maxicorrea.jbmp.io.ImageReader;
import com.maxicorrea.jbmp.io.ImageWriter;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

public class EssentialsController extends Controller {

  public EssentialsController(EditorView view, Editor model) {
    super(view, model);
    view.setIOController(this);
  }

  public void open() {
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
  }

  public void save() {
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
  }

  public void reset() {
    if (getModel().getSourceImage() != null) {
      getModel().resetEditedImage();
    } else {
      getView().showErrorMessage(MessagesConstants.NO_IMAGE);
    }
  }

}