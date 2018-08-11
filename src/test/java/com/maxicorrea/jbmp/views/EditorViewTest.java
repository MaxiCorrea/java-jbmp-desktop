package com.maxicorrea.jbmp.views;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.views.utils.TextLabels;

public class EditorViewTest {

  @Test
  public void shouldCreateTheEssentialItems() {
    EditorView editorView = new EditorView(new ImageView());
    assertNotNull(editorView.getEssentialItems());
    assertEquals(3, editorView.getEssentialItems().getSubItems().size());
    assertEquals(TextLabels.OPEN,
        editorView.getEssentialItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.SAVE,
        editorView.getEssentialItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.RESET,
        editorView.getEssentialItems().getSubItems().get(2).getButton().getText());
  }

  @Test
  public void shouldCreateTheFilterItems() {
    EditorView editorView = new EditorView(new ImageView());
    assertNotNull(editorView.getFilterItems());
    assertEquals(5, editorView.getFilterItems().getSubItems().size());
    assertEquals(TextLabels.GRAYSCALE,
        editorView.getFilterItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.NEGATIVE,
        editorView.getFilterItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.SEPIA,
        editorView.getFilterItems().getSubItems().get(2).getButton().getText());
  }

  @Test
  public void shouldCreateTheFlipsItems() {
    EditorView editorView = new EditorView(new ImageView());
    assertNotNull(editorView.getFlipItems());
    assertEquals(4, editorView.getFlipItems().getSubItems().size());
    assertEquals(TextLabels.VERTICAL,
        editorView.getFlipItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.HORIZONTAL,
        editorView.getFlipItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.RIGHT,
        editorView.getFlipItems().getSubItems().get(2).getButton().getText());
    assertEquals(TextLabels.LEFT,
        editorView.getFlipItems().getSubItems().get(3).getButton().getText());
  }

  @Test
  public void shouldBeAbleToSendMessages() {
    EditorView editorView = new EditorView(new ImageView());
    editorView.showErrorMessage("");
    editorView.showMessage("");
  }

  @Test
  public void shouldReturnImageView() {
    ImageView imageView = new ImageView();
    EditorView editorView = new EditorView(imageView);
    assertSame(imageView, editorView.getImageView());
  }

}
