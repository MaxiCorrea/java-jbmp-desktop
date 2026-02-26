package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class VerticalFlip implements ImageFilter {

  @Override
  public Image apply(Image image) {
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
