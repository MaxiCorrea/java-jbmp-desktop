package com.maxicorrea.jbmp.configuration;

import java.util.EnumMap;
import com.maxicorrea.jbmp.usecases.UseCase;

public class UseCasesFactory {

  private EnumMap<UseCaseType, UseCase> map;

  public UseCasesFactory() {
    map = new EnumMap<>(UseCaseType.class);
  }

  public UseCase get(UseCaseType key) {
    if (!map.containsKey(key)) {
      map.put(key, key.create());
    }
    return map.get(key);
  }

}
