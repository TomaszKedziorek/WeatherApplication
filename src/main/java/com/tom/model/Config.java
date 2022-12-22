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
  
  public static String getApiKey() {
    return API_KEY;
  }
  
  public String getApiKeyToSerialize() {
    return apiKeyToSerialize;
  }
  
  public static void setApiKey(String apiKey) {
    API_KEY = apiKey;
  }
  
}
