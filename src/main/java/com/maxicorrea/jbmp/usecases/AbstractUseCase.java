package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.presentation.AppViewContext;

abstract class AbstractUseCase implements UseCase {

  @Override
  public void execute() {
    Image currentImage = AppViewContext.imageView.getImage();
    if(currentImage != null) {
      Image result = applyAlgorithm(currentImage);
      AppViewContext.imageView.updateImage(result);
    } else {
      AppViewContext.appView.showAlert("No image");
    }
  }
  
  abstract Image applyAlgorithm(Image currentImage);
  
}
