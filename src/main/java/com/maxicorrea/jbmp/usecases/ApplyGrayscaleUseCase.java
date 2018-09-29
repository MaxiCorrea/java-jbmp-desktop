package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.domain.Size;
import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.requests.DataPixelRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyGrayscaleUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    Image result = new Image(new Size(request.height, request.width));
    for (int currentRow = 0; currentRow < request.height; ++currentRow) {
      for (int currentCol = 0; currentCol < request.width; ++currentCol) {
        DataPixelRequest dpx = request.pixels[currentRow][currentCol];
        Pixel pixel = new Pixel(dpx.red, dpx.green, dpx.blue);
        result.setPixel(currentRow, currentCol, Pixel.averageOfChannels(pixel));
      }
    }
    return new DataImageResponse(result);
  }

  @Override
  public String getName() {
    return "Grayscale";
  }

}
