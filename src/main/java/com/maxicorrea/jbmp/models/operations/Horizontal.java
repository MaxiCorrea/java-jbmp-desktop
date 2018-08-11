package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Horizontal implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image.getSize());
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        Pixel pixel = image.getPixel(row , col);
        result.setPixel(row, image.getSize().getWidth() - 1 - col , pixel);
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "Horizontal";
  }

}
