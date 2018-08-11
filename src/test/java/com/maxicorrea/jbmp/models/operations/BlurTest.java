package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class BlurTest {

  @Test
  public void eachPixelShouldBeTheAverageOfItsNeighborhood() {
    /*
      actual         expected
      1 2 3 4 5  ---> 1 2 3 4 5
      6 7 8 9 1       6 3 4 4 1 
      1 2 4 5 6       1 3 4 4 6
      1 2 3 4 5       1 1 2 3 5
      1 2 3 4 5       1 2 3 4 5
      
    */
    
    Image actualImage = new Image(new Size(5, 5));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(0, 2, new Pixel(3, 3, 3));
    actualImage.setPixel(0, 3, new Pixel(4, 4, 4));
    actualImage.setPixel(0, 4, new Pixel(5, 5, 5));
    actualImage.setPixel(1, 0, new Pixel(6, 6, 6));
    actualImage.setPixel(1, 1, new Pixel(7, 7, 7));
    actualImage.setPixel(1, 2, new Pixel(8, 8, 8));
    actualImage.setPixel(1, 3, new Pixel(9, 9, 9));
    actualImage.setPixel(1, 4, new Pixel(1, 1, 1));
    actualImage.setPixel(2, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(2, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(2, 2, new Pixel(4, 4, 4));
    actualImage.setPixel(2, 3, new Pixel(5, 5, 5));
    actualImage.setPixel(2, 4, new Pixel(6, 6, 6));
    actualImage.setPixel(3, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(3, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(3, 2, new Pixel(3, 3, 3));
    actualImage.setPixel(3, 3, new Pixel(4, 4, 4));
    actualImage.setPixel(3, 4, new Pixel(5, 5, 5));
    actualImage.setPixel(4, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(4, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(4, 2, new Pixel(3, 3, 3));
    actualImage.setPixel(4, 3, new Pixel(4, 4, 4));
    actualImage.setPixel(4, 4, new Pixel(5, 5, 5));
    
    Image expectedImage = new Image(new Size(5, 5));
    expectedImage.setPixel(0, 0, new Pixel(1, 1, 1));
    expectedImage.setPixel(0, 1, new Pixel(2, 2, 2));
    expectedImage.setPixel(0, 2, new Pixel(3, 3, 3));
    expectedImage.setPixel(0, 3, new Pixel(4, 4, 4));
    expectedImage.setPixel(0, 4, new Pixel(5, 5, 5));
    expectedImage.setPixel(1, 0, new Pixel(6, 6, 6));
    expectedImage.setPixel(1, 1, new Pixel(3, 3, 3));
    expectedImage.setPixel(1, 2, new Pixel(4, 4, 4));
    expectedImage.setPixel(1, 3, new Pixel(4, 4, 4));
    expectedImage.setPixel(1, 4, new Pixel(1, 1, 1));
    expectedImage.setPixel(2, 0, new Pixel(1, 1, 1));
    expectedImage.setPixel(2, 1, new Pixel(3, 3, 3));
    expectedImage.setPixel(2, 2, new Pixel(4, 4, 4));
    expectedImage.setPixel(2, 3, new Pixel(4, 4, 4));
    expectedImage.setPixel(2, 4, new Pixel(6, 6, 6));
    expectedImage.setPixel(3, 0, new Pixel(1, 1, 1));
    expectedImage.setPixel(3, 1, new Pixel(1, 1, 1));
    expectedImage.setPixel(3, 2, new Pixel(2, 2, 2));
    expectedImage.setPixel(3, 3, new Pixel(3, 3, 3));
    expectedImage.setPixel(3, 4, new Pixel(5, 5, 5));
    expectedImage.setPixel(4, 0, new Pixel(1, 1, 1));
    expectedImage.setPixel(4, 1, new Pixel(2, 2, 2));
    expectedImage.setPixel(4, 2, new Pixel(3, 3, 3));
    expectedImage.setPixel(4, 3, new Pixel(4, 4, 4));
    expectedImage.setPixel(4, 4, new Pixel(5, 5, 5));

    assertEquals(expectedImage , new Blur().apply(actualImage));    
  }

}
