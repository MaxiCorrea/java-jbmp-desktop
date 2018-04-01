package com.maxicorrea.jbmp.views.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class IconLoaderTest {

  @Test
  public void shouldLoadAllIcons() {
    assertNotNull(IconLoader.load(IconLocations.GRAYSCALE_PATH));
    assertNotNull(IconLoader.load(IconLocations.NEGATIVE_PATH));
    assertNotNull(IconLoader.load(IconLocations.SEPIA_PATH));
    assertNotNull(IconLoader.load(IconLocations.ARROW_DOWN));
    assertNotNull(IconLoader.load(IconLocations.ARROW_UP));
    assertNotNull(IconLoader.load(IconLocations.CLOSE));
    assertNotNull(IconLoader.load(IconLocations.MINI));
    assertNotNull(IconLoader.load(IconLocations.FAVICON));
    assertNotNull(IconLoader.load(IconLocations.ROTATE_LEFT));
    assertNotNull(IconLoader.load(IconLocations.ROTATE_RIGHT));
  }

}
