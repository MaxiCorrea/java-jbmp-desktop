package com.maxicorrea.jbmp.utilswing;

import static com.maxicorrea.jbmp.utilswing.ColorConstants.BACKGROUND_COLOR;
import static javax.swing.BoxLayout.PAGE_AXIS;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Item extends JPanel {

  private static final long serialVersionUID = 1L;

  private List<SubItem> subItems;

  public Item(TitleItem titleItem) {
    subItems = new ArrayList<>();
    setLayout(new BoxLayout(this, PAGE_AXIS));
    setBackground(BACKGROUND_COLOR);
    add(titleItem);
    titleItem.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (titleItem.pressed()) {
          pressedAction(titleItem);
        } else {
          notPressedAction(titleItem);
        }
      }
    });
    
  }

  public void pressedAction(TitleItem titleItem) {
    titleItem.arrowUp();
    for (SubItem subItem : subItems) {
      subItem.setVisible(true);
    }
  }

  public void notPressedAction(TitleItem titleItem) {
    titleItem.arrowDown();
    for (SubItem subItem : subItems) {
      subItem.setVisible(false);
    }
  }

  public void addSubItem(SubItem subItemSwingView) {
    subItems.add(subItemSwingView);
    add(subItemSwingView);
  }

  public List<SubItem> getSubItems() {
    return subItems;
  }

}
