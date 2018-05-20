package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Blur implements Operation {

  static final int[] X_DIRECTIONS = {-1, 1, -1, 1, 0, 0, -1, 1};
  static final int[] Y_DIRECTIONS = {-1, 1, 1, -1, 1, -1, 0, 0};
  static final int NEIGHBORHOOD = 8;

  @Override
  public Image apply(Image origin) {
    Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        if (result.inLimit(currentRow, currentCol)) {
          Pixel px = new Pixel(origin.getPixel(currentRow, currentCol));
          result.setPixel(currentRow, currentCol, px);
          continue;
        }
        int sumRed = 0;
        int sumGreen = 0;
        int sumBlue = 0;
        for (int idx = 0; idx < NEIGHBORHOOD; ++idx) {
          int row = currentRow + X_DIRECTIONS[idx];
          int col = currentCol + Y_DIRECTIONS[idx];
          Pixel px = origin.getPixel(row, col);
          sumRed += px.getRed();
          sumGreen += px.getGreen();
          sumBlue += px.getBlue();
        }
        Pixel px = new Pixel(sumRed / 9, sumGreen / 9, sumBlue / 9);
        result.setPixel(currentRow, currentCol, px);
      }
    }
    return result;
  }

  @Override
  public String getName() {
    return "Blur";
  }

}
