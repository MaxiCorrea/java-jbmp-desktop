package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Sepia implements Operation {

  @Override
  public Image apply(Image origin) {
    Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        final Pixel px = origin.getPixel(currentRow, currentCol);
        int r = ((int) (.393 * px.getRed() + .769 * px.getGreen() + .189 * px.getBlue()));
        int g = ((int) (.349 * px.getRed() + .686 * px.getGreen() + .168 * px.getBlue()));
        int b = ((int) (.272 * px.getRed() + .534 * px.getGreen() + .131 * px.getBlue()));
        result.setPixel(currentRow, currentCol, new Pixel(r, g, b));
      }
    }

    return result;
  }

  @Override
  public String getName() {
    return "Sepia";
  }

}
