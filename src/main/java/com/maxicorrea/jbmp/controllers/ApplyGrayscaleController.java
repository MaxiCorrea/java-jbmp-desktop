package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;
import com.maxicorrea.jbmp.usecases.ApplyGrayscaleUseCase;

public class ApplyGrayscaleController {

  private final ApplyGrayscaleUseCase useCase;
  
  public ApplyGrayscaleController(ApplyGrayscaleUseCase useCase) {
    this.useCase = useCase;
  }
  
  public DataImageResponse execute(DataImageRequest request) {
    return useCase.execute(request);
  }
  
}
