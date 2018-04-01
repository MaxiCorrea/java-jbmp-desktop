package com.maxicorrea.jbmp.views;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.maxicorrea.jbmp.views.utils.IconLocations;

public class SubItemTest {

  private static final String ANY_TEXT = "ANY_TEXT";
  private static final String ANY_COMMAND = "ANY_COMMAND";
  
  @Test
  public void shouldCreateAButtonWithAnIconAndText() {
    SubItem item = new SubItem(ANY_TEXT, IconLocations.NEGATIVE_PATH , ANY_COMMAND);
    assertEquals(ANY_TEXT , item.getButton().getText());
    assertEquals(ANY_COMMAND , item.getButton().getActionCommand());
    item = new SubItem(ANY_TEXT, IconLocations.NEGATIVE_PATH);
    assertEquals("" , item.getButton().getActionCommand());
  }

}
