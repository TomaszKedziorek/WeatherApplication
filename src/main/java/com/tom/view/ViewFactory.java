package com.tom.view;

import com.tom.ForecastManager;
import com.tom.controller.BaseController;
import com.tom.controller.MainWindowController;
import com.tom.controller.SettingsWindowController;
import com.tom.controller.WelcomeWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewFactory {
  
  private final ForecastManager forecastManager;
  private boolean mainWindowInitialized = false;
  private List<Stage> activeStages;
  
  public ViewFactory(ForecastManager forecastManager) {
    this.forecastManager = forecastManager;
    activeStages = new ArrayList<>();
  }
  
  private void initializeStage(BaseController baseController) {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlFileName()));
    fxmlLoader.setController(baseController);
    
    Parent parent;
    try {
      parent = fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    Scene scene = new Scene(parent);
    scene.getStylesheets().add(getClass().getResource("css/themeDefault.css").toExternalForm());
    Stage stage = new Stage();
    stage.getIcons().add(new Image(getClass().getResourceAsStream("icons/appIcon.png")));
    activeStages.add(stage);
    stage.setScene(scene);
    stage.show();
    stage.setTitle(baseController.getWindowTitle());
  }
  
  public void showWelcomeWindow() {
    BaseController controller = new WelcomeWindowController(forecastManager, this, "WelcomeWindow.fxml");
    initializeStage(controller);
  }
  
  private void showMainWindow() {
    BaseController controller = new MainWindowController(forecastManager, this, "MainWindow.fxml");
    initializeStage(controller);
    mainWindowInitialized = true;
  }
  
  public void showSettingsWindow() {
    BaseController controller = new SettingsWindowController(forecastManager, this, "SettingsWindow.fxml");
    initializeStage(controller);
  }
  
  public boolean isMainWindowInitialized() {
    return mainWindowInitialized;
  }
  
  public void showMainWindowIfNotShown() {
    if (!isMainWindowInitialized()) {
      showMainWindow();
    }
  }
  
  public void closeStage(Stage stageToClose) {
    stageToClose.close();
    activeStages.remove(stageToClose);
  }
  
}
