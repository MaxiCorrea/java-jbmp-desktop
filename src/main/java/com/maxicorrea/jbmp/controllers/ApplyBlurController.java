package com.maxicorrea.jbmp.controllers;

import com.maxicorrea.jbmp.presenters.ImagePresenter;
import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;
import com.maxicorrea.jbmp.usecases.ApplyBlurUseCase;

public class ApplyBlurController {

  private final ImagePresenter imagePresenter;
  private final ApplyBlurUseCase useCase;

  public ApplyBlurController(ImagePresenter presenter, ApplyBlurUseCase useCase) {
    this.imagePresenter = presenter;
    this.useCase = useCase;
  }

  public void execute(DataImageRequest request) {
    DataImageResponse response = useCase.execute(request);
    imagePresenter.update(response);
  }

}
