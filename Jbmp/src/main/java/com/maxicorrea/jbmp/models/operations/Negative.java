package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Operation;
import com.maxicorrea.jbmp.models.core.Pixel;

class Negative implements Operation {

  @Override
  public Image apply(Image image) {
    Image result = new Image(image); 
    for(Pixel pixel : result) {
      pixel.setRed(Pixel.MAX_VALUE - pixel.getRed());
      pixel.setGreen(Pixel.MAX_VALUE - pixel.getGreen());
      pixel.setBlue(Pixel.MAX_VALUE - pixel.getBlue());
    }
    return result;
  }
  
  @Override
  public String getName() {
    return "Negative";
  }
  
}
