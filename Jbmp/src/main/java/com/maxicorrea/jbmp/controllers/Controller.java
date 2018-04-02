package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

abstract class Controller {

  private EditorView view;
  private Editor model;

  public Controller(EditorView view, Editor model) {
    this.view = view;
    this.model = model;
  }

  public EditorView getView() {
    return view;
  }

  public Editor getModel() {
    return model;
  }

}
