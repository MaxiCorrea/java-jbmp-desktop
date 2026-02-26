package com.maxicorrea.jbmp.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class SizeTest {

  @Test
  public void shouldCreateSizeWithDimensions() {
    Size size = new Size(480, 640);
    assertEquals(480, size.getHeight());
    assertEquals(640, size.getWidth());
  }

  @Test
  public void shouldCopySize() {
    Size original = new Size(100, 200);
    Size copy = new Size(original);
    assertEquals(original, copy);
  }

  @Test
  public void shouldInvertSize() {
    Size size = new Size(100, 200);
    Size inverted = Size.invert(size);
    assertEquals(200, inverted.getHeight());
    assertEquals(100, inverted.getWidth());
  }

  @Test
  public void shouldBeEqualForSameDimensions() {
    Size a = new Size(10, 20);
    Size b = new Size(10, 20);
    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
  }

  @Test
  public void shouldNotBeEqualForDifferentDimensions() {
    Size a = new Size(10, 20);
    Size b = new Size(20, 10);
    assertNotEquals(a, b);
  }

}
