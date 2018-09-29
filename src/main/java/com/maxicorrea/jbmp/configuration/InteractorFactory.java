package com.maxicorrea.jbmp.configuration;

import java.util.ArrayList;
import java.util.List;
import com.maxicorrea.jbmp.usecases.UseCase;

public class InteractorFactory {

  private InteractorFactory() {
    throw new AssertionError();
  }
  
  public static List<UseCase> getAllOperations() {
    List<UseCase> operations = new ArrayList<>();
    for(UseCaseType type : UseCaseType.values()) {
      operations.add(type.create());
    }
    return operations;
  }
  
}
