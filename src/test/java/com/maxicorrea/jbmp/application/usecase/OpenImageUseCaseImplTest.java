package com.maxicorrea.jbmp.application.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.any;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import com.maxicorrea.jbmp.application.port.out.FileSelector;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.ImageRepository;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.ImageLoadException;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class OpenImageUseCaseImplTest {

  private FileSelector fileSelector;
  private ImageRepository imageRepository;
  private ImagePresenter imagePresenter;
  private UserNotifier userNotifier;
  private ResetImageUseCaseImpl resetUseCase;
  private OpenImageUseCaseImpl useCase;

  @Before
  public void setUp() {
    fileSelector = mock(FileSelector.class);
    imageRepository = mock(ImageRepository.class);
    imagePresenter = mock(ImagePresenter.class);
    userNotifier = mock(UserNotifier.class);
    resetUseCase = mock(ResetImageUseCaseImpl.class);
    useCase = new OpenImageUseCaseImpl(fileSelector, imageRepository,
        imagePresenter, userNotifier, resetUseCase);
  }

  @Test
  public void shouldLoadAndDisplayImage() throws Exception {
    File file = mock(File.class);
    when(file.exists()).thenReturn(true);
    when(fileSelector.selectFileToOpen()).thenReturn(file);
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(10, 20, 30));
    when(imageRepository.load(file)).thenReturn(image);

    useCase.execute();

    verify(imageRepository).load(file);
    verify(resetUseCase).setOriginal(image);
    verify(imagePresenter).displayImage(image);
  }

  @Test
  public void shouldDoNothingWhenFileIsNull() throws Exception {
    when(fileSelector.selectFileToOpen()).thenReturn(null);

    useCase.execute();

    verify(imageRepository, never()).load(any());
  }

  @Test
  public void shouldShowErrorOnLoadFailure() throws Exception {
    File file = mock(File.class);
    when(file.exists()).thenReturn(true);
    when(fileSelector.selectFileToOpen()).thenReturn(file);
    when(imageRepository.load(file)).thenThrow(new ImageLoadException("Error reading the image."));

    useCase.execute();

    verify(userNotifier).showError("Error reading the image.");
  }

}
