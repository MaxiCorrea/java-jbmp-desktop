package com.maxicorrea.jbmp.application.port.out;

import java.io.File;
import com.maxicorrea.jbmp.domain.ImageLoadException;
import com.maxicorrea.jbmp.domain.ImageSaveException;
import com.maxicorrea.jbmp.domain.model.Image;

public interface ImageRepository {

  Image load(File file) throws ImageLoadException;

  void save(Image image, File file) throws ImageSaveException;

}
