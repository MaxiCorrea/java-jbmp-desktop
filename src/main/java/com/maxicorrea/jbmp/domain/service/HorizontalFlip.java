package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class HorizontalFlip implements ImageFilter {

  @Override
  public Image apply(Image image) {
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
