package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.requests.DataImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class ApplyResetUseCase implements UseCase<DataImageResponse , DataImageRequest>{

  private Image image;
 
  public ApplyResetUseCase(Image image) {
    this.image = new Image(image);
  }
  
  public DataImageResponse execute(DataImageRequest request) {
    return new DataImageResponse(image);
  }

  @Override
  public String getName() {
    return null;
  }

}
