package com.maxicorrea.jbmp.application.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;

public class ResetImageUseCaseImplTest {

  private ImagePresenter imagePresenter;
  private UserNotifier userNotifier;
  private ResetImageUseCaseImpl useCase;

  @Before
  public void setUp() {
    imagePresenter = mock(ImagePresenter.class);
    userNotifier = mock(UserNotifier.class);
    useCase = new ResetImageUseCaseImpl(imagePresenter, userNotifier);
  }

  @Test
  public void shouldDisplayOriginalImage() {
    Image original = new Image(new Size(1, 1));
    original.setPixel(0, 0, new Pixel(10, 20, 30));
    useCase.setOriginal(original);

    useCase.execute();

    verify(imagePresenter).displayImage(original);
  }

  @Test
  public void shouldShowAlertWhenNoOriginal() {
    useCase.execute();
    verify(userNotifier).showAlert("No image");
  }

}
