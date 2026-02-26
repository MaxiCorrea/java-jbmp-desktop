package com.maxicorrea.jbmp.domain.service;

import static com.maxicorrea.jbmp.domain.model.Size.invert;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class RotateLeft implements ImageFilter {

  @Override
  public Image apply(Image image) {
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
