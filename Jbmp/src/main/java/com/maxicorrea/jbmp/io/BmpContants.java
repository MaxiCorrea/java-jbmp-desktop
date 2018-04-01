package com.maxicorrea.jbmp.io;

final class BmpContants {

  static final int CHARACTER_B = 66;
  static final int CHARACTER_M = 77;
  static final int HEAD_SIZE = 40;
  static final int IMAGE_PLANS = 1;
  static final int BITS_PER_PIXEL = 24;
  static final int COMPRESSION = 0;
  static final int PADDING = 4;
  static final int IGNORED = 20;

  private BmpContants() {
    throw new AssertionError();
  }
  
}
