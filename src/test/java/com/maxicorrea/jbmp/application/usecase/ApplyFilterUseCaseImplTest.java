package com.maxicorrea.jbmp.application.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.any;
import org.junit.Before;
import org.junit.Test;
import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.application.port.out.UserNotifier;
import com.maxicorrea.jbmp.domain.model.Image;
import com.maxicorrea.jbmp.domain.model.Pixel;
import com.maxicorrea.jbmp.domain.model.Size;
import com.maxicorrea.jbmp.domain.service.ImageFilter;

public class ApplyFilterUseCaseImplTest {

  private ImageFilter filter;
  private ImagePresenter imagePresenter;
  private UserNotifier userNotifier;
  private ApplyFilterUseCaseImpl useCase;

  @Before
  public void setUp() {
    filter = mock(ImageFilter.class);
    imagePresenter = mock(ImagePresenter.class);
    userNotifier = mock(UserNotifier.class);
    useCase = new ApplyFilterUseCaseImpl(filter, imagePresenter, userNotifier);
  }

  @Test
  public void shouldApplyFilterAndDisplayResult() {
    Image current = new Image(new Size(1, 1));
    current.setPixel(0, 0, new Pixel(100, 100, 100));
    Image filtered = new Image(new Size(1, 1));
    filtered.setPixel(0, 0, new Pixel(50, 50, 50));

    when(imagePresenter.getCurrentImage()).thenReturn(current);
    when(filter.apply(current)).thenReturn(filtered);

    useCase.execute();

    verify(filter).apply(current);
    verify(imagePresenter).displayImage(filtered);
  }

  @Test
  public void shouldShowAlertWhenNoImage() {
    when(imagePresenter.getCurrentImage()).thenReturn(null);

    useCase.execute();

    verify(userNotifier).showAlert("No image");
    verify(filter, never()).apply(any());
  }

}
