package com.maxicorrea.jbmp.utilswing;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("unused")
public class Dialog extends JDialog {

  private static final long serialVersionUID = 1L;
  private static final int WIDTH_DIALOG = 300;
  private static final int HEIGTH_DIALOG = 200;

  private static Dialog alectDialog;
  private static Dialog errorDialog;

  public static void showAlertDialog(String message, JFrame parent) {
    if (alectDialog == null) {
      alectDialog = new Dialog("path");
    }
    alectDialog.setMessage(message);
    alectDialog.setVisible(true);
  }

  public static void showErrorDialog(String message, JFrame parent) {
    if (errorDialog == null) {
      errorDialog = new Dialog("path");
    }
    errorDialog.setMessage(message);
    errorDialog.setVisible(true);
  }

  private JLabel labelMessage;
  private JLabel labelIcon;
  private JButton acceptButton;

  private Dialog(String pathIcon) {
    setModal(true);
    setSize(WIDTH_DIALOG, HEIGTH_DIALOG);
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

  }

  private void setMessage(String message) {
    labelMessage.setText(message);
  }

}
