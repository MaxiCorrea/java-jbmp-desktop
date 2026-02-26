package com.maxicorrea.jbmp.application.usecase;

import com.maxicorrea.jbmp.application.port.in.ApplyFilterUseCase;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.model.Image;

public class ResetImageUseCaseImpl implements ApplyFilterUseCase {

  private final ImagePresenter imagePresenter;
  private final UserNotifier userNotifier;
  private Image originalImage;

  public ResetImageUseCaseImpl(ImagePresenter imagePresenter, UserNotifier userNotifier) {
    this.imagePresenter = imagePresenter;
    this.userNotifier = userNotifier;
  }

  public void setOriginal(Image image) {
    this.originalImage = new Image(image);
  }

  @Override
  public void execute() {
    if (originalImage != null) {
      imagePresenter.displayImage(originalImage);
    } else {
      userNotifier.showAlert("No image");
    }
  }

}
