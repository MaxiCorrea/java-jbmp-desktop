package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class SepiaTest {

  @Test
  public void deberiaAplicarElFiltroSepiaACadaPixelDeLaImage() {
    Image actualImage = new Image( new Size(2,2));
    actualImage.setPixel(0,0, new Pixel(10,56,65));
    actualImage.setPixel(0,1, new Pixel(20,16,5));
    actualImage.setPixel(1,0, new Pixel(30,36,15));
    actualImage.setPixel(1,1, new Pixel(40,56,25));
    Image expectedImage = new Image( new Size(2,2));
    expectedImage.setPixel(0,0, new Pixel(59,69,61));
    expectedImage.setPixel(0,1, new Pixel(21,19,16));
    expectedImage.setPixel(1,0, new Pixel(42,41,35));
    expectedImage.setPixel(1,1, new Pixel(63,64,54));
    assertEquals(expectedImage , new Sepia().apply(actualImage));
  }

}
