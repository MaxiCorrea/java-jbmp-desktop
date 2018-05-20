package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class HorizontalTest {

  @Test
  public void shouldRotateVerticallyImage() {
    /*
       actual     expected
       1 , 2  ---> 2 , 1
       3 , 4       4 , 3
    */
    Image actualImage = new Image(new Size(2, 2));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1)); 
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2));  
    actualImage.setPixel(1, 0, new Pixel(3, 3, 3)); 
    actualImage.setPixel(1, 1, new Pixel(4, 4, 4));  
    Image expectedImage = new Image(new Size(2, 2));
    expectedImage.setPixel(0, 0, new Pixel(2, 2, 2));
    expectedImage.setPixel(0, 1, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(4, 4, 4)); 
    expectedImage.setPixel(1, 1, new Pixel(3, 3, 3)); 
    assertEquals(expectedImage, new Horizontal().apply(actualImage));
  }

  @Test
  public void shouldRotateVerticallyImageWithRowsGreaterThanColumns() {
    /*
      actual     expected
      1 , 2  ---> 2 , 1
      3 , 4       4 , 3
      5 , 6       6 , 5
    */
    Image actualImage = new Image(new Size(3, 2));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1)); 
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2)); 
    actualImage.setPixel(1, 0, new Pixel(3, 3, 3)); 
    actualImage.setPixel(1, 1, new Pixel(4, 4, 4)); 
    actualImage.setPixel(2, 0, new Pixel(5, 5, 5)); 
    actualImage.setPixel(2, 1, new Pixel(6, 6, 6)); 
    Image expectedImage = new Image(new Size(3, 2));
    expectedImage.setPixel(0, 0, new Pixel(2, 2, 2));
    expectedImage.setPixel(0, 1, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(4, 4, 4));
    expectedImage.setPixel(1, 1, new Pixel(3, 3, 3));
    expectedImage.setPixel(2, 0, new Pixel(6, 6, 6));
    expectedImage.setPixel(2, 1, new Pixel(5, 5, 5));
    assertEquals(expectedImage, new Horizontal().apply(actualImage));
  }

  @Test
  public void shouldRotateVerticallyImageWithColumnsGreaterThanRows() {
    /*
      actual         expected
      1 , 2 , 3  -->  3 , 2 , 1
      4 , 5 , 6       6 , 5 , 4
    */
    Image actualImage = new Image(new Size(2, 3));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(0, 2, new Pixel(3, 3, 3));
    actualImage.setPixel(1, 0, new Pixel(4, 4, 4));
    actualImage.setPixel(1, 1, new Pixel(5, 5, 5));
    actualImage.setPixel(1, 2, new Pixel(6, 6, 6));
    Image expectedImage = new Image(new Size(2, 3));
    expectedImage.setPixel(0, 0, new Pixel(3, 3, 3));
    expectedImage.setPixel(0, 1, new Pixel(2, 2, 2));
    expectedImage.setPixel(0, 2, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(6, 6, 6));
    expectedImage.setPixel(1, 1, new Pixel(5, 5, 5));
    expectedImage.setPixel(1, 2, new Pixel(4, 4, 4));
    assertEquals(expectedImage, new Horizontal().apply(actualImage));
  }

}
