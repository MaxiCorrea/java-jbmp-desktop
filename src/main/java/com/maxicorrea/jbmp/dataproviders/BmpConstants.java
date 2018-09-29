package com.maxicorrea.jbmp.dataproviders;

final class BmpConstants {

  static final int CHARACTER_B = 66;
  static final int CHARACTER_M = 77;
  static final int HEAD_SIZE = 40;
  static final int IMAGE_PLANS = 1;
  static final int BITS_PER_PIXEL = 24;
  static final int COMPRESSION = 0;
  static final int PADDING = 4;
  static final int IGNORED = 20;
  static final int START_OF_BMP_DATA = 54;
  static final long UNUSED = 8L;
  
  private BmpConstants() {
    throw new AssertionError();
  }

}
