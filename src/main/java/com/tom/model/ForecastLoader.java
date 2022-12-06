package com.tom.model;

import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class ForecastLoader extends ApiCaller{
  
  private ForecastForCity forecastForCity;
  
  public ForecastLoader(RequestCaller requestCaller) {
    super(requestCaller);
  }
  
  public ForecastForCity getForecastForCity() {
    return forecastForCity;
  }
  
  @Override
  protected HttpResponse<String> callForData(String endPoint) {
    String language = "en-us";
    String uri = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + endPoint + "?apikey=" + Config.getAPI_KEY() + "&language=" + language + "&metric=true";
    return getRequestCaller().callRequestAsync(uri);
  }
  public void getForecastsForCity(String cityKey) {
    HttpResponse<String> httpResponse = callForData(cityKey);
    if(isStatusCode200(httpResponse.statusCode())){
      forecastForCity =  deserializeForecasts(httpResponse.body());
    }else {
      forecastForCity = null;
    }
  }
  
  private ForecastForCity deserializeForecasts(String jsonForecasts) {
    Gson gson = new Gson();
    return gson.fromJson(jsonForecasts, ForecastForCity.class);
  }
}
