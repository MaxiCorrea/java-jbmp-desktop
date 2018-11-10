package com.maxicorrea.jbmp.usecases;

import java.io.File;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.persistence.BmpOutputException;
import com.maxicorrea.jbmp.persistence.ImageWriter;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class SaveUseCase extends AbstractUseCase {

  private final ImageWriter writer;

  public SaveUseCase() {
    this(new ImageWriter());
  }

  public SaveUseCase(ImageWriter writer) {
    this.writer = writer;
  }

  @Override
  Image applyAlgorithm(Image image) {
    try {
      File file = AppViewContext.appView.getSaveFile();
      if (file != null) {
        writer.write(image, file);
      }
    } catch (BmpOutputException ex) {
      AppViewContext.appView.showError(ex.getMessage());
    }
    return image;
  }
}
