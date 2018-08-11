package com.maxicorrea.jbmp.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import javax.swing.JScrollPane;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public class ImageViewTest {

  private static final String ANY_MESSAGE = "";

  @Test
  public void initiallyTheLabelsShouldBeWithoutText() {
    ImageView imageView = new ImageView();
    assertTrue(imageView.getImageLabel().getText().isEmpty());
    assertTrue(imageView.getMessageLabel().getText().isEmpty());
  }

  @Test
  public void initiallyTheImageLabelMustBeContainedInAPane() {
    ImageView imageView = new ImageView();
    JScrollPane panel = imageView.getImgPane();
    assertEquals(imageView.getImageLabel(), panel.getViewport().getView());
  }

  @Test
  public void shouldBeAbleToChangeThePropertiesOfTheMessage() {
    ImageView imageView = new ImageView();
    imageView.messageLabel(Color.RED, Color.BLUE, false, ANY_MESSAGE);
    assertEquals(Color.RED, imageView.getMessageLabel().getBackground());
    assertEquals(Color.BLUE, imageView.getMessageLabel().getForeground());
    assertEquals(ANY_MESSAGE, imageView.getMessageLabel().getText());
  }

  @Test
  public void shouldBeAbleToSendErrorMessagesAndSimpleMessages() {
    ImageView imageView = new ImageView();
    imageView.showErrorMessage(ANY_MESSAGE);
    imageView.showMessage(ANY_MESSAGE);
    assertEquals(ANY_MESSAGE, imageView.getMessageLabel().getText());
  }

  @Test
  public void shouldBeAbleToUpdateTheImage() {
    ImageView imageView = new ImageView();
    Image image = new Image(new Size(1, 1));
    image.setPixel(0, 0, new Pixel(1, 1, 1));
    imageView.update(image);
  }

}
