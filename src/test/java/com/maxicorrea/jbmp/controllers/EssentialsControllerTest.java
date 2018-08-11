package com.maxicorrea.jbmp.controllers;

public class EssentialsControllerTest {

  /*
  
  @Test
  public void shouldNotDoAnythingIfYouAreSentNullWhenOpening() {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showOpenChooser()).thenReturn(null);
    controller.open();
    verifyZeroInteractions(model);
  }
  
  @Test
  public void shouldNotDoAnythingIfYouAreSentANonExistentFileWhenOpening() {
    File file = mock(File.class);
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(file.exists()).thenReturn(false);
    when(view.showOpenChooser()).thenReturn(file);
    controller.open();
    verifyZeroInteractions(model);
  }

  @Test
  public void shouldSendAMessageToTheViewWhenItLoadsTheImage() {
    File file = new File("src/test/resources/images/back.bmp");
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showOpenChooser()).thenReturn(file);
    controller.open();
    verify(view).showMessage(MessagesConstants.LOAD_OK);
  }
  
  @Test
  public void shouldSendAnErrorMessageToTheViewWhenYouCanNotLoadImage() {
    File file = new File("src/test/resources/images/err.bmp");
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showOpenChooser()).thenReturn(file);
    controller.open();
    verify(view).showErrorMessage(MessagesConstants.LOAD_ERROR);
  }
  
  @Test
  public void shouldNotDoAnythingIfYouAreSentNullWhenSave() {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showSaveChooser()).thenReturn(null);
    controller.save();
    verifyZeroInteractions(model);
  }
    
  @Test
  public void shouldSendAnErrorMessageWhenThereIsNoImageToSave() {
    File file = new File("src/test/resources/images/back.bmp");
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showSaveChooser()).thenReturn(file);
    controller.save();
    verify(view).showErrorMessage(MessagesConstants.SAVE_NO_IMAGE);
  }
  
  @Test
  public void shouldSendAMessageToTheViewWhenItSaveTheImage() {
    File file = new File("src/test/resources/images/ttt.bmp");
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    when(view.showSaveChooser()).thenReturn(file);
    Image image = new Image( new Size(1,1));
    image.setPixel(0, 0, new Pixel(255,0,0));
    when(model.getSourceImage()).thenReturn(image);
    when(model.getEditedImage()).thenReturn(image);
    controller.save();
    verify(view).showMessage(MessagesConstants.SAVE_OK);
  }
  
  @Test
  public void  shouldSendAnErrorMessageWhenYouTryToResetWithoutAnImage() {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    controller.reset();
    verify(view).showErrorMessage(MessagesConstants.NO_IMAGE);
  }
  
  @Test
  public void shouldNotSendAMessageWhenYouResetAnImage() {
    EditorView view = mock(EditorView.class);
    Editor model = mock(Editor.class);
    EssentialsController controller = new EssentialsController(view, model);
    Image image = new Image( new Size(1,1));
    image.setPixel(0, 0, new Pixel(255,0,0));
    when(model.getSourceImage()).thenReturn(image);
    controller.reset();
    verify(model).resetEditedImage();
  }
  */
}
