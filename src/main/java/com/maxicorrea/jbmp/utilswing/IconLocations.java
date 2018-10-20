package com.maxicorrea.jbmp.utilswing;

import static com.maxicorrea.jbmp.configuration.AppConfig.url;

public class IconLocations {

  public static final String GRAYSCALE_PATH = url("brightness");
  public static final String RESET_ICON = url("reset");
  public static final String FILTER_ICON = url("filter");
  public static final String NEGATIVE_ICON = url("reset");
  public static final String SEPIA_ICON = url("negative");
  public static final String ARROW_DOWN_ICON = url("arrowdown");
  public static final String ARROW_UP_ICON = url("arrowup");
  public static final String CLOSE_ICON = url("close");
  public static final String MINI_ICON = url("mini");
  public static final String FAVICON_ICON = url("favicon");
  public static final String ROTATE_LEFT_ICON = url("rotateleft");
  public static final String ROTATE_RIGHT_ICON = url("rotateright");
  public static final String VERTICAL_ICON = url("flipvertical");
  public static final String HORIZONTAL_ICON = url("fliphorizontal");
  public static final String OPEN_ICON = url("openfile");
  public static final String SAVE_ICON = url("savefile");

  private IconLocations() {
    throw new AssertionError("IconLocations is a utility class.");
  }

}
