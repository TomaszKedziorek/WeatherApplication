package com.tom;

import com.tom.model.*;

public class ForecastManager {
  
  private CityData upperCityData;
  private CityData lowerCityData;
  private ForecastForCity upperForecastForCity;
  private ForecastForCity lowerForecastForCity;
  private final RequestCaller requestCaller;
  
  public ForecastManager() {
    this.requestCaller = new RequestCaller();
  }
  
  public RequestCaller getRequestCaller() {
    return requestCaller;
  }
  
 
  public ForecastForCity getForecastForCity(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperForecastForCity;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerForecastForCity;
    }
    return null;
  }
  
  public CityData getCityData(UpperOrLower upperOrLower) {
    if (upperOrLower == UpperOrLower.UPPER) {
      return upperCityData;
    } else if (upperOrLower == UpperOrLower.LOWER) {
      return lowerCityData;
    }
    return null;
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



