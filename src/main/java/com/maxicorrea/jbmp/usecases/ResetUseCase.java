package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class ResetUseCase extends AbstractUseCase {

  private Image original;
  
  public void setOriginal(Image image) {
    this.original = new Image(image);
  }
  
  @Override
  public void execute() {
    if(checkPrecondition(original)) {
      AppViewContext.imageView.updateImage(original);
    }
  }

}
