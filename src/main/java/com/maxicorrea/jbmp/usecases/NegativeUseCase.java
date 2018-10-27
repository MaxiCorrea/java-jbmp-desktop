package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class NegativeUseCase implements UseCase {
  
  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    Image result = new Image(image);
    for (int row = 0; row < image.getSize().getHeight(); ++row) {
      for (int col = 0; col < image.getSize().getWidth(); ++col) {
        result.setPixel(row, col, Pixel.negate(image.getPixel(row, col)));
      }
    }
    AppViewContext.imageView.updateImage(result);
  }

}
