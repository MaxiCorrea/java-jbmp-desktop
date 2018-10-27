package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class VerticalUseCase implements UseCase {

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    Image result = new Image(image.getSize());
    for (int i = 0; i < result.getSize().getWidth(); ++i) {
      for (int j = 0; j < result.getSize().getHeight(); ++j) {
        Pixel pixel = image.getPixel(j, i);
        result.setPixel(result.getSize().getHeight() - 1 - j, i, pixel);
      }
    }
    AppViewContext.imageView.updateImage(result);
  }

}
