package com.maxicorrea.jbmp.configuration;

import com.maxicorrea.jbmp.usecases.ApplyBlurUseCase;
import com.maxicorrea.jbmp.usecases.ApplyEdgesUseCase;
import com.maxicorrea.jbmp.usecases.ApplyGrayscaleUseCase;
import com.maxicorrea.jbmp.usecases.ApplyHorizontalUseCase;
import com.maxicorrea.jbmp.usecases.ApplyLeftUseCase;
import com.maxicorrea.jbmp.usecases.ApplyNegativeUseCase;
import com.maxicorrea.jbmp.usecases.ApplyRightUseCase;
import com.maxicorrea.jbmp.usecases.ApplySepiaUseCase;
import com.maxicorrea.jbmp.usecases.ApplyVerticalUseCase;
import com.maxicorrea.jbmp.usecases.UseCase;

public enum UseCaseType {

  GRAYSCALE {
    @Override
    UseCase create() {
      return new ApplyGrayscaleUseCase();
    }
  },

  HORIZONTAL {
    @Override
    UseCase create() {
      return new ApplyHorizontalUseCase();
    }
  },

  LEFT {
    @Override
    UseCase create() {
      return new ApplyLeftUseCase();
    }
  },

  NEGATIVE {
    @Override
    UseCase create() {
      return new ApplyNegativeUseCase();
    }
  },

  RIGHT {
    @Override
    UseCase create() {
      return new ApplyRightUseCase();
    }
  },

  SEPIA {
    @Override
    UseCase create() {
      return new ApplySepiaUseCase();
    }
  },

  VERTICAL {
    @Override
    UseCase create() {
      return new ApplyVerticalUseCase();
    }
  },
  
  BLUR {
    @Override
    UseCase create() {
      return new ApplyBlurUseCase();
    }
  },
  
  EDGES {
    @Override
    UseCase create() {
      return new ApplyEdgesUseCase();
    }
  };
  
  abstract UseCase create();

}
