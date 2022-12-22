package com.tom.model.persistence;

import com.tom.model.Config;

import java.io.*;

public class PersistenceAccess {
  
  private static String API_KEY_FILE_LOCATION = defaultDirectory();
  private static final String API_KEY_FILE_NAME = "weatherApplicationApiKey.ser";
  private static boolean rememberApiKey;
  
  public static boolean isRememberApiKey() {
    return rememberApiKey;
  }
  
  public static void setIsRememberApiKey(boolean rememberApiKey) {
    PersistenceAccess.rememberApiKey = rememberApiKey;
  }
  
  private static String defaultDirectory() {
    String path;
    String OS = System.getProperty("os.name").toUpperCase();
    if (OS.contains("WIN")) {
      path = System.getenv("APPDATA") + File.separator;
    } else if (OS.contains("MAC")) {
      path = System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support" + File.separator;
    } else if (OS.contains("NUX")) {
      path = System.getProperty("user.home") + File.separator + ".config" + File.separator;
    } else {
      path = System.getProperty("user.dir");
    }
    return path + API_KEY_FILE_NAME;
  }
  
  public static String getApiKeyFileLocation() {
    return API_KEY_FILE_LOCATION;
  }
  
  public static void setApiKeyFileLocation(String apiKeyFileLocation) {
    API_KEY_FILE_LOCATION = apiKeyFileLocation;
  }
  
  private static Config readConfigFromFile(File file) throws IOException, ClassNotFoundException {
    Config config;
    try (FileInputStream fileInputStream = new FileInputStream(file);
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      config = (Config) objectInputStream.readObject();
    }
    return config;
  }
  
  public static Config loadFromPersistence() throws IOException, ClassNotFoundException {
    File file = new File(API_KEY_FILE_LOCATION);
    return readConfigFromFile(file);
  }
  
  private static void writeConfigToFile(File file, Config config) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream(file);
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(config);
    }
  }
  
  public static void saveToPersistence(String apiKey) throws IOException {
    Config config = new Config(apiKey);
    File file = new File(API_KEY_FILE_LOCATION);
    writeConfigToFile(file, config);
  }
}
