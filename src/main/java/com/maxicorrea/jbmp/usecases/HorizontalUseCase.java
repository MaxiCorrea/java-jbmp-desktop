package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class HorizontalUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image.getSize());
    for (int i = 0; i < result.getSize().getHeight(); ++i) {
      for (int j = 0; j < result.getSize().getWidth(); ++j) {
        Pixel pixel = image.getPixel(i, j);
        result.setPixel(i, result.getSize().getWidth() - 1 - j, pixel);
      }
    }
    return result;
  }
}
