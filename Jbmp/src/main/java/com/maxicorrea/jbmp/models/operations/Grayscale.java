package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Grayscale implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    for (Pixel pixel : result) {
      int average = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
      pixel.setRed(average);
      pixel.setGreen(average);
      pixel.setBlue(average);
    }
    return result;
  }

  @Override
  public String getName() {
    return "Grayscale";
  }

}
