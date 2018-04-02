package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Horizontal implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        Pixel pixelImage = image.getPixel(row , col);
        Pixel pixelResult = result.getPixel(row, image.getSize().getWidth() - 1 - col);
        pixelResult.setRed(pixelImage.getRed());
        pixelResult.setGreen(pixelImage.getGreen());
        pixelResult.setBlue(pixelImage.getBlue());
      }
    }
    return result;
  }
  
  @Override
  public String getName() {
    return "Horizontal";
  }
  
}
