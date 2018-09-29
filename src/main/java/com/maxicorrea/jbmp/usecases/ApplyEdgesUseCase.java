package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Edges implements Operation {

  @Override
  public Image apply(Image origin) {
    Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currRow = 0; currRow < ROWS; ++currRow) {
      for (int currCol = 0; currCol < COLS; ++currCol) {
        if (result.inLimit(currRow, currCol)) {
          result.setPixel(currRow, currCol, Pixel.BLACK);
          continue;
        }
        double sumX = extractMethod1(origin, currRow, currCol);
        double sumY = extractMethod2(origin, currRow, currCol);
        int val = (int) Math.sqrt(sumX * sumX + sumY * sumY);
        result.setPixel(currRow, currCol, new Pixel(val, val, val));
      }
    }
    return result;
  }

  static int[][] kernelX = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};

  private int extractMethod2(Image origin, int currRow, int currCol) {
    return origin.getPixel(currRow - 1, currCol - 1).getRed() * kernelY[0][0]
        + origin.getPixel(currRow - 1, currCol).getRed() * kernelY[0][1]
        + origin.getPixel(currRow - 1, currCol + 1).getRed() * kernelY[0][2]
        + origin.getPixel(currRow, currCol - 1).getRed() * kernelY[1][0]
        + origin.getPixel(currRow, currCol).getRed() * kernelY[1][1]
        + origin.getPixel(currRow, currCol + 1).getRed() * kernelY[1][2]
        + origin.getPixel(currRow + 1, currCol - 1).getRed() * kernelY[2][0]
        + origin.getPixel(currRow + 1, currCol).getRed() * kernelY[2][1]
        + origin.getPixel(currRow + 1, currCol + 1).getRed() * kernelY[2][2];
  }

  static int[][] kernelY = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

  private int extractMethod1(Image origin, int currRow, int currCol) {
    return origin.getPixel(currRow - 1, currCol - 1).getRed() * kernelX[0][0]
        + origin.getPixel(currRow - 1, currCol).getRed() * kernelX[0][1]
        + origin.getPixel(currRow - 1, currCol + 1).getRed() * kernelX[0][2]
        + origin.getPixel(currRow, currCol - 1).getRed() * kernelX[1][0]
        + origin.getPixel(currRow, currCol).getRed() * kernelX[1][1]
        + origin.getPixel(currRow, currCol + 1).getRed() * kernelX[1][2]
        + origin.getPixel(currRow + 1, currCol - 1).getRed() * kernelX[2][0]
        + origin.getPixel(currRow + 1, currCol).getRed() * kernelX[2][1]
        + origin.getPixel(currRow + 1, currCol + 1).getRed() * kernelX[2][2];
  }

  @Override
  public String getName() {
    return "Edges";
  }

}
