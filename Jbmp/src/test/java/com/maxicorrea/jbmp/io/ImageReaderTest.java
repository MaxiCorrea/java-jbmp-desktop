package com.maxicorrea.jbmp.io;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class ImageReaderTest {

  @Test
  public void shouldBeAbleToReadAnImageInBmpFormat() throws BmpInputException {
    Image expected = new Image( new Size(50,50));
    for(int r = 0; r < expected.getSize().getHeight() ; ++r) {
      for(int c = 0 ; c < expected.getSize().getWidth() ; ++c) {
        expected.setPixel(r, c, new Pixel(0,0,0));
      }
    }
    ImageReader imageReader = new ImageReader();
    File file = new File("src/test/resources/images/back.bmp");
    Image actual = imageReader.read(file);
    assertEquals(expected , actual);
  }

}
