package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class GrayscaleFilterTest {

  @Test
  public void shouldConvertToGrayscale() {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(90, 120, 150));
    Image result = new GrayscaleFilter().apply(image);
    int expected = (90 + 120 + 150) / 3;
    Pixel pixel = result.getPixel(0, 0);
    assertEquals(expected, pixel.getRed());
    assertEquals(expected, pixel.getGreen());
    assertEquals(expected, pixel.getBlue());
  }

  @Test
  public void shouldPreserveImageSize() {
    Image image = createTestImage(3, 4);
    Image result = new GrayscaleFilter().apply(image);
    assertEquals(image.getSize(), result.getSize());
  }

  private Image createTestImage(int height, int width) {
    Image image = new Image(new Size(height, width));
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        image.setPixel(r, c, new Pixel(100, 100, 100));
      }
    }
    return image;
  }

}
