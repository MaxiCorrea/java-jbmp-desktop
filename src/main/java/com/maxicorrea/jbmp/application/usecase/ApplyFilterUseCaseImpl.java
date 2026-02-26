package com.maxicorrea.jbmp.application.usecase;

import com.maxicorrea.jbmp.application.port.in.ApplyFilterUseCase;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.service.ImageFilter;

public class ApplyFilterUseCaseImpl implements ApplyFilterUseCase {

  private final ImageFilter filter;
  private final ImagePresenter imagePresenter;
  private final UserNotifier userNotifier;

  public ApplyFilterUseCaseImpl(ImageFilter filter, ImagePresenter imagePresenter,
      UserNotifier userNotifier) {
    this.filter = filter;
    this.imagePresenter = imagePresenter;
    this.userNotifier = userNotifier;
  }

  @Override
  public void execute() {
    Image current = imagePresenter.getCurrentImage();
    if (current != null) {
      Image result = filter.apply(current);
      imagePresenter.displayImage(result);
    } else {
      userNotifier.showAlert("No image");
    }
  }

}
