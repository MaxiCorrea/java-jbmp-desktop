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
  
}
