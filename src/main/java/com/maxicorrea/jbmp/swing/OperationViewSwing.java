package com.maxicorrea.jbmp.swing;

import com.maxicorrea.jbmp.presentation.OperationView;
import com.maxicorrea.jbmp.usecases.UseCase;
import com.maxicorrea.jbmp.utilswing.SubItem;

public class OperationViewSwing extends SubItem implements OperationView {
  private static final long serialVersionUID = 1L;

  public static OperationViewSwing createSubItem(String text, String icon) {
    return new OperationViewSwing(text, icon);
  }

  OperationViewSwing(String text, String icon) {
    super(text, icon);
  }

  @Override
  public void setUseCase(UseCase useCase) {
    getButton().addActionListener((e) -> {
      useCase.execute();
    });
  }

}
