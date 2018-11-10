package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class ResetUseCase extends AbstractUseCase {

  private Image original;
  
  public void setOriginal(Image image) {
    this.original = new Image(image);
  }
  
  @Override
  Image applyAlgorithm(Image currentImage) {
    return original;
  }

}
