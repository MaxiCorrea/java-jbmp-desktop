package com.maxicorrea.jbmp.views;

import static org.junit.Assert.*;
import java.awt.event.MouseListener;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class TitleItemTest {

  private static final String ANY_TITTLE = "ANY_TITLE";

  @Test
  public void shouldBeAbleToStoreATitle() {
    TitleItem item = new TitleItem(ANY_TITTLE);
    assertEquals(ANY_TITTLE, item.getTitleLabel().getText());
  }

  @Test
  public void shouldBeNotPressedInitially() {
    TitleItem item = new TitleItem(ANY_TITTLE);
    assertFalse(item.isPressed());
  }

  @Test
  public void shouldBeAbleToAddAlistener() {
    TitleItem item = new TitleItem(ANY_TITTLE);
    MouseListener listener = mock(MouseListener.class);
    item.addMouseListener(listener);
    assertEquals(listener, item.getTitleLabel().getMouseListeners()[0]);
    assertEquals(listener, item.getArrowLabel().getMouseListeners()[0]);
  }

  @Test
  public void shouldBeAbleToChangeIcons() {
    TitleItem item = new TitleItem(ANY_TITTLE);
    item.arrowDown();
    assertEquals(TitleItem.ARROW_DOWN_ICON , item.getArrowLabel().getIcon());
    item.arrowUp();
    assertEquals(TitleItem.ARROW_UP_ICON , item.getArrowLabel().getIcon());
  }

}
