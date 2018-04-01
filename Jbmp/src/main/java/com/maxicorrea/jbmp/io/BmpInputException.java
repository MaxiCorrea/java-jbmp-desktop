package com.maxicorrea.jbmp.io;

public class BmpInputException extends Exception {
  
  private static final long serialVersionUID = 1L;
  private static final String MESSAGE = "Error reading the image.";

  public BmpInputException() {
    super(MESSAGE);
  }
  
}