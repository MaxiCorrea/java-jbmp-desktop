package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplySepiaUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    /*Image result = new Image(origin.getSize());
    final int ROWS = result.getSize().getHeight();
    final int COLS = result.getSize().getWidth();
    for (int currentRow = 0; currentRow < ROWS; ++currentRow) {
      for (int currentCol = 0; currentCol < COLS; ++currentCol) {
        final Pixel px = origin.getPixel(currentRow, currentCol);
        int r = ((int) (.393 * px.getRed() + .769 * px.getGreen() + .189 * px.getBlue()));
        int g = ((int) (.349 * px.getRed() + .686 * px.getGreen() + .168 * px.getBlue()));
        int b = ((int) (.272 * px.getRed() + .534 * px.getGreen() + .131 * px.getBlue()));
        result.setPixel(currentRow, currentCol, new Pixel(r, g, b));
      }
    }*/
    return null;
  }

  @Override
  public String getName() {
    return "Sepia";
  }

}
