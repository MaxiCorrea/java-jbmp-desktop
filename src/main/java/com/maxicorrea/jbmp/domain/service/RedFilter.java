package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class RedFilter implements ImageFilter {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image.getSize());
    for (int row = 0; row < result.getSize().getHeight(); ++row) {
      for (int col = 0; col < result.getSize().getWidth(); ++col) {
        Pixel pixel = image.getPixel(row, col);
        result.setPixel(row, col, new Pixel(pixel.getRed(), 0, 0));
      }
    }
    return result;
  }

}
