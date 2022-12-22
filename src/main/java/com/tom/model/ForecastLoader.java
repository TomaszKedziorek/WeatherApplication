package com.tom.model;

import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class ForecastLoader {
  
  private ForecastForCity forecastForCity;
  private final ApiCaller apiCaller;
  private ApiCallResult apiCallResult;
  
  
  public ForecastLoader(RequestCaller requestCaller) {
    this.apiCaller = new ApiCaller(requestCaller);
  }
  
  public ForecastForCity getForecastForCity() {
    return forecastForCity;
  }
  
  public ApiCallResult getApiCallResult() {
    return apiCallResult;
  }
  
  private String createUri(String endPoint) {
    String language = "en-us";
    return "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + endPoint + "?apikey=" + Config.getApiKey() + "&language=" + language + "&metric=true";
  }
  
  public void findForecastsForCityByCityKey(String cityKey) {
    HttpResponse<String> httpResponse = apiCaller.callForData(createUri(cityKey));
    apiCallResult = apiCaller.result(httpResponse.statusCode());
    if (apiCallResult.isStatusCode200()) {
      forecastForCity = deserializeForecasts(httpResponse.body());
    } else {
      forecastForCity = null;
    }
  }
  
  private ForecastForCity deserializeForecasts(String jsonForecasts) {
    Gson gson = new Gson();
    return gson.fromJson(jsonForecasts, ForecastForCity.class);
  }
}
