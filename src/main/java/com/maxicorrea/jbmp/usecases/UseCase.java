package com.maxicorrea.jbmp.usecases;

public interface UseCase<Response , Request> {

  Response execute(Request request);
  
  String getName();
  
}
