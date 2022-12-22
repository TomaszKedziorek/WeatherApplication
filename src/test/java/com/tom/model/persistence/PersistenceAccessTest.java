package com.tom.model.persistence;

import com.tom.model.Config;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class PersistenceAccessTest {
  
  @Test
  void ExceptionShouldBeThrownIfPersistenceFileNotExist() {
    //given
    PersistenceAccess.setApiKeyFileLocation("fileWhichNotExist.ser");
    //when
    //then
    assertThrows(FileNotFoundException.class, PersistenceAccess::loadFromPersistence);
  }
  
  @Test
  void shouldSaveApiKeyToFile() throws IOException, ClassNotFoundException {
    //given
    File file = new File("src/test/resources/testingFileWithApiKey.ser");
    String fileName = file.getAbsolutePath();
    PersistenceAccess.setApiKeyFileLocation(fileName);
    String apiKey = "TESTING_API_KEY";
    //when()
    PersistenceAccess.saveToPersistence(apiKey);
    Config config = PersistenceAccess.loadFromPersistence();
    //then
    assertTrue(file.exists());
    assumingThat(file.exists(), () -> {
      assertThat(config.getApiKeyToSerialize(), is(apiKey));
    });
  }
  
  @Test
  void shouldSetApiKeyIfPersistenceFileExist() throws IOException, ClassNotFoundException {
    //given
    File file = new File("src/test/resources/testingFileWithApiKey.ser");
    String fileName = file.getAbsolutePath();
    PersistenceAccess.setApiKeyFileLocation(fileName);
    //when
    Config config = PersistenceAccess.loadFromPersistence();
    Config.setApiKey(config.getApiKeyToSerialize());
    //then
    assertTrue(file.exists());
    assertThat(Config.getApiKey(), notNullValue());
    assertThat(Config.getApiKey(), is(config.getApiKeyToSerialize()));
  }
  
}