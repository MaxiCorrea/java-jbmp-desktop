package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class VerticalUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image.getSize());
    for (int i = 0; i < result.getSize().getWidth(); ++i) {
      for (int j = 0; j < result.getSize().getHeight(); ++j) {
        Pixel pixel = image.getPixel(j, i);
        result.setPixel(result.getSize().getHeight() - 1 - j, i, pixel);
      }
    }
    return result;
  }
}
