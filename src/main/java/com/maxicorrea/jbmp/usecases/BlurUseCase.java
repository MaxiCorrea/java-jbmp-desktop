package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class BlurUseCase implements UseCase {

  static final int[] X_DIRECTIONS = {-1, 1, -1, 1, 0, 0, -1, 1};
  static final int[] Y_DIRECTIONS = {-1, 1, 1, -1, 1, -1, 0, 0};
  static final int NEIGHBORHOOD = 8;

  public BlurUseCase(Image image) {
    // TODO Auto-generated constructor stub
  }

  public void execute() {
    /*
     * Image result = new Image(new Size(request.height , request.width)); for (int currentRow = 0;
     * currentRow < request.height; ++currentRow) { for (int currentCol = 0; currentCol <
     * request.width; ++currentCol) { DataPixelRequest dpr = request.pixels[currentRow][currentCol];
     * Pixel px = new Pixel(dpr.red , dpr.green , dpr.blue); if (result.inLimit(currentRow,
     * currentCol)) { result.setPixel(currentRow, currentCol, px); continue; } int sumRed = 0; int
     * sumGreen = 0; int sumBlue = 0; for (int idx = 0; idx < NEIGHBORHOOD; ++idx) { int row =
     * currentRow + X_DIRECTIONS[idx]; int col = currentCol + Y_DIRECTIONS[idx]; sumRed +=
     * request.pixels[row][col].red; sumGreen += request.pixels[row][col].green; sumBlue +=
     * request.pixels[row][col].blue; } result.setPixel(currentRow, currentCol, new Pixel(sumRed /
     * 9, sumGreen / 9, sumBlue / 9)); } } new DataImageResponse(result);
     */
  }

  public String getName() {
    return "Blur";
  }

}
