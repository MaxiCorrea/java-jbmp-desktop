package com.maxicorrea.jbmp.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.maxicorrea.jbmp.models.core.Image;
import com.maxicorrea.jbmp.models.core.Pixel;
import com.maxicorrea.jbmp.models.core.Size;

public final class ImageReader {

  public Image read(File file) throws BmpInputException {
    try (FileInputStream fi = new FileInputStream(file);
        BufferedInputStream bi = new BufferedInputStream(fi)) {
      readFileHeader(bi);
      Size size = readInfoHeader(bi);
      return read(bi, size);
    } catch (IOException ex) {
      throw new BmpInputException();
    }
  }

  private void readFileHeader(BufferedInputStream bi) throws IOException {
    if (BmpConstants.CHARACTER_B != bi.read()) {
      throw new IOException();
    }
    if (BmpConstants.CHARACTER_M != bi.read()) {
      throw new IOException();
    }
    if(bi.skip(BmpConstants.UNUSED) < 0) {
      throw new IOException();
    }
    if (BmpConstants.START_OF_BMP_DATA != readInt(bi)) {
      throw new IOException();
    }
  }

  private Size readInfoHeader(BufferedInputStream bi) throws IOException {
    if (BmpConstants.HEAD_SIZE != readInt(bi)) {
      throw new IOException();
    }
    int width = readInt(bi);
    int height = readInt(bi);
    Size size = new Size(height, width);
    if (BmpConstants.IMAGE_PLANS != readShort(bi)) {
      throw new IOException();
    }
    if (BmpConstants.BITS_PER_PIXEL != readShort(bi)) {
      throw new IOException();
    }
    if (BmpConstants.COMPRESSION != readInt(bi)) {
      throw new IOException();
    }
    if(bi.skip(BmpConstants.IGNORED) < 0) {
      throw new IOException();
    }
    return size;
  }

  private Image read(BufferedInputStream bi, Size size) throws IOException {
    Image image = new Image(size);
    int padding = size.getWidth() % BmpConstants.PADDING;
    byte[] bytes = new byte[3];
    for (int i = size.getHeight() - 1; i >= 0; i--) {
      for (int j = 0; j < size.getWidth(); j++) {
        if(bi.read(bytes) == -1) {
          throw new IOException();
        }
        int r = bytes[2] & 0xFF;
        int g = bytes[1] & 0xFF;
        int b = bytes[0] & 0xFF;
        image.setPixel(i, j, new Pixel(r, g, b));
      }
      for (int x = 0; x < padding; x++) {
        if (bi.read() == -1) {
          throw new IOException();
        }
      }

    }
    return image;
  }

  private int readInt(BufferedInputStream bi) throws IOException {
    byte[] bytes = new byte[4];
    if (bi.read(bytes) == -1) {
      throw new IOException();
    }
    return (bytes[3] & 0xFF) << 24 | (bytes[2] & 0xFF) << 16 | (bytes[1] & 0xFF) << 8
        | bytes[0] & 0xFF;
  }

  private short readShort(BufferedInputStream bi) throws IOException {
    byte[] bytes = new byte[2];
    if (bi.read(bytes) == -1) {
      throw new IOException();
    }
    return (short) ((short) (bytes[1] & 0xFF00) | (short) (bytes[0] & 0xFF));
  }

}
