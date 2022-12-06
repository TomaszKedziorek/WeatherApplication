package com.tom.controller;

import com.tom.ForecastManager;
import com.tom.model.Config;
import com.tom.model.persistence.PersistenceAccess;
import com.tom.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowController extends BaseController implements Initializable {
  private final String windowTitle = "Settings - WeatherApplication";
  
  @FXML
  private TextField apiKeyTextField;
  @FXML
  private Label errorLabel;
  @FXML
  private CheckBox rememberKeyCheckbox;
  
  public SettingsWindowController(ForecastManager forecastManager, ViewFactory viewFactory, String fxmlFileName) {
    super(forecastManager, viewFactory, fxmlFileName);
  }
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setTooltip(PersistenceAccess.getApiKeyFileLocation(),rememberKeyCheckbox);
    apiKeyTextField.setText(Config.getAPI_KEY());
    if(PersistenceAccess.rememberApiKEy){
      rememberKeyCheckbox.setSelected(true);
    }else {
      rememberKeyCheckbox.setSelected(false);
    }
  }
  @Override
  public String getWindowTitle() {
    return windowTitle;
  }
  
  @FXML
  void okButtonAction() {
    String apiKey = apiKeyTextField.getText().trim();
    if (!apiKey.equals(Config.getAPI_KEY()) || apiKey.isEmpty()) {
      Config.setAPI_KEY(apiKeyTextField.getText().trim());
    }
    remember();
    closeStage(errorLabel);
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
