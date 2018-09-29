package com.maxicorrea.jbmp.dataproviders;

public class BmpOutputException extends Exception {
  
  private static final long serialVersionUID = 1L;
  private static final String MESSAGE = "Error saving the image";

  public BmpOutputException() {
    super(MESSAGE);
  }

}