package com.tom;

import com.tom.model.*;

import java.net.http.HttpClient;
import java.util.Optional;

public class ForecastManager {
  
  private CityData upperCityData;
  private CityData lowerCityData;
  private ForecastForCity upperForecastForCity;
  private ForecastForCity lowerForecastForCity;
  private final RequestCaller requestCaller;
  
  public ForecastManager() {
    this.requestCaller = new RequestCaller(HttpClient.newHttpClient());
  }
  
  public RequestCaller getRequestCaller() {
    return requestCaller;
  }
  
  public Optional<ForecastForCity> getForecastForCity(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return Optional.ofNullable(upperForecastForCity);
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return Optional.ofNullable(lowerForecastForCity);
    }
    return Optional.empty();
  }
  
  public Optional<CityData> getCityData(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return Optional.ofNullable(upperCityData);
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return Optional.ofNullable(lowerCityData);
    }
    return Optional.empty();
  }
  
  public void setCityData(UpperOrLower upperOrLower, CityData cityData) {
    if (upperOrLower == UpperOrLower.UPPER) {
      this.upperCityData = cityData;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      this.lowerCityData = cityData;
    }
  }
  
  public void setCityForecast(UpperOrLower upperOrLower, ForecastForCity forecastForCity) {
    if (upperOrLower == UpperOrLower.UPPER) {
      this.upperForecastForCity = forecastForCity;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      this.lowerForecastForCity = forecastForCity;
    }
  }
  
}



