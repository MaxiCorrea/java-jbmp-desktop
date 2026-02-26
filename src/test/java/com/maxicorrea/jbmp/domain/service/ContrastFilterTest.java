package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class ContrastFilterTest {

  @Test
  public void shouldMultiplyChannelsByDefaultFactor() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 100, 100));
    Image result = new ContrastFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(150, px.getRed());
    assertEquals(150, px.getGreen());
    assertEquals(150, px.getBlue());
  }

  @Test
  public void shouldClampToMaxValue() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(200, 200, 200));
    Image result = new ContrastFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(255, px.getRed());
    assertEquals(255, px.getGreen());
    assertEquals(255, px.getBlue());
  }

  @Test
  public void shouldUseCustomFactor() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 100, 100));
    Image result = new ContrastFilter(2.0).apply(image);
    Pixel px = result.getPixel(0, 0);
    assertEquals(200, px.getRed());
  }

}
