package com.maxicorrea.jbmp.domain;

public class ImageSaveException extends Exception {

  private static final long serialVersionUID = 1L;

  public ImageSaveException(String message) {
    super(message);
  }

  public ImageSaveException(String message, Throwable cause) {
    super(message, cause);
  }

}
