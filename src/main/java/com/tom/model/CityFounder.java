package com.tom.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.net.http.HttpResponse;

public class CityFounder {
  private List<CityData> cityData;
  private final ApiCaller apiCaller;
  private ApiCallResult apiCallResult;
  
  public CityFounder(RequestCaller requestCaller) {
    this.apiCaller = new ApiCaller(requestCaller);
  }
  
  public List<CityData> getCityData() {
    return cityData;
  }
  
  public ApiCallResult getApiCallResult() {
    return apiCallResult;
  }
  
  private String createUri(String endPoint) {
    endPoint = URLEncoder.encode(endPoint, StandardCharsets.UTF_8);
    String language = "en-us";
    return "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + Config.getApiKey() + "&q=" + endPoint + "&language=" + language;
  }
  
  public void findCityByName(String cityName) {
    HttpResponse<String> httpResponse = apiCaller.callForData(createUri(cityName));
    apiCallResult = apiCaller.result(httpResponse.statusCode());
    if (apiCallResult.isStatusCode200()) {
      cityData = deserializeCity(httpResponse.body());
    } else {
      cityData = null;
    }
  }
  
  private List<CityData> deserializeCity(String jsonString) {
    Gson gson = new Gson();
    //For array as a root object in json if we want to make it e.g. List object
    Type foundListType = new TypeToken<List<CityData>>() {
    }.getType();
    return gson.fromJson(jsonString, foundListType);
  }
  
  
}
