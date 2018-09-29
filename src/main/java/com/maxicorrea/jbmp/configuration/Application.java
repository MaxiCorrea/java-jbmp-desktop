package com.maxicorrea.jbmp.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import com.maxicorrea.jbmp.presentation.EditorView;
import com.maxicorrea.jbmp.presentation.ImageView;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
      } catch (UnsupportedLookAndFeelException e) {
        Logger log = Logger.getGlobal();
        log.log(Level.INFO, "No NimbusLookAndFeel");
      }
      EditorView view = new EditorView(new ImageView());
      //initializeApp(new Editor(), view);
      view.show();
    });
  }

  /*
  public static void initializeApp(Editor model, EditorView view) {
    model.addObserver(view.getImageView());
    OpenController openController = new OpenController(view, model,
        new ResetController(view, model, new SaveController(view, model)));
    new EssentialsController(view, model ,openController);
    new OperationController(view, model);
  }*/

}
