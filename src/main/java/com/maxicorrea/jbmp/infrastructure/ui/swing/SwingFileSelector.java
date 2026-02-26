package com.maxicorrea.jbmp.infrastructure.ui.swing;

import java.io.File;
import com.maxicorrea.jbmp.application.port.out.FileSelector;

public class SwingFileSelector implements FileSelector {

  private AppViewSwing appView;

  public void setAppView(AppViewSwing appView) {
    this.appView = appView;
  }

  @Override
  public File selectFileToOpen() {
    return appView.getOpenFile();
  }

  @Override
  public File selectFileToSave() {
    return appView.getSaveFile();
  }

}
