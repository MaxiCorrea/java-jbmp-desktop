package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class EdgesTest {

  @Test
  public void test() {
    Image actualImage = new Image( new Size(2,2));
    actualImage.setPixel(0, 0, new Pixel(200, 200, 200));
    actualImage.setPixel(0, 1, new Pixel(100, 100, 100));
    actualImage.setPixel(1, 0, new Pixel(0, 200, 200));
    actualImage.setPixel(1, 1, new Pixel(20, 0, 130));
    Image expectedImage = new Image( new Size(2, 2));
    expectedImage.setPixel(0, 0, new Pixel(0, 0, 0));
    expectedImage.setPixel(0, 1, new Pixel(0, 0, 0));
    expectedImage.setPixel(1, 0, new Pixel(0, 0, 0));
    expectedImage.setPixel(1, 1, new Pixel(0, 0, 0));
    assertEquals(expectedImage , new Edges().apply(actualImage));
  }

}
