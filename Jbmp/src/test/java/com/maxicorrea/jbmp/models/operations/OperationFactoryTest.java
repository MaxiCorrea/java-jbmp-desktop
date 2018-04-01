package com.maxicorrea.jbmp.models.operations;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import com.maxicorrea.jbmp.models.core.Operation;

public class OperationFactoryTest {

  @Test
  public void deberiaRetornarTodasLasOperaciones() {
    List<Operation> operations = OperationFactory.getAllOperations();
    assertTrue(operations.get(0) instanceof Grayscale);
    assertTrue(operations.get(1) instanceof Horizontal);
    assertTrue(operations.get(2) instanceof Left);
    assertTrue(operations.get(3) instanceof Negative);
    assertTrue(operations.get(4) instanceof Right);
    assertTrue(operations.get(5) instanceof Sepia);
    assertTrue(operations.get(6) instanceof Vertical);
    assertEquals(7 , operations.size());
  }

}
