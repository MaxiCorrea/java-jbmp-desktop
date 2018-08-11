package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

abstract class Controller {

  private EditorView view;
  private Editor model;
  private Controller controller;

  Controller(EditorView view, Editor model) {
    this.view = view;
    this.model = model;
  }

  Controller(EditorView view, Editor model, Controller controller) {
    this.view = view;
    this.model = model;
    this.controller = controller;
  }

  EditorView getView() {
    return view;
  }

  Editor getModel() {
    return model;
  }

  public void control(String actionCommand) {
    if (controller != null) {
      controller.control(actionCommand);
    }
  }

}
