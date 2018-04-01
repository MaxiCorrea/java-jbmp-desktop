package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Sepia implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image);
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        Pixel p = result.getPixel(row, col);
        p.setRed(((int) (0.393 * p.getRed() + 0.769 * p.getGreen() + 0.189 * p.getBlue())));
        p.setGreen(((int) (0.349 * p.getRed() + 0.686 * p.getGreen() + 0.168 * p.getBlue())));
        p.setBlue(((int) (0.272 * p.getRed() + 0.534 * p.getGreen() + 0.131 * p.getBlue())));
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "SepiaFilter";
  }

}
