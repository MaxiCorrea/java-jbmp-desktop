package com.maxicorrea.jbmp.presentation.utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {

  private IconLoader() {
    throw new AssertionError("IconLoader is a utility class.");
  }
  
  public static Icon load(String path) {
    return new ImageIcon(IconLoader.class.getClass().getResource(path));
  }
  
}