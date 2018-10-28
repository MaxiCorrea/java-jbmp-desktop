package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Size.invert;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class LeftUseCase extends AbstractUseCase {

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    if (!checkPrecondition(image)) {
      return;
    }
    Image result = new Image(invert(image.getSize()));
    for (int i = 0; i < result.getSize().getHeight(); ++i) {
      for (int j = 0; j < result.getSize().getWidth(); ++j) {
        Pixel pixel = image.getPixel(j, image.getSize().getWidth() - 1 - i);
        result.setPixel(i, j, pixel);
      }
    }
    AppViewContext.imageView.updateImage(result);
  }
}
