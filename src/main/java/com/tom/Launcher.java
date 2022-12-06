package com.tom;

import com.tom.model.Config;
import com.tom.model.persistence.PersistenceAccess;
import com.tom.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  
  PersistenceAccess persistenceAccess = new PersistenceAccess();
  
  @Override
  public void start(Stage stage) {
    ViewFactory viewFactory = new ViewFactory(new ForecastManager());
    checkPersistence(viewFactory);
  }
  
  private void checkPersistence(ViewFactory viewFactory) {
    persistenceAccess.loadFromPersistence();
    if (Config.getAPI_KEY()==null || Config.getAPI_KEY().isEmpty()) {
        viewFactory.showWelcomeWindow();
    } else {
      viewFactory.showMainWindowIfNotShown();
      PersistenceAccess.rememberApiKEy = true;
    }
  }
}
