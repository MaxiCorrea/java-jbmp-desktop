package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Negative implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        Pixel pixel = result.getPixel(row, col);
        pixel.setRed(Pixel.MAX_VALUE - pixel.getRed());
        pixel.setGreen(Pixel.MAX_VALUE - pixel.getGreen());
        pixel.setBlue(Pixel.MAX_VALUE - pixel.getBlue());
      }
    }
    return result;
  }
  
  @Override
  public String getName() {
    return "Negative";
  }
  
}
