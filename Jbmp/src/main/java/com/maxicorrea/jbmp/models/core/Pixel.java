package com.maxicorrea.jbmp.models.core;

public final class Pixel {

  public static final int MAX_VALUE = 255;
  public static final int MIN_VALUE = 0;

  private int red;
  private int green;
  private int blue;

  public Pixel(Pixel other) {
    this(other.red, other.green, other.blue);
  }

  public Pixel(int red, int green, int blue) {
    setRed(red);
    setGreen(green);
    setBlue(blue);
  }

  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    if (red > MAX_VALUE) {
      this.red = MAX_VALUE;
    } else if (red < MIN_VALUE) {
      this.red = MIN_VALUE;
    } else {
      this.red = red;
    }
  }

  public int getGreen() {
    return green;
  }

  public void setGreen(int green) {
    if (green > MAX_VALUE) {
      this.green = MAX_VALUE;
    } else if (green < MIN_VALUE) {
      this.green = MIN_VALUE;
    } else {
      this.green = green;
    }
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    if (blue > MAX_VALUE) {
      this.blue = MAX_VALUE;
    } else if (blue < MIN_VALUE) {
      this.blue = MIN_VALUE;
    } else {
      this.blue = blue;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + blue;
    result = prime * result + green;
    result = prime * result + red;
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
    Pixel other = (Pixel) obj;
    if (blue != other.blue)
      return false;
    if (green != other.green)
      return false;
    return red == other.red;
  }

}
