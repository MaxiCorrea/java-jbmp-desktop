package com.maxicorrea.jbmp.domain;

public class ImageLoadException extends Exception {

  private static final long serialVersionUID = 1L;

  public ImageLoadException(String message) {
    super(message);
  }

  public ImageLoadException(String message, Throwable cause) {
    super(message, cause);
  }

}
