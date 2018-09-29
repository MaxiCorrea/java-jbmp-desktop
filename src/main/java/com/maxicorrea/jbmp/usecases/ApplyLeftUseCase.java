package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyLeftUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    /*Image result = new Image(Size.invert(origin.getSize()));
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        Pixel px = new Pixel(origin.getPixel(currentCol, ROWS - 1 - currentRow));
        result.setPixel(currentRow, currentCol, px);
      }
    }*/
    return null;
  }

  @Override
  public String getName() {
    return "Left";
  }

}
