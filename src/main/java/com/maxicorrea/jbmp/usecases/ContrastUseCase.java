package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Pixel.MAX_VALUE;
import static java.lang.Math.min;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class ContrastUseCase extends AbstractUseCase {

  private static double value = 1.5;

  @Override
  Image applyAlgorithm(Image image) {
    Image result = new Image(image.getSize());
    for (int row = 0; row < result.getSize().getHeight(); ++row) {
      for (int col = 0; col < result.getSize().getWidth(); ++col) {
        Pixel px = image.getPixel(row, col);
        int r = (int) (px.getRed() * value);
        int g = (int) (px.getGreen() * value);
        int b = (int) (px.getBlue() * value);
        result.setPixel(row, col, new Pixel(min(r, MAX_VALUE) ,
                                            min(g, MAX_VALUE) , 
                                            min(b, MAX_VALUE)));
      }
    }
    return result;
  }

}
