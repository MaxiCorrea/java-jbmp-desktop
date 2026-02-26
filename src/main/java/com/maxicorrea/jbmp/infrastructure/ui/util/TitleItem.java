package com.maxicorrea.jbmp.infrastructure.ui.util;

import static com.maxicorrea.jbmp.infrastructure.ui.util.ColorConstants.BACKGROUND_COLOR;
import static com.maxicorrea.jbmp.infrastructure.ui.util.ColorConstants.SEPARATOR_COLOR;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.ARROW_DOWN_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.ARROW_UP_ICON;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static java.awt.Color.WHITE;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleItem extends JPanel {

  private static final long serialVersionUID = 1L;
  public static final Icon ARROW_DOWN = IconLoader.load(ARROW_DOWN_ICON);
  public static final Icon ARROW_UP = IconLoader.load(ARROW_UP_ICON);

  private JLabel titleLabel;
  private JLabel arrowLabel;
  private boolean isPressed;

  public TitleItem(String title) {
    titleLabel = new JLabel(title);
    titleLabel.setForeground(WHITE);
    arrowLabel = new JLabel();
    arrowLabel.setIcon(ARROW_DOWN);
    setBackground(BACKGROUND_COLOR);
    titleLabel.setBackground(BACKGROUND_COLOR);
    setLayout(new BorderLayout());
    add(titleLabel, WEST);
    add(arrowLabel, EAST);
    JPanel line = new JPanel();
    line.setBackground(SEPARATOR_COLOR);
    setPreferredSize(new Dimension(133, 40));
    add(line, SOUTH);
  }

  public JLabel getTitleLabel() {
    return titleLabel;
  }

  public JLabel getArrowLabel() {
    return arrowLabel;
  }

  @Override
  public void addMouseListener(MouseListener listener) {
    titleLabel.addMouseListener(listener);
    arrowLabel.addMouseListener(listener);
  }

  public boolean pressed() {
    isPressed = !isPressed;
    return isPressed;
  }

  public void arrowUp() {
    arrowLabel.setIcon(ARROW_UP);
  }

  public void arrowDown() {
    arrowLabel.setIcon(ARROW_DOWN);
  }

}
