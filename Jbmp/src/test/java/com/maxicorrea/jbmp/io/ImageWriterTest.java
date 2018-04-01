package com.maxicorrea.jbmp.io;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class ImageWriterTest {

  @Test
  public void shouldBeAbleToSaveAnImageInBmpFormat() throws BmpOutputException {
    Image image = new Image( new Size(50,50));
    for(int r = 0; r < image.getSize().getHeight() ; ++r) {
      for(int c = 0 ; c < image.getSize().getWidth() ; ++c) {
        image.setPixel(r, c, new Pixel(0,0,0));
      }
    }
    ImageWriter imageWriter = new ImageWriter();
    File file = new File("src/test/resources/images/back.bmp");
    imageWriter.write(image, file);
    assertTrue(file.exists());
    assertTrue(file.getAbsolutePath().endsWith(".bmp"));
  }

}
