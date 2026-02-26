package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class NegativeFilter implements ImageFilter {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    for (int row = 0; row < image.getSize().getHeight(); ++row) {
      for (int col = 0; col < image.getSize().getWidth(); ++col) {
        result.setPixel(row, col, Pixel.negate(image.getPixel(row, col)));
      }
    }
    return result;
  }

}
