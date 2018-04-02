package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Size;

class Grayscale implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        int redChannel = result.getPixel(row, col).getRed();
        int greenChannel = result.getPixel(row, col).getGreen();
        int blueChannel = result.getPixel(row, col).getBlue();
        int average = (redChannel + greenChannel + blueChannel) / 3;
        result.getPixel(row, col).setRed(average);
        result.getPixel(row, col).setGreen(average);
        result.getPixel(row, col).setBlue(average);
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "Grayscale";
  }
  
}
