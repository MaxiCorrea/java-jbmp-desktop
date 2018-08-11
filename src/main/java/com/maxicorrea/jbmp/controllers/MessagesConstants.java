package com.maxicorrea.jbmp.controllers;

public class MessagesConstants {

  static final String LOAD_OK = "Image loaded correctly!";
  static final String LOAD_ERROR = "Error loading the image!";
  static final String SAVE_NO_IMAGE = "There is no image to save!";
  static final String SAVE_OK = "Image saves correctly!";
  static final String SAVE_ERROR = "Error saving the image!";
  static final String NO_IMAGE = "No image loaded!";

  private MessagesConstants() {
    throw new AssertionError("MessageConstants is a utility class");
  }

}
