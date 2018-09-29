package com.maxicorrea.jbmp.persistence;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.domain.Pixel;
import com.maxicorrea.jbmp.domain.Size;

public final class ImageWriter {

  public ImageWriter() {
    super();
  }

  public boolean write(Image image, File file) throws BmpOutputException {
    try (FileOutputStream fo = new FileOutputStream(addExtension(file));
        BufferedOutputStream bo = new BufferedOutputStream(fo)) {
      writeBitmapFileHeader(bo, image.getSize());
      writeBitmapInfoHeader(bo, image.getSize());
      writePixels(bo, image);
      return true;
    } catch (IOException e) {
      throw new BmpOutputException();
    }
  }

  File addExtension(File file) {
    if (!file.getAbsolutePath().endsWith(".bmp")) {
      return new File(file.getAbsolutePath().concat(".bmp"));
    }
    return file;
  }

  private void writeBitmapFileHeader(BufferedOutputStream bo, Size size) throws IOException {
    bo.write(new byte[] {BmpConstants.CHARACTER_B, BmpConstants.CHARACTER_M});
    bo.write(toInt(
        size.getWidth() * size.getHeight() * 3 + size.getHeight() * (size.getWidth() % 4) + 54));
    bo.write(toShort(0));
    bo.write(toShort(0));
    bo.write(toInt(54));
  }

  private void writeBitmapInfoHeader(BufferedOutputStream bo, Size size) throws IOException {
    bo.write(toInt(BmpConstants.HEAD_SIZE));
    bo.write(toInt(size.getWidth()));
    bo.write(toInt(size.getHeight()));
    bo.write(toShort(BmpConstants.IMAGE_PLANS));
    bo.write(toShort(BmpConstants.BITS_PER_PIXEL));
    bo.write(toInt(BmpConstants.COMPRESSION));
    bo.write(
        toInt(size.getWidth() * size.getHeight() * 3 + size.getHeight() * (size.getWidth() % 4)));
    bo.write(toInt(0));
    bo.write(toInt(0));
    bo.write(toInt(0));
    bo.write(toInt(0));
  }

  private void writePixels(BufferedOutputStream bo, Image image) throws IOException {
    Size size = image.getSize();
    int padding = size.getWidth() % BmpConstants.PADDING;
    for (int i = size.getHeight() - 1; i >= 0; i--) {
      for (int j = 0; j < size.getWidth(); j++) {
        bo.write((byte) image.getPixel(i, j).getBlue());
        bo.write((byte) image.getPixel(i, j).getGreen());
        bo.write((byte) image.getPixel(i, j).getRed());
      }
      for (int x = 0; x < padding; x++)
        bo.write(Pixel.MAX_VALUE);
    }
  }

  private byte[] toInt(int value) {
    byte[] b = new byte[4];
    b[0] = ((byte) (value & 0xFF));
    b[1] = ((byte) (value >> 8 & 0xFF));
    b[2] = ((byte) (value >> 16 & 0xFF));
    b[3] = ((byte) (value >> 24 & 0xFF));
    return b;
  }

  private byte[] toShort(int value) {
    byte[] bytes = new byte[2];
    bytes[0] = ((byte) (value & 0xFF));
    bytes[1] = ((byte) (value >> 8 & 0xFF));
    return bytes;
  }

}
