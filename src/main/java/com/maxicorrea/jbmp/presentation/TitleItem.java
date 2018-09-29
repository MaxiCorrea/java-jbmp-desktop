package com.maxicorrea.jbmp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.maxicorrea.jbmp.views.utils.ColorConstants;
import com.maxicorrea.jbmp.views.utils.IconLoader;
import com.maxicorrea.jbmp.views.utils.IconLocations;

public class TitleItem extends JPanel {

  private static final long serialVersionUID = 1L;
  static final Icon ARROW_DOWN_ICON = IconLoader.load(IconLocations.ARROW_DOWN);
  static final Icon ARROW_UP_ICON = IconLoader.load(IconLocations.ARROW_UP);

  private JLabel titleLabel;
  private JLabel arrowLabel;
  private boolean isPressed = true;

  public TitleItem(String title) {
    titleLabel = new JLabel(title);
    titleLabel.setForeground(Color.white);
    arrowLabel = new JLabel();
    arrowLabel.setIcon(ARROW_UP_ICON);
    setBackground(ColorConstants.BACKGROUND_COLOR);
    titleLabel.setBackground(ColorConstants.BACKGROUND_COLOR);
    setLayout(new BorderLayout());
    add(titleLabel, BorderLayout.WEST);
    add(arrowLabel, BorderLayout.EAST);
    JPanel line = new JPanel();
    line.setBackground(ColorConstants.SEPARATOR_COLOR);
    setPreferredSize(new Dimension(133, 40));
    add(line, BorderLayout.SOUTH);
  }

  JLabel getTitleLabel() {
    return titleLabel;
  }

  JLabel getArrowLabel() {
    return arrowLabel;
  }

  @Override
  public void addMouseListener(MouseListener listener) {
    titleLabel.addMouseListener(listener);
    arrowLabel.addMouseListener(listener);
  }

  public boolean isPressed() {
    isPressed = !isPressed;
    return isPressed;
  }

  public void arrowUp() {
    arrowLabel.setIcon(ARROW_UP_ICON);
  }

  public void arrowDown() {
    arrowLabel.setIcon(ARROW_DOWN_ICON);
  }

}
