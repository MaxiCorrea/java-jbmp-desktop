package com.maxicorrea.jbmp.domain;

import java.util.Arrays;

public final class Image {

  private final Size size;
  private final Pixel[][] pixels;

  public Image(Size size) {
    this.size = size;
    pixels = new Pixel[size.getHeight()][size.getWidth()];
  }

  public Image(Image other) {
    size = new Size(other.getSize());
    pixels = new Pixel[size.getHeight()][size.getWidth()];
    for (int row = 0; row < size.getHeight(); ++row) {
      for (int col = 0; col < size.getWidth(); ++col) {
        if (other.pixels[row][col] != null) {
          pixels[row][col] = new Pixel(other.pixels[row][col]);
        }
      }
    }
  }

  public void setPixel(int row, int col, Pixel pixel) {
    pixels[row][col] = pixel;
  }

  public Pixel getPixel(int row, int col) {
    return pixels[row][col];
  }

  public boolean inLimit(int row, int col) {
    return row == 0 || row == size.getHeight() - 1 ||
           col == 0 || col == size.getWidth() - 1; 
  }

  public Size getSize() {
    return size;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.deepHashCode(pixels);
    result = prime * result + ((size == null) ? 0 : size.hashCode());
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
    Image other = (Image) obj;
    if (!Arrays.deepEquals(pixels, other.pixels))
      return false;
    if (size == null) {
      if (other.size != null)
        return false;
    } else if (!size.equals(other.size))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return String.format("Image [size=%s, pixels=%s]", size, matrixString());
  }

  private String matrixString() {
    StringBuilder out = new StringBuilder();
    for (Pixel[] row : pixels) {
      out.append("\n").append(Arrays.toString(row));
    }
    return out.toString();
  }

}
