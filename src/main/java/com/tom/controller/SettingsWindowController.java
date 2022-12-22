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

public class SettingsWindowController extends RememberApiKeyController implements Initializable {
  private static final String windowTitle = "Settings - WeatherApplication";
  
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
    setTooltip(PersistenceAccess.getApiKeyFileLocation(), rememberKeyCheckbox);
    apiKeyTextField.setText(Config.getApiKey());
    rememberKeyCheckbox.setSelected(PersistenceAccess.isRememberApiKey());
  }
  
  @Override
  public String getWindowTitle() {
    return windowTitle;
  }
  
  @FXML
  void okButtonAction() {
    String apiKey = apiKeyTextField.getText().trim();
    if (!apiKey.equals(Config.getApiKey()) || apiKey.isEmpty()) {
      Config.setApiKey(apiKeyTextField.getText().trim());
    }
    
    rememberAndCloseIfNoProblem(rememberKeyCheckbox, errorLabel);
  }
  
  
  @FXML
  void cancelButtonAction() {
    closeStage(errorLabel);
  }
  
}
