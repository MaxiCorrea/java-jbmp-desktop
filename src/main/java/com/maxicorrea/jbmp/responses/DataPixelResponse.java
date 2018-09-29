package com.maxicorrea.jbmp.responses;

import com.maxicorrea.jbmp.domain.Pixel;

public class DataPixelResponse {

  public int red;
  public int green;
  public int blue;
  
  public DataPixelResponse(Pixel px) {
    red = px.getRed();
    green = px.getGreen();
    blue = px.getBlue();
  }

}
