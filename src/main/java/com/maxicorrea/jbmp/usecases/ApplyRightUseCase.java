package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

class Right implements Operation {

  @Override
  public Image apply(Image origin) {
    Image result = new Image(Size.invert(origin.getSize()));
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        Pixel pixel = new Pixel(origin.getPixel(COLS - 1 - currentCol, currentRow));
        result.setPixel(currentRow, currentCol, pixel);
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "Right";
  }

}
