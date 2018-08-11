package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class VerticalTest {

  @Test
  public void shouldRotateVerticallyTheImage() {
    /*
       actual     expected
       0 , 1  ---> 2 , 3
       2 , 3       0 , 1
    */
    Image actualImage = new Image(new Size(2, 2));
    actualImage.setPixel(0, 0, new Pixel(0, 0, 0));
    actualImage.setPixel(0, 1, new Pixel(1, 1, 1));
    actualImage.setPixel(1, 0, new Pixel(2, 2, 2));
    actualImage.setPixel(1, 1, new Pixel(3, 3, 3));
    Image expectedImage = new Image(new Size(2, 2));
    expectedImage.setPixel(0, 0, new Pixel(2, 2, 2));
    expectedImage.setPixel(0, 1, new Pixel(3, 3, 3));
    expectedImage.setPixel(1, 0, new Pixel(0, 0, 0));
    expectedImage.setPixel(1, 1, new Pixel(1, 1, 1));
    assertEquals(expectedImage, new Vertical().apply(actualImage));
  }

}
