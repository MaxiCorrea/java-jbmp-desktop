package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class SizeTest {

  Object[] getSizes() {
    return new Integer[][] {{2, 3}, {5, 6}, {7, 7}, {8, 89}};
  }

  @Test
  @Parameters(method = "getSizes")
  public void shouldSetTheHeightAndWidth(int height, int width) {
    Size size = new Size(height, width);
    assertEquals(height, size.getHeight());
    assertEquals(width, size.getWidth());
  }

  Object[] getSizeObjects() {
    return new Size[] {new Size(0, 0), new Size(3, 5), new Size(5, 7) , new Size(56,456)};
  }

  @Test
  @Parameters(method = "getSizeObjects")
  public void shouldBeAbleToCreateOneSizeFromAnother(Size another) {
    Size size = new Size(another);
    assertEquals(size , another);
    assertNotSame(size , another);
  }

  @Test
  public void shouldInvertTheWidthAndHeight() {
    Size size = new Size(40,70);
    Size actual = Size.invert(size);
    Size expected = new Size(70,40);
    assertEquals(expected , actual);
  }
  
  
  Object[] notEqualsObjects() {
    return new Object[]{ "" , "foas" , new Integer(4)};
  }
  
  @Test
  @Parameters(method = "notEqualsObjects")
  public void shouldOnlyBeEqualToAnotherSizeObject( Object notEqual) {
    Size size = new Size(0,0);
    assertNotEquals(size,notEqual);
  }
  
}
