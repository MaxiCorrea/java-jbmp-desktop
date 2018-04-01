package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ImageTest {

  Object[] getSizes() {
    return new Size[]{ new Size(2,2) , new Size(45,67) , new Size(5,6)};
  }
  
  @Test
  @Parameters(method = "getSizes")
  public void deberiaConstruirUnaImageEspecificandoSuTamanio(Size size) {
    Image image = new Image(size);
    assertEquals(size , image.getSize());
  }

  Object[] getImages() {
    return new Image[]{ new Image(new Size(4,6)) , new Image(new Size(6,7)) , new Image( new Size(300,56))};
  }
  
  @Test
  @Parameters(method = "getImages")
  public void deberiaCrearUnaImageApartirDeOtra(Image another) {
    Image image = new Image(another);
    assertNotSame(another , image);
    assertEquals(another , image);
  }
  
  @Test
  public void deberiaPoderEstablecerUnPixelEnLaImagen() {
    Image image = new Image( new Size(30,30));
    image.setPixel(0,0, new Pixel(10,10,10));
    assertEquals( new Pixel(10,10,10) , image.getPixel(0, 0));
  }
  
  Object[] getDesiguales() {
    return new Object[]{"" ,"Hala" , new Integer(3) , new Double(34.8) , new Image( new Size(1,1))};
  }
  
  @Test
  @Parameters(method = "getDesiguales")
  public void imageUnaSoloDeberiaSerImageAOtraImage(Object noIgual) {
    Image image = new Image( new Size(0,0));
    assertNotEquals(image , noIgual);
  }
  
}
