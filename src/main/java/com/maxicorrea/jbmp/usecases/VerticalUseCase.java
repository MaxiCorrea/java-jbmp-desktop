package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class VerticalUseCase implements UseCase {


  public VerticalUseCase(Image image) {

  }


  public void execute() {
    /*
     * for (int col = 0; col < request.height; ++col) { for (int row = 0; row < request.width;
     * ++row) { Pixel pixel = image.getPixel(row, col); image.setPixel(request.width - 1 - row, col,
     * pixel); } } ViewContext.imageView.updateImage(image);
     */
  }


  public String getName() {
    return "Vertical";
  }

}
