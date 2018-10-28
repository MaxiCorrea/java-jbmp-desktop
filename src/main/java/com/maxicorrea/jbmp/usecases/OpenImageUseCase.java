package com.maxicorrea.jbmp.usecases;

import static com.maxicorrea.jbmp.usecases.AppUseCasesContext.applyResetUseCase;
import java.io.File;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.persistence.BmpInputException;
import com.maxicorrea.jbmp.persistence.ImageReader;
import com.maxicorrea.jbmp.presentation.AppViewContext;

public class OpenImageUseCase implements UseCase {

  public void execute() {
    try {
      File file = AppViewContext.appView.getOpenFile();
      if (file != null && file.exists()) {
        Image image = new ImageReader().read(file);
        ((ResetUseCase) applyResetUseCase).setOriginal(image);
        AppViewContext.imageView.updateImage(image);
      }
    } catch (BmpInputException e) {
      AppViewContext.appView.showError(e.getMessage());
    }
  }
}
