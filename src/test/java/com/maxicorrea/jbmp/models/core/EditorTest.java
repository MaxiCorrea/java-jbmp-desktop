package com.maxicorrea.jbmp.models.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class EditorTest {

  @Test
  public void shouldNotHaveAnImageWhenCreating() {
    Editor editor = new Editor();
    assertNull(editor.getSourceImage());
    assertNull(editor.getEditedImage());
  }

  @Test
  public void shouldBeAbleToEstablishTheSourceImage() {
    Editor editor = new Editor();
    editor.setSourceImage( new Image( new Size(40,40)));
    assertEquals(new Image(new Size(40,40)) , editor.getSourceImage());
    assertEquals(new Image(new Size(40,40)) , editor.getEditedImage());
  }
  
  @Test
  public void shouldBeAbleToApplyAnOperation() {
    Operation operation = mock(Operation.class);
    Editor editor = new Editor();
    editor.applyOperation(operation);
    verify(operation).apply(null);
    verifyNoMoreInteractions(operation);
  }
 
  @Test
  public void shouldBeAbleToNotifyHisObserver() {
    Observer observer = mock(Observer.class);
    Operation operation = mock(Operation.class);
    Editor editor = new Editor();
    editor.addObserver(observer);
    when(operation.apply(null)).thenReturn( new Image( new Size(1,1)));
    editor.applyOperation(operation);
    verify(observer).update( new Image( new Size(1,1)));
    verifyNoMoreInteractions(observer);
  }
  
}
