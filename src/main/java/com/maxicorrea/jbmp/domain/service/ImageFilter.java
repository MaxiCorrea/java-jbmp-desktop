package com.maxicorrea.jbmp.domain.service;

import com.maxicorrea.jbmp.domain.model.Image;

@FunctionalInterface
public interface ImageFilter {

  Image apply(Image source);

}
