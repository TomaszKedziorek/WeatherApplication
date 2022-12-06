package com.tom.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.net.http.HttpResponse;

public class CityFounder extends ApiCaller {
  private List<CityData> cityData;
  
  public CityFounder(RequestCaller requestCaller) {
    super(requestCaller);
  }
  
  public List<CityData> getCityData() {
    return cityData;
  }
  
  @Override
  protected HttpResponse<String> callForData(String endPoint) {
    String language = "en-us";
    String uri = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + Config.getAPI_KEY() + "&q=" + endPoint + "&language=" + language;
    return getRequestCaller().callRequestAsync(uri);
  }
  
  public void findCityByName(String cityName) {
    HttpResponse<String> httpResponse = callForData(cityName);
    if(isStatusCode200(httpResponse.statusCode())){
      cityData = deserializeCity(httpResponse.body());
    }else{
      cityData = null;
    }
  }
  
  private List<CityData> deserializeCity(String jsonString) {
    Gson gson = new Gson();
    //For array as a root object in json if we want to make it e.g. List object
    Type foundListType = new TypeToken<List<CityData>>() {}.getType();
    return gson.fromJson(jsonString, foundListType);
  }
  
  
}
