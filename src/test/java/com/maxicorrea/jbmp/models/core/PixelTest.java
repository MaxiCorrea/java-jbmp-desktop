package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PixelTest {

  @Test
  public void shouldNegateRGBChannels() {
    Pixel actual = new Pixel(55, 55, 55);
    Pixel expected = new Pixel(200, 200, 200);
    assertEquals(expected, Pixel.negate(actual));
  }

  @Test
  public void shouldMakeTheAverageOfTheRGBValuesANewPixel() {
    Pixel actual = new Pixel(10, 5, 35);
    Pixel expected = new Pixel(16,16,16);
    assertEquals(expected , Pixel.averageOfChannels(actual));
  }

  @Test
  public void shouldImplementTheToStringMethod() {
    Pixel actual = new Pixel(10,45,67);
    String expected = "Pixel red=10 green=45 blue=67";
    assertEquals(expected,actual.toString());
  }
  
  @Test
  public void ifTheValueInTheChannelsAreNegativeTheyAreSetToZero() {
    Pixel actual = new Pixel(-3,-50, -10);
    Pixel expected = new Pixel(0,0,0);
    assertEquals(expected , actual);
  }
  
  @Test
  public void ifTheValueInTheChannelsIsGreaterThan255TheyAreSetTo255() {
    Pixel actual = new Pixel(300,256,600);
    Pixel expected = new Pixel(255,255,255);
    assertEquals(actual , expected);
  }
  
  Object[] validRedChannels() {
    return new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }

  @Test
  @Parameters(method = "validRedChannels")
  public void shouldSetTheRedColorChannels(int red) {
    Pixel pixel = new Pixel(red, 0, 0);
    assertEquals(red, pixel.getRed());
  }

  Object[] validGreenChannels() {
    return new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }

  @Test
  @Parameters(method = "validGreenChannels")
  public void shouldSetTheGreenColorChannels(int green) {
    Pixel pixel = new Pixel(0, green, 0);
    assertEquals(green, pixel.getGreen());
  }

  Object[] validBlueChannels() {
    return new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }

  @Test
  @Parameters(method = "validBlueChannels")
  public void shouldSetTheBlueColorChannels(int blue) {
    Pixel pixel = new Pixel(0, 0, blue);
    assertEquals(blue, pixel.getBlue());
  }

  Object[] notEqualsObjects() {
    return new Object[] {"", "foas", new Integer(4)};
  }

  @Test
  @Parameters(method = "notEqualsObjects")
  public void shouldOnlyBeEqualToAnotherPixelObject(Object notEqual) {
    Pixel pixel = new Pixel(0, 0, 0);
    assertNotEquals(pixel, notEqual);
    assertNotEquals(pixel.hashCode(), notEqual.hashCode());
  }

  @Test
  public void shouldBeAbleToCreateOnePixelFromAnother() {
    Pixel expected = new Pixel(9, 9, 9);
    Pixel actual = new Pixel(expected);
    assertNotSame(expected, actual);
    assertEquals(expected, actual);
  }

  @Test
  public void toStringShouldShowTheValuesRGB() {
    Pixel pixel = new Pixel(10, 23, 45);
    assertEquals("Pixel red=10 green=23 blue=45", pixel.toString());
  }

}
