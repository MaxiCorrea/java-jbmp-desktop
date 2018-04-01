package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Left implements Operation {

  @Override
  public Image apply(Image image) {
    Size size = Size.invert(image.getSize());
    Image result = new Image(size);
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        result.setPixel(row, col, new Pixel(image.getPixel(col, size.getHeight() - 1 - row)));
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "LeftFlip";
  }
  
}
