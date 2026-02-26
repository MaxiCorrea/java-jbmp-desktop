package com.maxicorrea.jbmp.infrastructure.ui.util;

import static com.maxicorrea.jbmp.infrastructure.ui.util.ColorConstants.BACKGROUND_COLOR;
import static com.maxicorrea.jbmp.infrastructure.ui.util.ColorConstants.BACKGROUND_COLOR_2;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialog extends JDialog {

  private static final long serialVersionUID = 1L;

  private static Dialog alectDialog;

  public static void showAlertDialog(JFrame parent, String message) {
    if (alectDialog == null) {
      alectDialog = new Dialog("path", new Dimension(300, 150), "¡¡ Alert !!");
    }
    alectDialog.setMessage(message);
    alectDialog.setLocationRelativeTo(parent);
    alectDialog.setVisible(true);
  }

  private JLabel labelMessage;

  private Dialog(String pathIcon, Dimension dimension, String title) {
    setModal(true);
    setSize(dimension);
    setPreferredSize(dimension);
    setResizable(false);
    setUndecorated(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    getContentPane().add(createNorthPane(title), NORTH);
    getContentPane().add(createCenterPane(), CENTER);
    getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createNorthPane(String title) {
    JPanel pane = new JPanel();
    pane.setBackground(BACKGROUND_COLOR_2);
    JLabel label = new JLabel(title);
    label.setForeground(WHITE);
    pane.add(label);
    return pane;
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    labelMessage = new JLabel("", JLabel.CENTER);
    labelMessage.setForeground(WHITE);
    Font currentFont = labelMessage.getFont();
    labelMessage.setFont(currentFont.deriveFont(20f));
    pane.add(labelMessage);
    pane.setBackground(BACKGROUND_COLOR);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(BACKGROUND_COLOR_2);
    JButton acceptButton = new JButton(" OK ");
    acceptButton.setBackground(BACKGROUND_COLOR);
    acceptButton.setForeground(WHITE);
    acceptButton.setFocusPainted(false);
    acceptButton.setBorderPainted(false);
    acceptButton.addActionListener((e) -> {
      dispose();
    });
    pane.add(acceptButton);
    return pane;
  }

  private void setMessage(String message) {
    labelMessage.setText(message);
  }

}
