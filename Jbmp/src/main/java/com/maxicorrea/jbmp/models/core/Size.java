package com.maxicorrea.jbmp.models.core;

public class Size {

  public static Size invert(Size size) {
    return new Size(size.getWidth(), size.getHeight());
  }

  private final int height;
  private final int width;

  public Size(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public Size(Size other) {
    this(other.getHeight(), other.getWidth());
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + height;
    result = prime * result + width;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Size other = (Size) obj;
    if (height != other.height)
      return false;
    return width == other.width;
  }

  @Override
  public String toString() {
    return String.format("Size [height=%d, width=%d]", height, width);
  }

}
