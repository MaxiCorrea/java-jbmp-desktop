package com.maxicorrea.jbmp.domain.service;

import static com.maxicorrea.jbmp.domain.model.Pixel.BLACK;
import static java.lang.Math.sqrt;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class EdgesFilter implements ImageFilter {

  private static final int[][] KERNEL_X = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
  private static final int[][] KERNEL_Y = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

  @Override
  public Image apply(Image image) {
    Image result = new Image(image.getSize());
    final int rows = result.getSize().getHeight();
    final int cols = result.getSize().getWidth();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (result.inLimit(row, col)) {
          result.setPixel(row, col, BLACK);
          continue;
        }
        double sumX = convolve(image, row, col, KERNEL_X);
        double sumY = convolve(image, row, col, KERNEL_Y);
        int val = (int) sqrt(sumX * sumX + sumY * sumY);
        result.setPixel(row, col, new Pixel(val, val, val));
      }
    }
    return result;
  }

  private int convolve(Image origin, int row, int col, int[][] kernel) {
    return origin.getPixel(row - 1, col - 1).getRed() * kernel[0][0]
        + origin.getPixel(row - 1, col).getRed() * kernel[0][1]
        + origin.getPixel(row - 1, col + 1).getRed() * kernel[0][2]
        + origin.getPixel(row, col - 1).getRed() * kernel[1][0]
        + origin.getPixel(row, col).getRed() * kernel[1][1]
        + origin.getPixel(row, col + 1).getRed() * kernel[1][2]
        + origin.getPixel(row + 1, col - 1).getRed() * kernel[2][0]
        + origin.getPixel(row + 1, col).getRed() * kernel[2][1]
        + origin.getPixel(row + 1, col + 1).getRed() * kernel[2][2];
  }

}
