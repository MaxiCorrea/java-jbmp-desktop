package com.maxicorrea.jbmp.application;

import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Editor;
import com.maxicorrea.jbmp.views.EditorView;
import com.maxicorrea.jbmp.views.ImageView;

public class ApplicationTest {

  @Test
  public void shouldStartTheApplication() {
    Editor model = new Editor();
    EditorView view = new EditorView( new ImageView());
    Application.initializeApp(model, view);
  }

}
