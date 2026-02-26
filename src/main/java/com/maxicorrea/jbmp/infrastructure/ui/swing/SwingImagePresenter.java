package com.maxicorrea.jbmp.infrastructure.ui.swing;

import com.maxicorrea.jbmp.application.port.out.ImagePresenter;
import com.maxicorrea.jbmp.domain.model.Image;

public class SwingImagePresenter implements ImagePresenter {

  private ImageViewSwing imageView;

  public void setImageView(ImageViewSwing imageView) {
    this.imageView = imageView;
  }

  @Override
  public void displayImage(Image image) {
    imageView.updateImage(image);
  }

  @Override
  public Image getCurrentImage() {
    return imageView.getImage();
  }

}
