package com.maxicorrea.jbmp.controllers;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Size;
import com.maxicorrea.jbmp.views.EditorView;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class OperationControllerTest {

  Object getValidOperations() {
    return new Object[]{"Negative","Sepia","Vertical","Horizontal"};
  }
  
  @Test
  @Parameters(method = "getValidOperations")
  public void shouldBeAbleToApplyAnOperation(String validOperation) {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    OperationController controller = new OperationController(view, model);
    Image image =  new Image(new Size(0,0));
    when(model.getSourceImage()).thenReturn(image);
    controller.control(validOperation);
  }

  @Test
  @Parameters(method = "getValidOperations")
  public void shouldShowAMessageIfThereIsNoImageToApplyTheOperation(String validOperation) {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    OperationController controller = new OperationController(view, model);
    controller.control(validOperation);
    verify(view).showErrorMessage(MessagesConstants.NO_IMAGE);
  }
  
}
