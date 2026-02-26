package com.maxicorrea.jbmp.infrastructure.ui.swing;

import com.maxicorrea.jbmp.infrastructure.ui.util.SubItem;

public class OperationViewSwing extends SubItem {

  private static final long serialVersionUID = 1L;

  public static OperationViewSwing createSubItem(String text, String icon) {
    return new OperationViewSwing(text, icon);
  }

  OperationViewSwing(String text, String icon) {
    super(text, icon);
  }

  public void setAction(Runnable action) {
    getButton().addActionListener((e) -> action.run());
  }

}
