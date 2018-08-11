package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

public class ResetController extends Controller {
  
  public ResetController(EditorView view, Editor model , Controller controller) {
    super(view, model , controller);
  }

  @Override
  public void control(String actionCommand) {
    if("Reset".equals(actionCommand)) {
      if (getModel().getSourceImage() != null) {
        getModel().resetEditedImage();
      } else {
        getView().showErrorMessage(MessagesConstants.NO_IMAGE);
      }
    } else {
      super.control(actionCommand);
    }
  }
  
}
