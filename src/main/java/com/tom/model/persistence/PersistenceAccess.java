package com.tom.model.persistence;

import com.tom.model.Config;

import java.io.*;

public class PersistenceAccess {
  
  private static String API_KEY_FILE_LOCATION = System.getenv("APPDATA") +
          File.separator + "weatherApplicationApiKey.ser";
  public static boolean rememberApiKEy;
  public PersistenceAccess(){
  }
  
  public static String getApiKeyFileLocation() {
    return API_KEY_FILE_LOCATION;
  }
  
  public void loadFromPersistence(){
    try {
      FileInputStream fileInputStream = new FileInputStream(API_KEY_FILE_LOCATION);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      Config config = (Config) objectInputStream.readObject();
      Config.setAPI_KEY(config.getApiKeyToSerialize());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void saveToPersistence(String apiKey) {
    Config config = new Config(apiKey);
    File file = null;
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    try {
      file = new File(API_KEY_FILE_LOCATION);
      fileOutputStream = new FileOutputStream(file);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(config);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (fileOutputStream != null) {
        try {
          fileOutputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (objectOutputStream != null) {
        try {
          objectOutputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
