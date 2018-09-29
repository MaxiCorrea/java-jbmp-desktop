package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyNegativeUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    /*Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        final Pixel pixel = origin.getPixel(currentRow, currentCol);
        result.setPixel(currentRow, currentCol, Pixel.negate(pixel));
      }
    }*/

    return null;
  }

  @Override
  public String getName() {
    return "Negative";
  }

}
