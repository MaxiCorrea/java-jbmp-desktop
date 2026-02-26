package com.maxicorrea.jbmp.infrastructure.ui.swing;

import com.maxicorrea.jbmp.application.port.out.UserNotifier;

public class SwingUserNotifier implements UserNotifier {

  private AppViewSwing appView;

  public void setAppView(AppViewSwing appView) {
    this.appView = appView;
  }

  @Override
  public void showAlert(String message) {
    appView.showAlert(message);
  }

  @Override
  public void showError(String message) {
    appView.showError(message);
  }

  @Override
  public void showMessage(String message) {
    appView.showMessage(message);
  }

}
