package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyVerticalUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    /*Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentCol = 0; currentCol < COLS; ++currentCol) {
      for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
        Pixel pixel = origin.getPixel(currentRow, currentCol);
        result.setPixel(ROWS - 1 - currentRow, currentCol, pixel);
      }
    }*/
    return null;
  }

  @Override
  public String getName() {
    return "Vertical";
  }
 

}
