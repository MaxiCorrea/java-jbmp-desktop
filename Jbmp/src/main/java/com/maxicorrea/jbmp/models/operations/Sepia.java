package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Sepia implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    for (Pixel pixel : result) {
      pixel.setRed(
          ((int) (0.393 * pixel.getRed() + 0.769 * pixel.getGreen() + 0.189 * pixel.getBlue())));
      pixel.setGreen(
          ((int) (0.349 * pixel.getRed() + 0.686 * pixel.getGreen() + 0.168 * pixel.getBlue())));
      pixel.setBlue(
          ((int) (0.272 * pixel.getRed() + 0.534 * pixel.getGreen() + 0.131 * pixel.getBlue())));
    }
    return result;
  }



  @Override
  public String getName() {
    return "Sepia";
  }

}
