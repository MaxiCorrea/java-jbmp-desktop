package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class LeftUseCase implements UseCase {

  public LeftUseCase(Image image) {

  }


  public void execute() {
    /*
     * image = new Image(Size.invert(image.getSize())); for (int row = 0; row < request.width;
     * ++row) { for (int col = 0; col < request.height; ++col) { DataPixelRequest dpr =
     * request.pixels[col][request.width - row]; image.setPixel(row, col, new Pixel(dpr.red,
     * dpr.green, dpr.blue)); } } ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Left";
  }

}
