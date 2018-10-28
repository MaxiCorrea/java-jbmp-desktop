package com.maxicorrea.jbmp.usecases;

import java.io.File;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.persistence.BmpOutputException;
import com.maxicorrea.jbmp.persistence.ImageWriter;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class SaveUseCase extends AbstractUseCase {

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    if (!checkPrecondition(image)) {
      return;
    }
    try {
      File file = AppViewContext.appView.getSaveFile();
      if (file != null) {
        ImageWriter imageWriter = new ImageWriter();
        imageWriter.write(image, file);
      }
    } catch (BmpOutputException ex) {
      AppViewContext.appView.showError(ex.getMessage());
    }
  }
}
