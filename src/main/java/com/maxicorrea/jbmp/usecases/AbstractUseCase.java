package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.presentation.AppViewContext;

abstract class AbstractUseCase implements UseCase {

  boolean checkPrecondition(Image image) {
    if (image == null) {
      AppViewContext.appView.showAlert("No image");
      return false;
    }
    return true;
  }

}
