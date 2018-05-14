package com.maxicorrea.jbmp.models.core;

import java.util.Arrays;
import java.util.Iterator;

public class Image implements Iterable<Pixel> {

  private Size size;
  private Pixel[][] pixels;

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

  public Size getSize() {
    return size;
  }

  @Override
  public Iterator<Pixel> iterator() {
    return new MatrixIterator();
  }

  private class MatrixIterator implements Iterator<Pixel> {

    private RowIterator rowIterator = new RowIterator();

    @Override
    public boolean hasNext() {
      if (!rowIterator.hasNext()) {
        rowIterator.row++;
        rowIterator.col = 0;
      }
      return rowIterator.hasNext();
    }

    @Override
    public Pixel next() {
      return rowIterator.next();
    }

  }

  private class RowIterator implements Iterator<Pixel> {

    private int row;
    private int col;

    @Override
    public boolean hasNext() {
      return row < pixels.length && col < pixels[row].length;
    }

    @Override
    public Pixel next() {
      return pixels[row][col++];
    }

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

}
