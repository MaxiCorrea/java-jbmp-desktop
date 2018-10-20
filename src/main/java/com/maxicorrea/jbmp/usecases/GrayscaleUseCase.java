package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class GrayscaleUseCase implements UseCase {

  public GrayscaleUseCase(Image image) {

  }

  public void execute() {
    /*
     * image = new Image(new Size(request.height, request.width)); for (int currentRow = 0;
     * currentRow < request.height; ++currentRow) { for (int currentCol = 0; currentCol <
     * request.width; ++currentCol) { DataPixelRequest dpx = request.pixels[currentRow][currentCol];
     * Pixel pixel = new Pixel(dpx.red, dpx.green, dpx.blue); image.setPixel(currentRow, currentCol,
     * Pixel.averageOfChannels(pixel)); } } ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Grayscale";
  }

}
