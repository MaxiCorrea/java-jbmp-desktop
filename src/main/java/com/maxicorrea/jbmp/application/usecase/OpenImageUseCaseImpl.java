package com.maxicorrea.jbmp.application.usecase;

import java.io.File;
import com.maxicorrea.jbmp.application.port.in.OpenImageUseCase;
import com.maxicorrea.jbmp.application.port.out.FileSelector;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.ImageRepository;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.ImageLoadException;
import com.maxicorrea.jbmp.domain.model.Image;

public class OpenImageUseCaseImpl implements OpenImageUseCase {

  private final FileSelector fileSelector;
  private final ImageRepository imageRepository;
  private final ImagePresenter imagePresenter;
  private final UserNotifier userNotifier;
  private final ResetImageUseCaseImpl resetUseCase;

  public OpenImageUseCaseImpl(FileSelector fileSelector, ImageRepository imageRepository,
      ImagePresenter imagePresenter, UserNotifier userNotifier,
      ResetImageUseCaseImpl resetUseCase) {
    this.fileSelector = fileSelector;
    this.imageRepository = imageRepository;
    this.imagePresenter = imagePresenter;
    this.userNotifier = userNotifier;
    this.resetUseCase = resetUseCase;
  }

  @Override
  public void execute() {
    try {
      File file = fileSelector.selectFileToOpen();
      if (file != null && file.exists()) {
        Image image = imageRepository.load(file);
        resetUseCase.setOriginal(image);
        imagePresenter.displayImage(image);
      }
    } catch (ImageLoadException e) {
      userNotifier.showError(e.getMessage());
    }
  }

}
