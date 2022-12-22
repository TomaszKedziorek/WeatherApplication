package com.tom;

import com.tom.model.Config;
import com.tom.model.persistence.PersistenceAccess;
import com.tom.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) {
    ViewFactory viewFactory = new ViewFactory(new ForecastManager());
    checkPersistence(viewFactory);
  }
  
  private void checkPersistence(ViewFactory viewFactory) {
    Config config = new Config();
    try {
      config = PersistenceAccess.loadFromPersistence();
    } catch (IOException | ClassNotFoundException e) {
    } finally {
      Config.setApiKey(config.getApiKeyToSerialize());
    }
    if (Config.getApiKey() == null || Config.getApiKey().isEmpty()) {
      viewFactory.showWelcomeWindow();
    } else {
      viewFactory.showMainWindowIfNotShown();
      PersistenceAccess.setIsRememberApiKey(true);
    }
  }
}
