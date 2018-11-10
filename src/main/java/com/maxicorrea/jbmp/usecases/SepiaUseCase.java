package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class SepiaUseCase extends AbstractUseCase {

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image);
    for (int row = 0; row < image.getSize().getHeight(); ++row) {
      for (int col = 0; col < image.getSize().getWidth(); ++col) {
        final Pixel px = image.getPixel(row, col);
        int r = ((int) (.393 * px.getRed() + .769 * px.getGreen() + .189 * px.getBlue()));
        int g = ((int) (.349 * px.getRed() + .686 * px.getGreen() + .168 * px.getBlue()));
        int b = ((int) (.272 * px.getRed() + .534 * px.getGreen() + .131 * px.getBlue()));
        result.setPixel(row, col, new Pixel(r, g, b));
      }
    }
    return result;
  }
}
