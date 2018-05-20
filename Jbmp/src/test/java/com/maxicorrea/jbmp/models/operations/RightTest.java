package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class RightTest {

  @Test
  public void shouldTurnRightTheImage() {
    /*
      actual    expected
      1 , 2 ---> 3 , 1
      3 , 4      4 , 2
    */
    Image actualImage = new Image(new Size(2, 2));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(1, 0, new Pixel(3, 3, 3));
    actualImage.setPixel(1, 1, new Pixel(4, 4, 4));
    Image expectedImage = new Image(new Size(2, 2));
    expectedImage.setPixel(0, 0, new Pixel(3, 3, 3));
    expectedImage.setPixel(0, 1, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(4, 4, 4));
    expectedImage.setPixel(1, 1, new Pixel(2, 2, 2));
    assertEquals(expectedImage, new Right().apply(actualImage));
  }

  @Test
  public void shouldTurnRightTheImageWithRowsGreaterThanColumns() {
    /*
      actual    expected
      1 , 2 ---> 5 , 3 , 1
      3 , 4      6 , 4 , 2
      5 , 6
    */
    Image actualImage = new Image(new Size(3, 2));
    actualImage.setPixel(0, 0, new Pixel(1 ,1 ,1));
    actualImage.setPixel(0, 1, new Pixel(2 ,2 ,2));
    actualImage.setPixel(1, 0, new Pixel(3 ,3 ,3));
    actualImage.setPixel(1, 1, new Pixel(4 ,4 ,4));
    actualImage.setPixel(2, 0, new Pixel(5 ,5 ,5));
    actualImage.setPixel(2, 1, new Pixel(6 ,6 ,6));
    Image expectedImage = new Image(new Size(2, 3));
    expectedImage.setPixel(0, 0, new Pixel(5, 5, 5));
    expectedImage.setPixel(0, 1, new Pixel(3, 3, 3));
    expectedImage.setPixel(0, 2, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(6, 6, 6));
    expectedImage.setPixel(1, 1, new Pixel(4, 4, 4));
    expectedImage.setPixel(1, 2, new Pixel(2, 2, 2));
    assertEquals(expectedImage, new Right().apply(actualImage));
  }
  
  @Test
  public void shouldTurnRightTheImageWithColumnsGreaterThanRows() {
    /*
       actual      expected
       1 ,2, 3 ---> 4 , 1
       4, 5, 6      5 , 2
                    6 , 3
    */
    Image actualImage = new Image(new Size(2, 3));
    actualImage.setPixel(0, 0, new Pixel(1, 1, 1));
    actualImage.setPixel(0, 1, new Pixel(2, 2, 2));
    actualImage.setPixel(0, 2, new Pixel(3, 3, 3));
    actualImage.setPixel(1, 0, new Pixel(4, 4, 4));
    actualImage.setPixel(1, 1, new Pixel(5, 5, 5));
    actualImage.setPixel(1, 2, new Pixel(6, 6, 6));
    Image expectedImage = new Image(new Size(3, 2));
    expectedImage.setPixel(0, 0, new Pixel(4, 4, 4));
    expectedImage.setPixel(0, 1, new Pixel(1, 1, 1));
    expectedImage.setPixel(1, 0, new Pixel(5, 5, 5));
    expectedImage.setPixel(1, 1, new Pixel(2, 2, 2));
    expectedImage.setPixel(2, 0, new Pixel(6, 6, 6));
    expectedImage.setPixel(2, 1, new Pixel(3, 3, 3));
    assertEquals(expectedImage, new Right().apply(actualImage));
  }
  
}
