package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;


class Grayscale implements Operation {

  @Override
  public Image apply(Image origin) {
    Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        final Pixel pixel = origin.getPixel(currentRow, currentCol);
        result.setPixel(currentRow, currentCol, Pixel.averageOfChannels(pixel));
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "Grayscale";
  }

}
