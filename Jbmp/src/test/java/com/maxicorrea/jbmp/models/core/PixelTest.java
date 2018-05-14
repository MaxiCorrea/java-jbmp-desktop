package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PixelTest {

  Object[] validRedChannels() {
    return new Integer[]{1,2,3,4,5,6,7,8,9,10};
  }
  
  @Test
  @Parameters(method = "validRedChannels")
  public void shouldSetTheRedColorChannels( int red ) {
    Pixel pixel = new Pixel(red ,0,0);
    assertEquals(red , pixel.getRed());
  }

  Object[] validGreenChannels() {
    return new Integer[]{1,2,3,4,5,6,7,8,9,10};
  }
  
  @Test
  @Parameters(method = "validGreenChannels")
  public void shouldSetTheGreenColorChannels( int green ) {
    Pixel pixel = new Pixel(0 ,green,0);
    assertEquals(green , pixel.getGreen());
  }

  
  Object[] validBlueChannels() {
    return new Integer[]{1,2,3,4,5,6,7,8,9,10};
  }
  
  @Test
  @Parameters(method = "validBlueChannels")
  public void shouldSetTheBlueColorChannels( int blue ) {
    Pixel pixel = new Pixel(0 ,0,blue);
    assertEquals(blue , pixel.getBlue());
  }

  Object[] negativeChannels() {
    return new Integer[]{-1,-2,-3,-4,-5};
  }
  
  @Test
  @Parameters(method = "negativeChannels")
  public void shouldSetToZeroIfNegativeValueIsPassed(int negative) {
    Pixel actual = new Pixel(negative , negative , negative);
    Pixel expected = new Pixel(0,0,0);
    assertEquals(expected , actual);
  }
  
  Object[] greaterThan255() {
    return new Integer[]{256,257,300,400,589};
  }
  
  @Test
  @Parameters(method = "greaterThan255")
  public void shouldSetTo255IfValuePassedTheGreater( int greaterThan255 ) {
    Pixel actual = new Pixel(greaterThan255 , greaterThan255 , greaterThan255);
    Pixel expected = new Pixel(255,255,255);
    assertEquals(expected , actual);
  }
  
  Object[] getPixelObjects() {
    return new Pixel[] {new Pixel(0, 0 , 0), new Pixel(13, 15,67), new Pixel(500,700,6) , new Pixel(56,456,7)};
  }

  @Test
  @Parameters(method = "getPixelObjects")
  public void shouldBeAbleToCreateOnePixelFromAnother(Pixel another) {
    Pixel pixel = new Pixel(another);
    assertNotSame(another,pixel);
    assertEquals(another , pixel);
    assertEquals(another.hashCode() , pixel.hashCode());
  }
  
  Object[] notEqualsObjects() {
    return new Object[]{ "" , "foas" , new Integer(4)};
  }
  
  public void shouldOnlyBeEqualToAnotherPixelObject( Object notEqual) {
    Pixel pixel = new Pixel(0,0,0);
    assertNotEquals(pixel , notEqual); 
    assertNotEquals(pixel.hashCode() , notEqual.hashCode()); 
  }
  
}
