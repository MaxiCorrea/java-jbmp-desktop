package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ImageTest {

  Object[] getSizes() {
    return new Size[] {new Size(2, 2), new Size(45, 67), new Size(5, 6)};
  }

  @Test
  @Parameters(method = "getSizes")
  public void shouldBuildAnImageSpecifyingItsSize(Size size) {
    Image image = new Image(size);
    assertEquals(size, image.getSize());
  }

  Object[] getImages() {
    return new Image[] {new Image(new Size(4, 6)), new Image(new Size(6, 7)),
        new Image(new Size(300, 56))};
  }

  @Test
  @Parameters(method = "getImages")
  public void shouldCreateAnImageFromAnother(Image another) {
    Image image = new Image(another);
    assertNotSame(another, image);
    assertEquals(another, image);
    assertEquals(another.hashCode() , image.hashCode());
  }

  @Test
  public void shouldBeAbleToSetAPixelInTheImage() {
    Image image = new Image(new Size(30, 30));
    image.setPixel(0, 0, new Pixel(10, 10, 10));
    assertEquals(new Pixel(10, 10, 10), image.getPixel(0, 0));
  }

  Object[] getUnequal() {
    return new Object[] {"", "Hala", new Integer(3), new Double(34.8), new Image(new Size(1, 1))};
  }

  @Test
  @Parameters(method = "getUnequal")
  public void imageSoloShouldBeImageAAnotherImage(Object noIgual) {
    Image image = new Image(new Size(0, 0));
    assertNotEquals(image, noIgual);
    assertNotEquals(image.hashCode(), noIgual.hashCode());
  }

  @Test
  public void shouldBeAbleToIterateThroughEachPixel() {
    Image image = new Image(new Size(2, 2));
    Pixel pixelIn00 = new Pixel(0, 0, 0);
    Pixel pixelIn01 = new Pixel(1, 1, 1);
    Pixel pixelIn10 = new Pixel(2, 2, 2);
    Pixel pixelIn11 = new Pixel(3, 3, 3);
    image.setPixel(0, 0, pixelIn00);
    image.setPixel(0, 1, pixelIn01);
    image.setPixel(1, 0, pixelIn10);
    image.setPixel(1, 1, pixelIn11);
    Iterator<Pixel> iterator = image.iterator();
    assertTrue(iterator.hasNext());
    assertEquals(pixelIn00, iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(pixelIn01, iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(pixelIn10, iterator.next());
    assertTrue(iterator.hasNext());
    assertEquals(pixelIn11, iterator.next());
    assertFalse(iterator.hasNext());
  }

}
