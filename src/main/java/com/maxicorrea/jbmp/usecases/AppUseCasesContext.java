package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;

public class AppUseCasesContext {

  public static UseCase applyBlurUseCase;

  public static UseCase applyEdgesUseCase;

  public static UseCase applyGrayscaleUseCase;

  public static UseCase applyHorizontalUseCase;

  public static UseCase applyLeftUseCase;

  public static UseCase applyNegativeUseCase;

  public static UseCase applyResetUseCase;

  public static UseCase applyRightUseCase;

  public static UseCase applySepiaUseCase;

  public static UseCase applyVerticalUseCase;

  public static UseCase openImageUseCase;

  public static UseCase saveImageUseCase;

  public AppUseCasesContext(Image image) {
    applyBlurUseCase = new BlurUseCase(image);
    applyEdgesUseCase = new EdgesUseCase(image);
    applyGrayscaleUseCase = new GrayscaleUseCase(image);
    applyHorizontalUseCase = new HorizontalUseCase(image);
    applyLeftUseCase = new LeftUseCase(image);
    applyNegativeUseCase = new NegativeUseCase(image);
    applyResetUseCase = new ResetUseCase(image);
    applyRightUseCase = new RightUseCase(image);
    applySepiaUseCase = new SepiaUseCase(image);
    applyVerticalUseCase = new VerticalUseCase(image);
    openImageUseCase = new OpenImageUseCase(image);
    saveImageUseCase = new SaveUseCase(image);
  }

}
