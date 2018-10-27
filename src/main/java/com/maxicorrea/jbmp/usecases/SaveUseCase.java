package com.maxicorrea.jbmp.usecases;

import java.io.File;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.persistence.BmpOutputException;
import com.maxicorrea.jbmp.persistence.ImageWriter;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class SaveUseCase implements UseCase {

  @Override
  public void execute() {
    try {
      File file = AppViewContext.appView.getSaveFile();
      if (file != null) {
        Image image = AppViewContext.imageView.getImage();
        ImageWriter imageWriter = new ImageWriter();
        imageWriter.write(image, file);
      }
    } catch (BmpOutputException ex) {
      ex.printStackTrace();
    }
  }

}
