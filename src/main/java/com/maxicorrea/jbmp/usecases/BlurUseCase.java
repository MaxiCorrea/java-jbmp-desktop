package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.domain.Size;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class BlurUseCase extends AbstractUseCase {

  static final int[] X_DIRECTIONS = {-1, 1, -1, 1, 0, 0, -1, 1};
  static final int[] Y_DIRECTIONS = {-1, 1, 1, -1, 1, -1, 0, 0};
  static final int NEIGHBORHOOD = 8;

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    if(!checkPrecondition(image)) {
      return;
    }
    Image result = new Image(new Size(image.getSize().getHeight(), 
                                      image.getSize().getWidth()));
    for (int currentRow = 0; currentRow < image.getSize().getHeight(); ++currentRow) {
      for (int currentCol = 0; currentCol < image.getSize().getWidth(); ++currentCol) {
        Pixel p = image.getPixel(currentRow, currentCol);
        if (result.inLimit(currentRow, currentCol)) {
          result.setPixel(currentRow, currentCol, p);
          continue;
        }
        int sumRed = 0;
        int sumGreen = 0;
        int sumBlue = 0;
        for (int idx = 0; idx < NEIGHBORHOOD; ++idx) {
          int row = currentRow + X_DIRECTIONS[idx];
          int col = currentCol + Y_DIRECTIONS[idx];
          Pixel px = image.getPixel(row, col);
          sumRed += px.getRed();
          sumGreen += px.getGreen();
          sumBlue += px.getBlue();
        }
        Pixel newPixel = new Pixel(sumRed / 9, sumGreen / 9, sumBlue / 9);
        result.setPixel(currentRow, currentCol, newPixel);
      }
    }
    AppViewContext.imageView.updateImage(result);
  }

}
