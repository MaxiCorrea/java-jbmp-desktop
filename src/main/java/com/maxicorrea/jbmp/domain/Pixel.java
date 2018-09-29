package com.maxicorrea.jbmp.domain;

public final class Pixel {

  public static final int MAX_VALUE = 255;
  public static final int MIN_VALUE = 0;

  public static final Pixel BLACK = new Pixel(0,0,0);
  
  public static Pixel averageOfChannels(Pixel pixel) {
    int average = (pixel.red + pixel.green + pixel.blue) / 3;
    return new Pixel(average, average, average);
  }

  public static Pixel negate(Pixel pixel) {
    int red = MAX_VALUE - pixel.red;
    int green = MAX_VALUE - pixel.green;
    int blue = MAX_VALUE - pixel.blue;
    return new Pixel(red, green, blue);
  }

  private final int red;
  private final int green;
  private final int blue;

  public Pixel(Pixel other) {
    this(other.red, other.green, other.blue);
  }

  public Pixel(int red, int green, int blue) {
    this.red = validate(red);
    this.green = validate(green);
    this.blue = validate(blue);
  }

  private int validate(int value) {
    if (value < MIN_VALUE) {
      return MIN_VALUE;
    }
    if (value > MAX_VALUE) {
      return MAX_VALUE;
    }
    return value;
  }

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
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

  @Override
  public String toString() {
    return String.format("Pixel red=%d green=%d blue=%d", red, green, blue);
  }

}
