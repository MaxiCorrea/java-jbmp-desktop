package com.maxicorrea.jbmp.domain.service;

import static com.maxicorrea.jbmp.domain.model.Size.invert;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;

public class RotateRight implements ImageFilter {

  @Override
  public Image apply(Image image) {
    Image result = new Image(invert(image.getSize()));
    for (int i = 0; i < image.getSize().getWidth(); ++i) {
      for (int j = 0; j < image.getSize().getHeight(); ++j) {
        Pixel pixel = image.getPixel(image.getSize().getHeight() - 1 - j, i);
        result.setPixel(i, j, pixel);
      }
    }
    return result;
  }

}
