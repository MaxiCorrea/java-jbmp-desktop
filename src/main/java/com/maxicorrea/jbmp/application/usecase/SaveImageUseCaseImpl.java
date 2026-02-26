package com.maxicorrea.jbmp.application.usecase;

import java.io.File;
import com.maxicorrea.jbmp.application.port.in.SaveImageUseCase;
import com.maxicorrea.jbmp.application.port.out.FileSelector;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.ImageRepository;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.ImageSaveException;
import com.maxicorrea.jbmp.domain.model.Image;

public class SaveImageUseCaseImpl implements SaveImageUseCase {

  private final FileSelector fileSelector;
  private final ImageRepository imageRepository;
  private final ImagePresenter imagePresenter;
  private final UserNotifier userNotifier;

  public SaveImageUseCaseImpl(FileSelector fileSelector, ImageRepository imageRepository,
      ImagePresenter imagePresenter, UserNotifier userNotifier) {
    this.fileSelector = fileSelector;
    this.imageRepository = imageRepository;
    this.imagePresenter = imagePresenter;
    this.userNotifier = userNotifier;
  }

  @Override
  public void execute() {
    Image current = imagePresenter.getCurrentImage();
    if (current == null) {
      userNotifier.showAlert("No image");
      return;
    }
    try {
      File file = fileSelector.selectFileToSave();
      if (file != null) {
        imageRepository.save(current, file);
        userNotifier.showAlert("Image Saved");
      }
    } catch (ImageSaveException e) {
      userNotifier.showError(e.getMessage());
    }
  }

}
