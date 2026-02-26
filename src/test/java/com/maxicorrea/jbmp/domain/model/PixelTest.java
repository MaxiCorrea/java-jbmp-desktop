package com.maxicorrea.jbmp.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class PixelTest {

  @Test
  public void shouldCreatePixelWithValidValues() {
    Pixel pixel = new Pixel(100, 150, 200);
    assertEquals(100, pixel.getRed());
    assertEquals(150, pixel.getGreen());
    assertEquals(200, pixel.getBlue());
  }

  @Test
  public void shouldClampValuesAboveMax() {
    Pixel pixel = new Pixel(300, 256, 999);
    assertEquals(255, pixel.getRed());
    assertEquals(255, pixel.getGreen());
    assertEquals(255, pixel.getBlue());
  }

  @Test
  public void shouldClampValuesBelowMin() {
    Pixel pixel = new Pixel(-1, -100, -255);
    assertEquals(0, pixel.getRed());
    assertEquals(0, pixel.getGreen());
    assertEquals(0, pixel.getBlue());
  }

  @Test
  public void shouldCopyPixel() {
    Pixel original = new Pixel(10, 20, 30);
    Pixel copy = new Pixel(original);
    assertEquals(original, copy);
  }

  @Test
  public void shouldNegatePixel() {
    Pixel pixel = new Pixel(100, 150, 200);
    Pixel negated = Pixel.negate(pixel);
    assertEquals(155, negated.getRed());
    assertEquals(105, negated.getGreen());
    assertEquals(55, negated.getBlue());
  }

  @Test
  public void shouldCalculateAverageOfChannels() {
    Pixel pixel = new Pixel(90, 120, 150);
    Pixel avg = Pixel.averageOfChannels(pixel);
    int expected = (90 + 120 + 150) / 3;
    assertEquals(expected, avg.getRed());
    assertEquals(expected, avg.getGreen());
    assertEquals(expected, avg.getBlue());
  }

  @Test
  public void shouldBeEqualForSameValues() {
    Pixel a = new Pixel(10, 20, 30);
    Pixel b = new Pixel(10, 20, 30);
    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
  }

  @Test
  public void shouldNotBeEqualForDifferentValues() {
    Pixel a = new Pixel(10, 20, 30);
    Pixel b = new Pixel(10, 20, 31);
    assertNotEquals(a, b);
  }

  @Test
  public void blackConstantShouldBeAllZeros() {
    assertEquals(0, Pixel.BLACK.getRed());
    assertEquals(0, Pixel.BLACK.getGreen());
    assertEquals(0, Pixel.BLACK.getBlue());
  }

}
