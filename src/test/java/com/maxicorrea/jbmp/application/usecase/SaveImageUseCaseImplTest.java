package com.maxicorrea.jbmp.application.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import com.maxicorrea.jbmp.application.port.out.FileSelector;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.ImageRepository;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.ImageSaveException;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class SaveImageUseCaseImplTest {

  private FileSelector fileSelector;
  private ImageRepository imageRepository;
  private ImagePresenter imagePresenter;
  private UserNotifier userNotifier;
  private SaveImageUseCaseImpl useCase;

  @Before
  public void setUp() {
    fileSelector = mock(FileSelector.class);
    imageRepository = mock(ImageRepository.class);
    imagePresenter = mock(ImagePresenter.class);
    userNotifier = mock(UserNotifier.class);
    useCase = new SaveImageUseCaseImpl(fileSelector, imageRepository,
        imagePresenter, userNotifier);
  }

  @Test
  public void shouldSaveImageToFile() throws Exception {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(10, 20, 30));
    File file = mock(File.class);
    when(imagePresenter.getCurrentImage()).thenReturn(image);
    when(fileSelector.selectFileToSave()).thenReturn(file);

    useCase.execute();

    verify(imageRepository).save(image, file);
  }

  @Test
  public void shouldShowAlertWhenNoImage() {
    when(imagePresenter.getCurrentImage()).thenReturn(null);

    useCase.execute();

    verify(userNotifier).showAlert("No image");
  }

  @Test
  public void shouldDoNothingWhenFileIsNull() throws Exception {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(10, 20, 30));
    when(imagePresenter.getCurrentImage()).thenReturn(image);
    when(fileSelector.selectFileToSave()).thenReturn(null);

    useCase.execute();

    verify(imageRepository, never()).save(any(), any());
  }

  @Test
  public void shouldShowErrorOnSaveFailure() throws Exception {
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(10, 20, 30));
    File file = mock(File.class);
    when(imagePresenter.getCurrentImage()).thenReturn(image);
    when(fileSelector.selectFileToSave()).thenReturn(file);
    doThrow(new ImageSaveException("Error saving the image"))
        .when(imageRepository).save(image, file);

    useCase.execute();

    verify(userNotifier).showError("Error saving the image");
  }

}
