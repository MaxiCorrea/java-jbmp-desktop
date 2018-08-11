package com.maxicorrea.jbmp.io;

import static org.junit.Assert.*;
import org.junit.Test;

public class BmpOutputExceptionTest {
  
  private static final String MESSAGE = "Error saving the image";
  
  @Test
  public void shouldShowASimpleMessage() {
    BmpOutputException bmpOutputException = new BmpOutputException();
    assertEquals(MESSAGE , bmpOutputException.getMessage());
  }

}
