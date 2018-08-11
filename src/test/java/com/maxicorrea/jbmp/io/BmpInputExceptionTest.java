package com.maxicorrea.jbmp.io;

import static org.junit.Assert.*;
import org.junit.Test;

public class BmpInputExceptionTest {

  private static final String MESSAGE = "Error reading the image.";
  
  @Test
  public void shouldShowASimpleMessage() {
    BmpInputException bmpInputException = new BmpInputException();
    assertEquals(MESSAGE , bmpInputException.getMessage());
  }

}
