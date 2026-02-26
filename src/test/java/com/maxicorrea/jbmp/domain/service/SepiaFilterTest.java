package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class SepiaFilterTest {

  @Test
  public void shouldApplySepiaTransformation() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    Image result = new SepiaFilter().apply(image);
    Pixel px = result.getPixel(0, 0);
    int expectedR = (int) (.393 * 100 + .769 * 150 + .189 * 200);
    int expectedG = (int) (.349 * 100 + .686 * 150 + .168 * 200);
    int expectedB = (int) (.272 * 100 + .534 * 150 + .131 * 200);
    assertEquals(Math.min(expectedR, 255), px.getRed());
    assertEquals(Math.min(expectedG, 255), px.getGreen());
    assertEquals(Math.min(expectedB, 255), px.getBlue());
  }

}
