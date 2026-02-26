package com.maxicorrea.jbmp.application.port.out;

import com.maxicorrea.jbmp.domain.model.Image;

public interface ImagePresenter {

  void displayImage(Image image);

  Image getCurrentImage();

}
