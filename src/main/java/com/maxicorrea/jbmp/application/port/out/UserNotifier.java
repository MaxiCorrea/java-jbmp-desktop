package com.maxicorrea.jbmp.application.port.out;

public interface UserNotifier {

  void showAlert(String message);

  void showError(String message);

  void showMessage(String message);

}
