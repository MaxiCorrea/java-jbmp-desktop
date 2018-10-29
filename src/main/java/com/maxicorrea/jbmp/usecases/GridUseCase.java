package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.domain.Pixel.BLACK;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.domain.Size;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class GridUseCase extends AbstractUseCase {

  @Override
  public void execute() {
    Image image = AppViewContext.imageView.getImage();
    if (!checkPrecondition(image)) {
      return;
    }
    int height = image.getSize().getHeight();
    int width = image.getSize().getWidth();
    Image result = new Image(image.getSize());
    Image mini = reduce(image, 2, 2);

    for (int r = 0, r2 = 0; r < height / 2; ++r, ++r2) {
      for (int c = 0, c2 = 0; c < width / 2; ++c, ++c2) {
        if(r2 < mini.getSize().getHeight() &&
           c2 < mini.getSize().getWidth()) {
          result.setPixel(r, c, mini.getPixel(r2, c2));
        } else {
          result.setPixel(r, c, BLACK);
        }
      }
    }

    for (int r = 0, r2 = 0; r < height / 2; ++r, ++r2) {
      for (int c = width / 2, c2 = 0; c < width; ++c, ++c2) {
        if(r2 < mini.getSize().getHeight() &&
            c2 < mini.getSize().getWidth()) {
           result.setPixel(r, c, mini.getPixel(r2, c2));
         } else {
           result.setPixel(r, c, BLACK);
         }
      }
    }

    for (int r = height / 2, r2 = 0; r < height; ++r, ++r2) {
      for (int c = 0, c2 = 0; c < width / 2; ++c, ++c2) {
        if(r2 < mini.getSize().getHeight() &&
            c2 < mini.getSize().getWidth()) {
           result.setPixel(r, c, mini.getPixel(r2, c2));
         } else {
           result.setPixel(r, c, BLACK);
         }
      }
    }

    for (int r = height / 2, r2 = 0; r < height; ++r, ++r2) {
      for (int c = width / 2, c2 = 0; c < width; ++c, ++c2) {
        if(r2 < mini.getSize().getHeight() &&
            c2 < mini.getSize().getWidth()) {
           result.setPixel(r, c, mini.getPixel(r2, c2));
         } else {
           result.setPixel(r, c, BLACK);
         }
      }
    }

    AppViewContext.imageView.updateImage(result);
  }

  private static Image reduce(Image image, int sy, int sx) {
    int heightO = image.getSize().getHeight();
    int widthO = image.getSize().getWidth();
    int heightR = (heightO / sy);
    int widthR = (widthO / sx);
    Image result = new Image(new Size(heightR, widthR));
    int i = 0;
    for (int f = 0; i < heightO; f++) {
      int j = 0;
      for (int c = 0; j < widthO; c++) {
        int newR = 0;
        int newG = 0;
        int newB = 0;
        for (int a = i; (a < i + sy) && (a < heightO); a++) {
          for (int b = j; (b < j + sx) && (b < widthO); b++) {
            newR += image.getPixel(a, b).getRed();
            newG += image.getPixel(a, b).getGreen();
            newB += image.getPixel(a, b).getBlue();
          }
        }
        newR /= sx * sy;
        newG /= sx * sy;
        newB /= sx * sy;
        if ((f < heightR) && (c < widthR)) {
          result.setPixel(f, c, new Pixel(newR, newG, newB));
        }
        j += sx;
      }
      i += sy;
    }
    return result;
  }

  
}
