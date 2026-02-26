package com.maxicorrea.jbmp.domain.service;

import static com.maxicorrea.jbmp.domain.model.Pixel.MAX_VALUE;
import static java.lang.Math.min;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class ContrastFilter implements ImageFilter {

  private final double value;

  public ContrastFilter() {
    this(1.5);
  }

  public ContrastFilter(double value) {
    this.value = value;
  }

  @Override
  public Image apply(Image image) {
    Image result = new Image(image.getSize());
    for (int row = 0; row < result.getSize().getHeight(); ++row) {
      for (int col = 0; col < result.getSize().getWidth(); ++col) {
        Pixel px = image.getPixel(row, col);
        int r = (int) (px.getRed() * value);
        int g = (int) (px.getGreen() * value);
        int b = (int) (px.getBlue() * value);
        result.setPixel(row, col, new Pixel(min(r, MAX_VALUE),
                                            min(g, MAX_VALUE),
                                            min(b, MAX_VALUE)));
      }
    }
    return result;
  }

}
