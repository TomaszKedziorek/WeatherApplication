package com.tom.view;

import com.tom.model.ForecastForCity;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class WeatherCardCreator {
  public GridPane createCard(ForecastForCity.DailyForecasts forecast) {
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.getStyleClass().add("grid-pane-class");
    gridPane.setVgap(3);
    gridPane.setHgap(3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setPrefWidth(190);
    
    //Date
    createDateGridPaneCell(gridPane, forecast);
    //Temperature
    createTemperatureGridPaneCells(gridPane, "Tmin", forecast.getTemperature().getMinimum());
    createTemperatureGridPaneCells(gridPane, "Tmax", forecast.getTemperature().getMaximum());
    //Day
    createDayNightGridPaneCells(gridPane, "day", forecast.getDay());
    
    //Night
    createDayNightGridPaneCells(gridPane, "night", forecast.getNight());
    
    return gridPane;
  }
  
  public void createDateGridPaneCell(GridPane pane, ForecastForCity.DailyForecasts forecast) {
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(forecast.getDate());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,   dd.MM");
    Label date = new Label(zonedDateTime.format(formatter.withLocale(Locale.ENGLISH)));
    GridPane.setConstraints(date, 0, 0, 10, 1);
    GridPane.setHalignment(date, HPos.CENTER);
    pane.getChildren().add(date);
  }
  
  public void createTemperatureGridPaneCells(GridPane pane, String minOrMax, ForecastForCity.MinMax forecastTemperature) {
    Label temperatureMinMaxLabel = new Label(minOrMax + ": ");
    Label temperatureMinMax = new Label(String.valueOf(forecastTemperature.getValue()));
    Label temperatureMinMaxUnit = new Label("°" + forecastTemperature.getUnit());
    //Set constraints
    //Layout of elements inside gridPane
    int colTemperatureMinMax = 0;
    if (minOrMax.equalsIgnoreCase("Tmin")) {
      //cells for Tmin starts in column 2
      colTemperatureMinMax = 1;
    } else if (minOrMax.equalsIgnoreCase("Tmax")) {
      //cells for Tmax starts in column 7
      colTemperatureMinMax = 7;
    }
    GridPane.setConstraints(temperatureMinMaxLabel, colTemperatureMinMax, 1);
    GridPane.setConstraints(temperatureMinMax, colTemperatureMinMax + 1, 1);
    GridPane.setConstraints(temperatureMinMaxUnit, colTemperatureMinMax + 2, 1);
    pane.getChildren().addAll(temperatureMinMaxLabel, temperatureMinMax, temperatureMinMaxUnit);
    
  }
  
  private Label createLabelWithClass(String cssClass, String text) {
    Label label = new Label(text);
    label.getStyleClass().add(cssClass);
    return label;
  }
  
  public void createDayNightGridPaneCells(GridPane pane, String dayOrNight, ForecastForCity.DayNight forecastDayNight) {
    //DayNight
    Label dayNight = createLabelWithClass(dayOrNight, dayOrNight + ":");
    ImageView iconDayNight = IconResolver.getIconForGivenIconNumber(forecastDayNight.getIcon());
    Label iconDayNightPhrase = createLabelWithClass(dayOrNight, forecastDayNight.getIconPhrase());
    //Precipitation
    Label dayNightPrecipitationLabel = createLabelWithClass(dayOrNight, "Precipitation:");
    Label dayNightPrecipitationType = createLabelWithClass(dayOrNight, "");
    Label dayNightPrecipitationIntensityLabel = createLabelWithClass(dayOrNight, "");
    Label dayNightPrecipitationIntensity = createLabelWithClass(dayOrNight, "");
    if (forecastDayNight.hasPrecipitation()) {
      dayNightPrecipitationType.setText(forecastDayNight.getPrecipitationType());
      dayNightPrecipitationIntensityLabel.setText("Intensity:");
      dayNightPrecipitationIntensity.setText(forecastDayNight.getPrecipitationIntensity());
    } else {
      dayNightPrecipitationType.setText("no");
    }
    
    //Layout of elements inside gridPane
    int rowForDayNight = 0;
    if (dayOrNight.equalsIgnoreCase("day")) {
      //cells for Day starts in row 2
      rowForDayNight = 2;
    } else if (dayOrNight.equalsIgnoreCase("night")) {
      //cells for Night starts in row 6
      rowForDayNight = 6;
    }
    GridPane.setConstraints(dayNight, 0, rowForDayNight, 3, 1);
    GridPane.setConstraints(iconDayNight, 3, rowForDayNight, 4, 1);
    GridPane.setConstraints(iconDayNightPhrase, 1, rowForDayNight + 1, 8, 1);
    GridPane.setConstraints(dayNightPrecipitationLabel, 1, rowForDayNight + 2, 4, 1);
    GridPane.setConstraints(dayNightPrecipitationType, 6, rowForDayNight + 2, 4, 1);
    GridPane.setConstraints(dayNightPrecipitationIntensityLabel, 1, rowForDayNight + 3, 4, 1);
    GridPane.setConstraints(dayNightPrecipitationIntensity, 6, rowForDayNight + 3, 4, 1);
    
    pane.getChildren().addAll(dayNight, iconDayNight, iconDayNightPhrase);
    pane.getChildren().addAll(dayNightPrecipitationLabel, dayNightPrecipitationType, dayNightPrecipitationIntensityLabel, dayNightPrecipitationIntensity);
    
  }
  
}
