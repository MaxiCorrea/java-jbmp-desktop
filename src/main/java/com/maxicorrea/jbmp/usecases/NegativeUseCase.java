package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class NegativeUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image);
    for (int row = 0; row < image.getSize().getHeight(); ++row) {
      for (int col = 0; col < image.getSize().getWidth(); ++col) {
        result.setPixel(row, col, Pixel.negate(image.getPixel(row, col)));
      }
    }
    return result;
  }

}
