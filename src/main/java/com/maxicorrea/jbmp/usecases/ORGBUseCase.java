package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class ORGBUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image.getSize());
    for (int row = 0; row < result.getSize().getHeight(); ++row) {
      for (int col = 0; col < result.getSize().getWidth(); ++col) {
        if (row < result.getSize().getHeight() / 2 &&
            col < result.getSize().getWidth() / 2) {
          result.setPixel(row, col, image.getPixel(row, col));
          continue;
        }
        Pixel px = image.getPixel(row, col);
        if (row < result.getSize().getHeight() / 2 &&
            col >= result.getSize().getWidth() / 2) {
          result.setPixel(row, col, new Pixel(px.getRed(), 0, 0));
          continue;
        }
        if (row >= result.getSize().getHeight() / 2 &&
            col < result.getSize().getWidth() / 2) {
          result.setPixel(row, col, new Pixel(0, 0, px.getBlue()));
          continue;
        }
        result.setPixel(row, col, new Pixel(0, px.getGreen(), 0));
      }
    }
    return result;
  }

}
