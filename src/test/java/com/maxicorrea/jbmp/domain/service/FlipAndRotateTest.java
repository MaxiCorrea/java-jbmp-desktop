package com.maxicorrea.jbmp.domain.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class FlipAndRotateTest {

  @Test
  public void horizontalFlipShouldMirrorLeftRight() {
    Image image = new Image(new Size(1, 3));
    image.setPixel(0, 0, new Pixel(10, 0, 0));
    image.setPixel(0, 1, new Pixel(20, 0, 0));
    image.setPixel(0, 2, new Pixel(30, 0, 0));
    Image result = new HorizontalFlip().apply(image);
    assertEquals(30, result.getPixel(0, 0).getRed());
    assertEquals(20, result.getPixel(0, 1).getRed());
    assertEquals(10, result.getPixel(0, 2).getRed());
  }

  @Test
  public void verticalFlipShouldMirrorTopBottom() {
    Image image = new Image(new Size(3, 1));
    image.setPixel(0, 0, new Pixel(10, 0, 0));
    image.setPixel(1, 0, new Pixel(20, 0, 0));
    image.setPixel(2, 0, new Pixel(30, 0, 0));
    Image result = new VerticalFlip().apply(image);
    assertEquals(30, result.getPixel(0, 0).getRed());
    assertEquals(20, result.getPixel(1, 0).getRed());
    assertEquals(10, result.getPixel(2, 0).getRed());
  }

  @Test
  public void rotateRightShouldInvertDimensions() {
    Image image = createTestImage(2, 3);
    Image result = new RotateRight().apply(image);
    assertEquals(3, result.getSize().getHeight());
    assertEquals(2, result.getSize().getWidth());
  }

  @Test
  public void rotateLeftShouldInvertDimensions() {
    Image image = createTestImage(2, 3);
    Image result = new RotateLeft().apply(image);
    assertEquals(3, result.getSize().getHeight());
    assertEquals(2, result.getSize().getWidth());
  }

  @Test
  public void doubleHorizontalFlipShouldReturnOriginal() {
    Image image = new Image(new Size(2, 2));
    image.setPixel(0, 0, new Pixel(10, 20, 30));
    image.setPixel(0, 1, new Pixel(40, 50, 60));
    image.setPixel(1, 0, new Pixel(70, 80, 90));
    image.setPixel(1, 1, new Pixel(100, 110, 120));
    HorizontalFlip flip = new HorizontalFlip();
    Image result = flip.apply(flip.apply(image));
    assertEquals(image, result);
  }

  private Image createTestImage(int height, int width) {
    Image image = new Image(new Size(height, width));
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        image.setPixel(r, c, new Pixel(r * width + c, 0, 0));
      }
    }
    return image;
  }

}
