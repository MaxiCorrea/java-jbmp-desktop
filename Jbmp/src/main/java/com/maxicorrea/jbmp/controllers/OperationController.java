package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.operations.OperationFactory;
import com.maxicorrea.jbmp.views.EditorView;

public class OperationController extends Controller {

  public OperationController(EditorView view, Editor model) {
    super(view , model);
    view.setOperationController(this);
  }

  public void control(String actionCommand) {
    for (Operation operation : OperationFactory.getAllOperations()) {
      if (operation.getName().equals(actionCommand)) {
        if(getModel().getSourceImage() != null) {
          getModel().applyOperation(operation);
        } else {
          getView().showErrorMessage(MessagesConstants.NO_IMAGE);
        }
        return;
      }
    }
  }

}