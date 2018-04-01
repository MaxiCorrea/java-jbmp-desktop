package com.maxicorrea.jbmp.models.core;

public interface Operation {

  Image apply(Image image);
  
  String getName();
  
}
