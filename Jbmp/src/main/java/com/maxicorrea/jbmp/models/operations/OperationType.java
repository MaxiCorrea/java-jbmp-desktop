package com.maxicorrea.jbmp.models.operations;

import com.maxicorrea.jbmp.models.core.Operation;

public enum OperationType {

  GRAYSCALE {
    @Override
    Operation getOperation() {
      return new Grayscale();
    }
  },

  HORIZONTAL {
    @Override
    Operation getOperation() {
      return new Horizontal();
    }
  },

  LEFT {
    @Override
    Operation getOperation() {
      return new Left();
    }
  },

  NEGATIVE {
    @Override
    Operation getOperation() {
      return new Negative();
    }
  },

  RIGHT {
    @Override
    Operation getOperation() {
      return new Right();
    }
  },

  SEPIA {
    @Override
    Operation getOperation() {
      return new Sepia();
    }
  },

  VERTICAL {
    @Override
    Operation getOperation() {
      return new Vertical();
    }
  },
  
  BLUR {
    @Override
    Operation getOperation() {
      return new Blur();
    }
  },
  
  EDGES {
    @Override
    Operation getOperation() {
      return new Edges();
    }
  };
  
  abstract Operation getOperation();

}
