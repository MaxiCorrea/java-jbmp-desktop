package com.maxicorrea.jbmp.utilswing;

import static com.maxicorrea.jbmp.utilswing.ColorConstants.BACKGROUND_COLOR;
import static com.maxicorrea.jbmp.utilswing.IconLoader.load;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SubItem extends JPanel {

  private static final long serialVersionUID = 1L;

  private JButton button;

  public SubItem(String text, String icon) {
    button = new JButton(text);
    setBackground(BACKGROUND_COLOR);
    button.setPreferredSize(new Dimension(120, 25));
    button.setBackground(BACKGROUND_COLOR);
    button.setForeground(WHITE);
    button.setIcon(load(icon));
    button.setFocusPainted(false);
    button.setBorderPainted(false);
    add(button);
    setVisible(false);
  }

  public JButton getButton() {
    return button;
  }

}
