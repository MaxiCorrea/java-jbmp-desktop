package com.maxicorrea.jbmp.usecases;

public class AppUseCasesContext {

  public static UseCase applyBlurUseCase;

  public static UseCase applyEdgesUseCase;
  
  public static UseCase applyGrayscaleUseCase;

  public static UseCase applyHorizontalUseCase;
  
  public static UseCase applyRedUseCase;
  
  public static UseCase applyGreenUseCase;
  
  public static UseCase applyBlueUseCase;
  
  public static UseCase applyORGBUseCase;
  
  public static UseCase applyLeftUseCase;

  public static UseCase applyNegativeUseCase;

  public static UseCase applyResetUseCase;

  public static UseCase applyRightUseCase;

  public static UseCase applySepiaUseCase;

  public static UseCase applyVerticalUseCase;

  public static UseCase openImageUseCase;

  public static UseCase saveImageUseCase;

  public static UseCase applyConstrastUseCase;
  
  public static UseCase applyGridUseCase;
  
  public AppUseCasesContext() {
    applyBlurUseCase = new BlurUseCase();
    applyEdgesUseCase = new EdgesUseCase();
    applyGrayscaleUseCase = new GrayscaleUseCase();
    applyHorizontalUseCase = new HorizontalUseCase();
    applyRedUseCase = new RedUseCase();
    applyGreenUseCase = new GreenUseCase();
    applyBlueUseCase = new BlueUseCase();
    applyLeftUseCase = new LeftUseCase();
    applyNegativeUseCase = new NegativeUseCase();
    applyResetUseCase = new ResetUseCase();
    applyRightUseCase = new RightUseCase();
    applySepiaUseCase = new SepiaUseCase();
    applyGridUseCase = new GridUseCase();
    applyORGBUseCase = new ORGBUseCase();
    applyVerticalUseCase = new VerticalUseCase();
    openImageUseCase = new OpenImageUseCase();
    saveImageUseCase = new SaveUseCase();
    applyConstrastUseCase = new ContrastUseCase();
  }

}
