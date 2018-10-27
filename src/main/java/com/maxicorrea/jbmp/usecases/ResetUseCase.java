package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class ResetUseCase implements UseCase {

  private Image original;
  
  public void setOriginal(Image image) {
    this.original = new Image(image);
  }
  
  @Override
  public void execute() {
    AppViewContext.imageView.updateImage(original);
  }

}
