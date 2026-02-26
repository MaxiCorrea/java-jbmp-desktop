package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class ChannelFilterTest {

  @Test
  public void redFilterShouldIsolateRedChannel() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    Image result = new RedFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(100, px.getRed());
    assertEquals(0, px.getGreen());
    assertEquals(0, px.getBlue());
  }

  @Test
  public void greenFilterShouldIsolateGreenChannel() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    Image result = new GreenFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(0, px.getRed());
    assertEquals(150, px.getGreen());
    assertEquals(0, px.getBlue());
  }

  @Test
  public void blueFilterShouldIsolateBlueChannel() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    Image result = new BlueFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(0, px.getRed());
    assertEquals(0, px.getGreen());
    assertEquals(200, px.getBlue());
  }

}
