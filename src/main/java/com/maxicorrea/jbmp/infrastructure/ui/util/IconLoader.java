package com.maxicorrea.jbmp.infrastructure.ui.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {

  private IconLoader() {}

  public static Icon load(
		  final String path) {
    return new ImageIcon(new IconLoader().getClass().getResource(path));
  }

}
