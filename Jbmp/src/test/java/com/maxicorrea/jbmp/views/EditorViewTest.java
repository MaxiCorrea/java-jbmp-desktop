package com.maxicorrea.jbmp.views;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import com.maxicorrea.jbmp.views.utils.TextLabels;

public class EditorViewTest {
  
  @Test
  public void  shouldCreateTheEssentialItems() {
    ImageView imageView = mock(ImageView.class);
    EditorView editorView = new EditorView(imageView);
    assertNotNull(editorView.getEssentialItems());
    assertEquals(3 ,editorView.getEssentialItems().getSubItems().size());
    assertEquals(TextLabels.OPEN , editorView.getEssentialItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.SAVE , editorView.getEssentialItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.RESET , editorView.getEssentialItems().getSubItems().get(2).getButton().getText());
  }
  
  @Test
  public void  shouldCreateTheFilterItems() {
    ImageView imageView = mock(ImageView.class);
    EditorView editorView = new EditorView(imageView);
    assertNotNull(editorView.getFilterItems());
    assertEquals(3 ,editorView.getFilterItems().getSubItems().size());
    assertEquals(TextLabels.GRAYSCALE , editorView.getFilterItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.NEGATIVE,editorView.getFilterItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.SEPIA , editorView.getFilterItems().getSubItems().get(2).getButton().getText());
  }
 
  @Test
  public void  shouldCreateTheFlipsItems() {
    ImageView imageView = mock(ImageView.class);
    EditorView editorView = new EditorView(imageView);
    assertNotNull(editorView.getFlipItems());
    assertEquals(4 ,editorView.getFlipItems().getSubItems().size());
    assertEquals(TextLabels.VERTICAL , editorView.getFlipItems().getSubItems().get(0).getButton().getText());
    assertEquals(TextLabels.HORIZONTAL,editorView.getFlipItems().getSubItems().get(1).getButton().getText());
    assertEquals(TextLabels.RIGHT , editorView.getFlipItems().getSubItems().get(2).getButton().getText());
    assertEquals(TextLabels.LEFT , editorView.getFlipItems().getSubItems().get(3).getButton().getText());
  }
    
  @Test
  public void shouldBeAbleToShowTheFrame() {
    ImageView imageView = mock(ImageView.class);
    EditorView editorView = new EditorView(imageView);
    editorView.show();
    assertTrue(editorView.getMainFrame().isVisible());
  }
  
}
