package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Size.invert;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class RightUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(invert(image.getSize()));
    for (int i = 0; i < image.getSize().getWidth(); ++i) {
      for (int j = 0; j < image.getSize().getHeight(); ++j) {
        Pixel pixel = image.getPixel(image.getSize().getHeight() - 1 - j, i);
        result.setPixel(i, j, pixel);
      }
    }
    return result;
  }
}
