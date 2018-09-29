package com.maxicorrea.jbmp.usecases;

import com.maxicorrea.jbmp.requests.OpenImageRequest;
import com.maxicorrea.jbmp.responses.DataImageResponse;

public class OpenImageUseCase implements UseCase<DataImageResponse , OpenImageRequest> {

  @Override
  public DataImageResponse execute(OpenImageRequest request) {
    return null;
  }

  @Override
  public String getName() {
    return "Open";
  }
 
}
