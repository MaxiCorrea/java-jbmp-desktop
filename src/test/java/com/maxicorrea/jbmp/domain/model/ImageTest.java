package com.maxicorrea.jbmp.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class ImageTest {

  @Test
  public void shouldCreateImageWithSize() {
    Size size = new Size(3, 4);
    Image image = new Image(size);
    assertEquals(size, image.getSize());
  }

  @Test
  public void shouldSetAndGetPixel() {
    Image image = new Image(new Size(2, 2));
    Pixel pixel = new Pixel(100, 150, 200);
    image.setPixel(0, 0, pixel);
    assertEquals(pixel, image.getPixel(0, 0));
  }

  @Test
  public void shouldReturnNullForUnsetPixel() {
    Image image = new Image(new Size(2, 2));
    assertNull(image.getPixel(0, 0));
  }

  @Test
  public void shouldCopyImage() {
    Image original = new Image(new Size(2, 2));
    original.setPixel(0, 0, new Pixel(10, 20, 30));
    original.setPixel(1, 1, new Pixel(40, 50, 60));
    Image copy = new Image(original);
    assertEquals(original, copy);
  }

  @Test
  public void shouldDetectBorderPixels() {
    Image image = new Image(new Size(5, 5));
    assertTrue(image.inLimit(0, 0));
    assertTrue(image.inLimit(0, 2));
    assertTrue(image.inLimit(4, 2));
    assertTrue(image.inLimit(2, 0));
    assertTrue(image.inLimit(2, 4));
    assertFalse(image.inLimit(2, 2));
  }

  @Test
  public void shouldBeEqualForSameContent() {
    Image a = new Image(new Size(1, 1));
    a.setPixel(0, 0, new Pixel(10, 20, 30));
    Image b = new Image(new Size(1, 1));
    b.setPixel(0, 0, new Pixel(10, 20, 30));
    assertEquals(a, b);
  }

}
