package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Pixel.BLACK;
import static java.lang.Math.sqrt;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class EdgesUseCase extends AbstractUseCase {

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    if (!checkPrecondition(image)) {
      return;
    }
    Image result = new Image(image.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int row = 0; row < ROWS; ++row) {
      for (int col = 0; col < COLS; ++col) {
        if (result.inLimit(row, col)) {
          result.setPixel(row, col, BLACK);
          continue;
        }
        double sumX = extractMethod1(image, row, col);
        double sumY = extractMethod2(image, row, col);
        int val = (int) sqrt(sumX * sumX + sumY * sumY);
        result.setPixel(row, col, new Pixel(val, val, val));
      }
    }
    AppViewContext.imageView.updateImage(result);
  }

  static int[][] kernelX = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};

  int extractMethod2(Image origin, int row, int col) {
    return origin.getPixel(row - 1, col - 1).getRed() * kernelY[0][0]
        + origin.getPixel(row - 1, col).getRed() * kernelY[0][1]
        + origin.getPixel(row - 1, col + 1).getRed() * kernelY[0][2]
        + origin.getPixel(row, col - 1).getRed() * kernelY[1][0]
        + origin.getPixel(row, col).getRed() * kernelY[1][1]
        + origin.getPixel(row, col + 1).getRed() * kernelY[1][2]
        + origin.getPixel(row + 1, col - 1).getRed() * kernelY[2][0]
        + origin.getPixel(row + 1, col).getRed() * kernelY[2][1]
        + origin.getPixel(row + 1, col + 1).getRed() * kernelY[2][2];
  }

  static int[][] kernelY = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

  int extractMethod1(Image origin, int row, int col) {
    return origin.getPixel(row - 1, col - 1).getRed() * kernelX[0][0]
        + origin.getPixel(row - 1, col).getRed() * kernelX[0][1]
        + origin.getPixel(row - 1, col + 1).getRed() * kernelX[0][2]
        + origin.getPixel(row, col - 1).getRed() * kernelX[1][0]
        + origin.getPixel(row, col).getRed() * kernelX[1][1]
        + origin.getPixel(row, col + 1).getRed() * kernelX[1][2]
        + origin.getPixel(row + 1, col - 1).getRed() * kernelX[2][0]
        + origin.getPixel(row + 1, col).getRed() * kernelX[2][1]
        + origin.getPixel(row + 1, col + 1).getRed() * kernelX[2][2];
  }

}
