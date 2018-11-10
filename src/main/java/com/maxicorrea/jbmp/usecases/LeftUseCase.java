package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Size.invert;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class LeftUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(invert(image.getSize()));
    for (int i = 0; i < result.getSize().getHeight(); ++i) {
      for (int j = 0; j < result.getSize().getWidth(); ++j) {
        Pixel pixel = image.getPixel(j, image.getSize().getWidth() - 1 - i);
        result.setPixel(i, j, pixel);
      }
    }
    return result;
  }
}
