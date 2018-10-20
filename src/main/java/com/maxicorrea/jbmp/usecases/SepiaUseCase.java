package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class SepiaUseCase implements UseCase {

  public SepiaUseCase(Image image) {}

  public void execute() {
    /*
     * for (int row = 0; row < request.height; ++row) { for (int col = 0; col < request.width;
     * ++col) { final Pixel px = image.getPixel(row, col); int r = ((int) (.393 * px.getRed() + .769
     * * px.getGreen() + .189 * px.getBlue())); int g = ((int) (.349 * px.getRed() + .686 *
     * px.getGreen() + .168 * px.getBlue())); int b = ((int) (.272 * px.getRed() + .534 *
     * px.getGreen() + .131 * px.getBlue())); image.setPixel(row, col, new Pixel(r, g, b)); } }
     * ViewContext.imageView.updateImage(image);
     */
  }

  public String getName() {
    return "Sepia";
  }

}
