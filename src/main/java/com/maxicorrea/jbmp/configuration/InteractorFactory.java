package com.maxicorrea.jbmp.models.operations;

import java.util.ArrayList;
import java.util.List;
import com.maxicorrea.jbmp.models.core.Operation;

public class OperationFactory {

  private OperationFactory() {
    throw new AssertionError();
  }
  
  public static List<Operation> getAllOperations() {
    List<Operation> operations = new ArrayList<>();
    for(OperationType type : OperationType.values()) {
      operations.add(type.getOperation());
    }
    return operations;
  }
  
}
