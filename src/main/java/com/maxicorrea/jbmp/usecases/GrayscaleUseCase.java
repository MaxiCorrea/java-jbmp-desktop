package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class GrayscaleUseCase implements UseCase {

  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    Image resut = new Image(image.getSize());
    for (int row = 0; row < resut.getSize().getHeight(); ++row) {
      for (int col = 0; col < resut.getSize().getWidth(); ++col) {
        Pixel pixel = image.getPixel(row, col);
        resut.setPixel(row, col, Pixel.averageOfChannels(pixel));
      }
    }
    AppViewContext.imageView.updateImage(resut);
  }

}
