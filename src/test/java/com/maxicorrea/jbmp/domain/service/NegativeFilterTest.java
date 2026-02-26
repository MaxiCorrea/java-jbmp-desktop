package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class NegativeFilterTest {

  @Test
  public void shouldNegatePixelColors() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    Image result = new NegativeFilter().apply(image);
    Pixel pixel = result.getPixel(0, 0);
    assertEquals(155, pixel.getRed());
    assertEquals(105, pixel.getGreen());
    assertEquals(55, pixel.getBlue());
  }

  @Test
  public void shouldBeInvolutory() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(100, 150, 200));
    NegativeFilter filter = new NegativeFilter();
    Image result = filter.apply(filter.apply(image));
    assertEquals(image.getPixel(0, 0), result.getPixel(0, 0));
  }

}
