package com.tom.controller;

import com.tom.ForecastManager;
import com.tom.model.*;
import com.tom.view.ViewFactory;
import com.tom.view.WeatherCardCreator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
  private static final String windowTitle = "Main Window - WeatherApplication";
  @FXML
  private Label lowerCityLabel;
  @FXML
  private Label upperCityLabel;
  @FXML
  private Label upperErrorLabel;
  @FXML
  private Label lowerErrorLabel;
  @FXML
  private TextField upperSearchCityTextField;
  @FXML
  private TextField lowerSearchCityTextField;
  @FXML
  private HBox upperHbox;
  @FXML
  private HBox lowerHbox;
  @FXML
  private Button upperPreviousForecastButton;
  @FXML
  private Button lowerPreviousForecastButton;
  private final CityFounder cityFounder;
  private final ForecastLoader forecastLoader;
  
  public MainWindowController(ForecastManager forecastManager, ViewFactory viewFactory, String fxmlFileName) {
    super(forecastManager, viewFactory, fxmlFileName);
    this.cityFounder = new CityFounder(forecastManager.getRequestCaller());
    this.forecastLoader = new ForecastLoader(forecastManager.getRequestCaller());
  }
  
  @Override
  public String getWindowTitle() {
    return windowTitle;
  }
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setUpDefaultForecasts();
    setUpHbox();
    upperPreviousForecastButton.setVisible(false);
    lowerPreviousForecastButton.setVisible(false);
  }
  
  private void setUpDefaultForecasts() {
    findForecastForCity(UpperOrLower.UPPER, "Warszawa");
    findForecastForCity(UpperOrLower.LOWER, "Paris");
  }
  
  @FXML
  void upperSearchButtonAction() {
    searchCityButtonAction(UpperOrLower.UPPER);
  }
  
  @FXML
  void lowerSearchButtonAction() {
    searchCityButtonAction(UpperOrLower.LOWER);
  }
  
  @FXML
  void settingsAction() {
    viewFactory.showSettingsWindow();
  }
  
  @FXML
  void fileCloseButtonAction() {
    closeStage(upperCityLabel);
  }
  
  private void searchCityButtonAction(UpperOrLower upperOrLower) {
    TextField textField = getTextField(upperOrLower);
    if (textField.getText().trim().isEmpty()) {
      setErrorLabel(upperOrLower, "Enter a city name to get forecast.");
      setCityLabel(upperOrLower, "");
      setUpPreviousForecastButton(upperOrLower);
    } else {
      findForecastForCity(upperOrLower, textField.getText().trim());
    }
  }
  
  private void findForecastForCity(UpperOrLower upperOrLower, String cityName) {
    cityFounder.findCityByName(cityName);
    if (validCityData(upperOrLower)) {
      findForecastAndDisplayIfValid(upperOrLower);
    }
  }
  
  private boolean validCityData(UpperOrLower upperOrLower) {
    TextField textField = getTextField(upperOrLower);
    if (cityFounder.getCityData() == null) {
      displayIfError(upperOrLower, String.valueOf(cityFounder.getApiCallResult().getErrorString()));
      return false;
    } else if (cityFounder.getCityData().size() == 0) {
      displayIfError(upperOrLower, "The localization " + textField.getText() + " could not be found.");
      return false;
    } else {
      setCity(upperOrLower, cityFounder.getCityData().get(0));
      setContextMenuIfMoreCitiesFound(upperOrLower);
      return true;
    }
  }
  
  private void findForecastAndDisplayIfValid(UpperOrLower upperOrLower) {
    forecastLoader.findForecastsForCityByCityKey(forecastManager.getCityData(upperOrLower).get().getKey());
    if (validForecastData(upperOrLower)) {
      displayCityForecast(upperOrLower);
    }
  }
  
  private boolean validForecastData(UpperOrLower upperOrLower) {
    if (forecastLoader.getForecastForCity() == null) {
      displayIfError(upperOrLower, String.valueOf(forecastLoader.getApiCallResult().getErrorString()));
      return false;
    } else {
      setForecast(upperOrLower, forecastLoader.getForecastForCity());
      return true;
    }
  }
  
  private void displayIfError(UpperOrLower upperOrLower, String errorText) {
    setErrorLabel(upperOrLower, errorText);
    setCityLabel(upperOrLower, "");
    setUpPreviousForecastButton(upperOrLower);
  }
  
  private void setCity(UpperOrLower upperOrLower, CityData cityData) {
    forecastManager.setCityData(upperOrLower, cityData);
  }
  
  private void setForecast(UpperOrLower upperOrLower, ForecastForCity forecastForCity) {
    forecastManager.setCityForecast(upperOrLower, forecastForCity);
  }
  
  private void setUpPreviousForecastButton(UpperOrLower upperOrLower) {
    Button backBtn = setPreviousForecastButton(upperOrLower);
    backBtn.setVisible(true);
    getHbox(upperOrLower).getChildren().add(backBtn);
    backBtn.setOnAction(event -> {
      if (forecastManager.getForecastForCity(upperOrLower).isEmpty()) {
        setErrorLabel(upperOrLower, "No previous forecast found.");
      } else {
        displayCityForecast(upperOrLower);
        backBtn.setVisible(false);
      }
      
    });
  }
  
  private void displayCityForecast(UpperOrLower upperOrLower) {
    HBox hBox = getHbox(upperOrLower);
    hBox.getChildren().clear();
    setCityLabel(upperOrLower, localizationString(forecastManager.getCityData(upperOrLower).get()));
    setUpCardForEachDay(forecastManager.getForecastForCity(upperOrLower).get(), hBox);
  }
  
  private void setContextMenuIfMoreCitiesFound(UpperOrLower upperOrLower) {
    TextField textField = getTextField(upperOrLower);
    ContextMenu contextMenu = new ContextMenu();
    for (CityData city : cityFounder.getCityData()) {
      MenuItem item = new MenuItem(localizationString(city));
      item.setOnAction(event -> {
        setCity(upperOrLower, city);
        findForecastAndDisplayIfValid(upperOrLower);
      });
      contextMenu.getItems().add(item);
    }
    textField.setContextMenu(contextMenu);
    contextMenu.show(textField, Side.BOTTOM, 0, 0);
    //show context menu on click: left also!
    textField.setOnMouseClicked(event -> contextMenu.show(textField, Side.BOTTOM, 0, 0));
  }
  
  private TextField getTextField(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperSearchCityTextField;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerSearchCityTextField;
    }
    return null;
  }
  
  private HBox getHbox(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperHbox;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerHbox;
    }
    return null;
  }
  
  private Label getErrorLabel(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperErrorLabel;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerErrorLabel;
    }
    return null;
  }
  
  private Button setPreviousForecastButton(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperPreviousForecastButton;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerPreviousForecastButton;
    }
    return null;
  }
  
  private void setErrorLabel(UpperOrLower upperOrLower, String errorText) {
    HBox hBox = getHbox(upperOrLower);
    Label errorLabel = getErrorLabel(upperOrLower);
    hBox.getChildren().clear();
    errorLabel.setText(errorText);
    hBox.getChildren().add(errorLabel);
  }
  
  private void setCityLabel(UpperOrLower upperOrLower, String cityCountryAdministrativeArea) {
    if (upperOrLower == UpperOrLower.UPPER) {
      upperCityLabel.setText(cityCountryAdministrativeArea);
    } else if (upperOrLower == UpperOrLower.LOWER) {
      lowerCityLabel.setText(cityCountryAdministrativeArea);
    }
  }
  
  private void setUpHbox() {
    upperHbox.setAlignment(Pos.CENTER);
    upperHbox.setSpacing(10);
    lowerHbox.setAlignment(Pos.CENTER);
    lowerHbox.setSpacing(10);
  }
  
  private String localizationString(CityData cityData) {
    String city = cityData.getLocalizedName();
    String country = cityData.getCountry().getLocalizedName();
    String administrativeArea = cityData.getAdministrativeArea().getLocalizedName();
    return city + ", " + country + ", " + administrativeArea;
  }
  
  private void setUpCardForEachDay(ForecastForCity forecastForCity, HBox hbox) {
    WeatherCardCreator cardCreator = new WeatherCardCreator();
    for (ForecastForCity.DailyForecasts forecast : forecastForCity.getDailyForecasts()) {
      GridPane gridPane = cardCreator.createCard(forecast);
      hbox.getChildren().add(gridPane);
    }
  }
  
}
