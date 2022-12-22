package com.tom.controller;

import com.tom.ForecastManager;
import com.tom.model.Config;
import com.tom.model.persistence.PersistenceAccess;
import com.tom.view.ViewFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class RememberApiKeyController extends BaseController {
  
  public RememberApiKeyController(ForecastManager forecastManager, ViewFactory viewFactory, String fxmlFileName) {
    super(forecastManager, viewFactory, fxmlFileName);
  }
  
  @Override
  public String getWindowTitle() {
    return null;
  }
  
  private void remember(CheckBox rememberKeyCheckbox, Label errorLabel) {
    String apiKey = "";
    if (rememberKeyCheckbox.isSelected()) {
      apiKey = Config.getApiKey();
      PersistenceAccess.setIsRememberApiKey(true);
    } else {
      PersistenceAccess.setIsRememberApiKey(false);
    }
    try {
      PersistenceAccess.saveToPersistence(apiKey);
    } catch (IOException e) {
      errorLabel.setText("Problem with saving changes occurred.");
    }
  }
  
  public boolean rememberAndCloseIfNoProblem(CheckBox rememberKeyCheckbox, Label errorLabel) {
    remember(rememberKeyCheckbox, errorLabel);
    if (errorLabel.getText().isEmpty() || !rememberKeyCheckbox.isSelected()) {
      closeStage(errorLabel);
      return true;
    } else {
      return false;
    }
  }
}
