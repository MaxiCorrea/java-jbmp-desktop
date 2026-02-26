package com.maxicorrea.jbmp.infrastructure.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.File;
import org.junit.Test;
import com.maxicorrea.jbmp.domain.ImageLoadException;
import com.maxicorrea.jbmp.domain.ImageSaveException;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class BmpImageRepositoryTest {

  private final BmpImageRepository repository = new BmpImageRepository();

  @Test
  public void shouldLoadBmpFile() throws ImageLoadException {
    File file = new File("src/test/resources/images/ttt.bmp");
    if (file.exists()) {
      Image image = repository.load(file);
      assertNotNull(image);
      assertNotNull(image.getSize());
    }
  }

  @Test(expected = ImageLoadException.class)
  public void shouldThrowOnInvalidFile() throws ImageLoadException {
    File file = new File("src/test/resources/images/err.bmp");
    if (file.exists()) {
      repository.load(file);
    } else {
      throw new ImageLoadException("Test file not found");
    }
  }

  @Test
  public void shouldSaveAndReloadImage() throws ImageLoadException, ImageSaveException {
    Image image = new Image(new Size(2, 4));
    for (int r = 0; r < 2; r++) {
      for (int c = 0; c < 4; c++) {
        image.setPixel(r, c, new Pixel(100, 150, 200));
      }
    }
    File tempFile = new File("target/test-output.bmp");
    tempFile.getParentFile().mkdirs();
    repository.save(image, tempFile);
    Image loaded = repository.load(tempFile);
    assertEquals(image.getSize().getHeight(), loaded.getSize().getHeight());
    assertEquals(image.getSize().getWidth(), loaded.getSize().getWidth());
    assertEquals(image.getPixel(0, 0), loaded.getPixel(0, 0));
    tempFile.delete();
  }

}
