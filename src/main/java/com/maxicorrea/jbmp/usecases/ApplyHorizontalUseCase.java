package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.domain.Size;
import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.requests.DataPixelRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyHorizontalUseCase implements UseCase<DataImageResponse , DataImageRequest> {

  @Override
  public DataImageResponse execute(DataImageRequest request) {
    Image result = new Image(new Size(request.height, request.width));
    Size size = result.getSize();
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        DataPixelRequest dpx = request.pixels[row][col];
        Pixel pixel = new Pixel(dpx.red, dpx.green, dpx.blue);
        result.setPixel(row, size.getWidth() - 1 - col , pixel);
      }
    }
    return new DataImageResponse(result);
  }

  @Override
  public String getName() {
    return "Horizontal";
  }

}
