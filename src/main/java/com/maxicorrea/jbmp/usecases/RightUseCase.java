package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class RightUseCase implements UseCase {


  public RightUseCase(Image image) {}

  public void execute() {
    /*
     * image = new Image(new Size(request.width, request.height)); for (int row = 0; row <
     * request.width; ++row) { for (int col = 0; col < request.height; ++col) { DataPixelRequest dpx
     * = request.pixels[request.height - 1 - col][row]; Pixel pixel = new Pixel(dpx.red, dpx.green,
     * dpx.blue); image.setPixel(row, col, pixel); } } ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Right";
  }

}
