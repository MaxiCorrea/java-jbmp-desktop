package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class HorizontalUseCase implements UseCase {

  public HorizontalUseCase(Image image) {

  }

  public void execute() {
    /*
     * image = new Image(new Size(request.height, request.width)); for (int row = 0; row <
     * request.height; ++row) { for (int col = 0; col < request.width; ++col) { DataPixelRequest dpx
     * = request.pixels[row][col]; Pixel pixel = new Pixel(dpx.red, dpx.green, dpx.blue);
     * image.setPixel(row, request.width - 1 - col, pixel); } }
     * ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Horizontal";
  }

}
