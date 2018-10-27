package com.maxicorrea.jbmp.presentation;

import java.io.File;

public interface AppView {

  File getOpenFile();

  File getSaveFile();

  void showMessage(String string);

  void showError(String string);

}
