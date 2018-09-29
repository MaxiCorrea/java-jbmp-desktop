package com.maxicorrea.jbmp.views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.maxicorrea.jbmp.views.utils.ColorConstants;
import com.maxicorrea.jbmp.views.utils.IconLoader;

public class SubItem extends JPanel {

  private static final long serialVersionUID = 1L;
  private static final String EMPTY = "";
  private JButton button;

  public SubItem(String text , String icon ) {
    this(text , icon , EMPTY);
  }
  
  public SubItem(String text, String icon, String command) {
    button = new JButton(text);
    setBackground(ColorConstants.BACKGROUND_COLOR);
    button.setPreferredSize(new Dimension(120, 25));
    button.setActionCommand(command);
    button.setBackground(ColorConstants.BACKGROUND_COLOR);
    button.setForeground(Color.WHITE);
    button.setIcon(IconLoader.load(icon));
    button.setFocusPainted(false);
    button.setBorderPainted(false);
    add(button);
  }

  public JButton getButton() {
    return button;
  }

}