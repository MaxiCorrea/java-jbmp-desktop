package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class NegativeUseCase implements UseCase {


  public NegativeUseCase(Image image) {}


  public void execute() {
    /*
     * for (int row = 0; row < request.height; ++row) { for (int col = 0; col < request.width;
     * ++col) { image.setPixel(row, col, Pixel.negate(image.getPixel(row, col))); } }
     * ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Negative";
  }

}
