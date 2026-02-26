package com.maxicorrea.jbmp.infrastructure.persistence;

import java.io.File;
import com.maxicorrea.jbmp.application.port.out.ImageRepository;
import com.maxicorrea.jbmp.domain.ImageLoadException;
import com.maxicorrea.jbmp.domain.ImageSaveException;
import com.maxicorrea.jbmp.domain.model.Image;

public class BmpImageRepository implements ImageRepository {

  private final ImageReader reader;
  private final ImageWriter writer;

  public BmpImageRepository() {
    this(new ImageReader(), new ImageWriter());
  }

  public BmpImageRepository(ImageReader reader, ImageWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  @Override
  public Image load(File file) throws ImageLoadException {
    try {
      return reader.read(file);
    } catch (BmpInputException e) {
      throw new ImageLoadException(e.getMessage(), e);
    }
  }

  @Override
  public void save(Image image, File file) throws ImageSaveException {
    try {
      writer.write(image, file);
    } catch (BmpOutputException e) {
      throw new ImageSaveException(e.getMessage(), e);
    }
  }

}
