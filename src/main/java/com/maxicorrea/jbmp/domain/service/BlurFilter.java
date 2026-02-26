package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class BlurFilter implements ImageFilter {

  static final int[] X_DIRECTIONS = {-1, 1, -1, 1, 0, 0, -1, 1};
  static final int[] Y_DIRECTIONS = {-1, 1, 1, -1, 1, -1, 0, 0};
  static final int NEIGHBORHOOD = 8;

  @Override
  public Image apply(Image image) {
    Image result = new Image(new Size(image.getSize().getHeight(),
                                      image.getSize().getWidth()));
    for (int currRow = 0; currRow < image.getSize().getHeight(); ++currRow) {
      for (int curCol = 0; curCol < image.getSize().getWidth(); ++curCol) {
        Pixel p = image.getPixel(currRow, curCol);
        if (result.inLimit(currRow, curCol)) {
          result.setPixel(currRow, curCol, p);
          continue;
        }
        int sumRed = 0;
        int sumGreen = 0;
        int sumBlue = 0;
        for (int idx = 0; idx < NEIGHBORHOOD; ++idx) {
          int row = currRow + X_DIRECTIONS[idx];
          int col = curCol + Y_DIRECTIONS[idx];
          Pixel px = image.getPixel(row, col);
          sumRed += px.getRed();
          sumGreen += px.getGreen();
          sumBlue += px.getBlue();
        }
        Pixel newPixel = new Pixel(sumRed / 9, sumGreen / 9, sumBlue / 9);
        result.setPixel(currRow, curCol, newPixel);
      }
    }
    return result;
  }

}
