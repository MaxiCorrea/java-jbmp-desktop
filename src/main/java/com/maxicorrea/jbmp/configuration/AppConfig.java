package com.maxicorrea.jbmp.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppConfig {

  private static final Map<String, String> URL = new HashMap<>();

  static {
    try {
      Properties properties = new Properties();
      char sp = File.separatorChar;
      properties.loadFromXML(
          new FileInputStream("src" + sp + "main" + sp + "resources" + sp + "application.xml"));
      for (Object key : properties.keySet()) {
        URL.put((String) key, properties.getProperty((String) key));
      }
    } catch (IOException e) {
      System.exit(-1);
    }
  }

  public static final String url(String key) {
    return URL.get(key);
  }

  private AppConfig() {
    throw new AssertionError();
  }

}
