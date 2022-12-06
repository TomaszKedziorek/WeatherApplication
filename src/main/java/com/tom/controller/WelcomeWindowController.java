package com.tom.controller;

import com.tom.ForecastManager;
import com.tom.model.Config;
import com.tom.model.persistence.PersistenceAccess;
import com.tom.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeWindowController extends BaseController implements Initializable {
  private final String windowTitle = "WeatherApplication - Welcome";
  @FXML
  private TextField apiKeyTextField;
  @FXML
  private Label errorLabel;
  @FXML
  private CheckBox rememberKeyCheckbox;
  
  
  public WelcomeWindowController(ForecastManager forecastManager, ViewFactory viewFactory, String fxmlFileName) {
    super(forecastManager, viewFactory, fxmlFileName);
  }
  @Override
  public String getWindowTitle() {
    return windowTitle;
  }
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setTooltip(PersistenceAccess.getApiKeyFileLocation(),rememberKeyCheckbox);
  }
  
  @FXML
  void hyperlinkAction() {
    try {
      Desktop.getDesktop().browse(new URI("https://developer.accuweather.com/packages"));
    } catch (IOException e) {
      e.printStackTrace();
      errorLabel.setText("Cannot open the browser.");
    } catch (URISyntaxException e) {
      e.printStackTrace();
      errorLabel.setText("Cannot open the browser.");
    }
  }
  
  @FXML
  void okButtonAction() {
    if(apiKeyTextField.getText().trim().isEmpty()){
      errorLabel.setText("Please enter your AccuWeather API key to continue.");
    }else {
      Config.setAPI_KEY(apiKeyTextField.getText().trim());
      remember();
      viewFactory.showMainWindowIfNotShown();
      closeStage(errorLabel);
    }
  }
  private void remember() {
    if(rememberKeyCheckbox.isSelected()){
      PersistenceAccess.saveToPersistence(Config.getAPI_KEY());
      PersistenceAccess.rememberApiKEy = true;
    }else {
      PersistenceAccess.saveToPersistence(null);
      PersistenceAccess.rememberApiKEy = false;
    }
  }
  
  @FXML
  void cancelButtonAction() {
    closeStage(errorLabel);
  }

}
