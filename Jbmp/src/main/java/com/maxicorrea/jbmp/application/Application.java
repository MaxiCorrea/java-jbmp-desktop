package com.maxicorrea.jbmp.application;

import javax.swing.SwingUtilities;
import com.maxicorrea.jbmp.controllers.EssentialsController;
import com.maxicorrea.jbmp.controllers.OperationController;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.ImageView;
import com.maxicorrea.jbmp.views.EditorView;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      createAndShowView( new Editor(), new EditorView(new ImageView()));
    });
  }
  
  static void createAndShowView(Editor model , EditorView view) {
    model.addObserver(view.getImageView());
    new OperationController(view, model);
    new EssentialsController(view, model);
    view.show();
  }

}
