package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;

public class EssentialsController extends Controller {

  public EssentialsController(EditorView view, Editor model, Controller controller) {
    super(view, model , controller);
    view.setEssentialsController(this);
  }

}
