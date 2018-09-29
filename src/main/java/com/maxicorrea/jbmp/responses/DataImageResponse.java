package com.maxicorrea.jbmp.responses;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;

public class DataImageResponse {

  public int height;
  public int width;
  public DataPixelResponse[][] pixels;
  
  public DataImageResponse(Image image) {
    height = image.getSize().getHeight();
    width = image.getSize().getWidth();
    pixels = new DataPixelResponse[height][width];
    for( int i = 0 ; i < height ; ++i) {
      for( int j = 0 ; j < width ; ++j) {
        Pixel px = image.getPixel(i, j);
        pixels[i][j] = new DataPixelResponse(px);
      }
    }
  }

}
