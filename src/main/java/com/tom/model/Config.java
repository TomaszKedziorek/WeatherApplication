package com.tom.model;

import java.io.Serializable;

public class Config implements Serializable {
  
  private String apiKeyToSerialize;
  private static String API_KEY;
  
  public Config() {
  }
  
  public Config(String apiKeyToSerialize) {
    this.apiKeyToSerialize = apiKeyToSerialize;
  }
  
  public static String getAPI_KEY() {
    return API_KEY;
  }
  
  public String getApiKeyToSerialize() {
    return apiKeyToSerialize;
  }
  
  public static void setAPI_KEY(String apiKey) {
    API_KEY = apiKey;
  }
  
}
