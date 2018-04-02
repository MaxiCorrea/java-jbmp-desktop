package com.maxicorrea.jbmp.views.utils;

import com.maxicorrea.jbmp.application.AppConfig;

public class IconLocations {

  public static final String GRAYSCALE_PATH = AppConfig.url("brightness");
  public static final String RESET = AppConfig.url("reset");
  public static final String FILTER = AppConfig.url("filter");
  public static final String NEGATIVE = AppConfig.url("reset");
  public static final String SEPIA_PATH = AppConfig.url("negative");
  public static final String ARROW_DOWN = AppConfig.url("arrowdown");
  public static final String ARROW_UP = AppConfig.url("arrowup");
  public static final String CLOSE = AppConfig.url("close");
  public static final String MINI = AppConfig.url("mini");
  public static final String FAVICON = AppConfig.url("favicon");
  public static final String ROTATE_LEFT = AppConfig.url("rotateleft");
  public static final String ROTATE_RIGHT = AppConfig.url("rotateright");
  public static final String VERTICAL = AppConfig.url("flipvertical");
  public static final String HORIZONTAL = AppConfig.url("fliphorizontal");
  public static final String OPEN = AppConfig.url("openfile");
  public static final String SAVE = AppConfig.url("savefile");;
 
  private IconLocations() {
    throw new AssertionError("IconLocations is a utility class.");
  }

}
