package com.maxicorrea.jbmp.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import com.maxicorrea.jbmp.swing.AppViewSwing;
import com.maxicorrea.jbmp.usecases.AppUseCasesContext;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
      } catch (UnsupportedLookAndFeelException e) {
        Logger log = Logger.getGlobal();
        log.log(Level.INFO, "No NimbusLookAndFeel");
      }
      AppViewSwing view = new AppViewSwing();
      new AppUseCasesContext();
      view.initializeViews();
      view.initializeUseCases();
      view.show();
    });
  }

}
