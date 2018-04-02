package com.maxicorrea.jbmp.views;

import static org.junit.Assert.*;
import org.junit.Test;
import com.maxicorrea.jbmp.views.utils.IconLocations;

public class ItemTest {

  private static final String ANY_TITLE = "ANY_TITLE";
  
  @Test
  public void initiallyItShouldNotHaveSubitems() {
    Item item = new Item( new TitleItem(ANY_TITLE));
    assertTrue(item.getSubItems().isEmpty());
  }

  @Test
  public void shouldBeAbleToAddASubItem() {
    Item item = new Item( new TitleItem(ANY_TITLE));
    SubItem subItem = new SubItem(ANY_TITLE, IconLocations.ARROW_DOWN);
    item.addSubItem(subItem);
    assertFalse(item.getSubItems().isEmpty());
    assertEquals(subItem , item.getSubItems().get(0));
    assertEquals(1 , item.getSubItems().size());
  }
  
  @Test
  public void shouldBeAbleToShowYourSubitems() {
    TitleItem titleItem =  new TitleItem(ANY_TITLE);
    Item item = new Item(titleItem);
    SubItem subItem = new SubItem(ANY_TITLE, IconLocations.ARROW_DOWN);
    item.addSubItem(subItem);
    item.pressedAction(titleItem);
    assertEquals(TitleItem.ARROW_UP_ICON , titleItem.getArrowLabel().getIcon());
    assertTrue(subItem.isVisible());
  }
  
  @Test
  public void shouldBeAbleToHideYourSubitems() {
    TitleItem titleItem =  new TitleItem(ANY_TITLE);
    Item item = new Item(titleItem);
    SubItem subItem = new SubItem(ANY_TITLE, IconLocations.ARROW_DOWN);
    item.addSubItem(subItem);
    item.notPressedAction(titleItem);
    assertEquals(TitleItem.ARROW_DOWN_ICON , titleItem.getArrowLabel().getIcon());
    assertFalse(subItem.isVisible());
  }
  
}
