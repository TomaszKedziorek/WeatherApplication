package com.tom.stub;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tom.model.CityData;

import java.lang.reflect.Type;
import java.util.List;

public class CityFounderStub {
  
  private List<CityData> cityData;
  
  private String jsonStringFromApi = "[{'Version':1,'Key':'274663','Type':'City','Rank':20,'LocalizedName':'Warszawa','EnglishName':'Warsaw','PrimaryPostalCode':'','Region':{'ID':'EUR','LocalizedName':'Europa','EnglishName':'Europe'},'Country':{'ID':'PL','LocalizedName':'Polska','EnglishName':'Poland'},'AdministrativeArea':{'ID':'14','LocalizedName':'Mazowieckie','EnglishName':'Masovia','Level':1,'LocalizedType':'Województwo','EnglishType':'Voivodship','CountryID':'PL'},'TimeZone':{'Code':'CET','Name':'Europe/Warsaw','GmtOffset':1.0,'IsDaylightSaving':false,'NextOffsetChange':'2023-03-26T01:00:00Z'},'GeoPosition':{'Latitude':52.232,'Longitude':21.007,'Elevation':{'Metric':{'Value':112.0,'Unit':'m','UnitType':5},'Imperial':{'Value':367.0,'Unit':'ft','UnitType':0}}},'IsAlias':false,'SupplementalAdminAreas':[{'Level':2,'LocalizedName':'Warszawa','EnglishName':'Warsaw'},{'Level':3,'LocalizedName':'Warszawa','EnglishName':'Warsaw'}],'DataSets':['AirQualityCurrentConditions','AirQualityForecasts','Alerts','DailyPollenForecast','ForecastConfidence','FutureRadar','MinuteCast','Radar']},{'Version':1,'Key':'2696858','Type':'City','Rank':85,'LocalizedName':'Warszawa','EnglishName':'Warszawa','PrimaryPostalCode':'','Region':{'ID':'EUR','LocalizedName':'Europa','EnglishName':'Europe'},'Country':{'ID':'PL','LocalizedName':'Polska','EnglishName':'Poland'},'AdministrativeArea':{'ID':'26','LocalizedName':'Świętokrzyskie','EnglishName':'Holy Cross','Level':1,'LocalizedType':'Województwo','EnglishType':'Voivodship','CountryID':'PL'},'TimeZone':{'Code':'CET','Name':'Europe/Warsaw','GmtOffset':1.0,'IsDaylightSaving':false,'NextOffsetChange':'2023-03-26T01:00:00Z'},'GeoPosition':{'Latitude':50.36,'Longitude':21.135,'Elevation':{'Metric':{'Value':162.0,'Unit':'m','UnitType':5},'Imperial':{'Value':531.0,'Unit':'ft','UnitType':0}}},'IsAlias':false,'ParentCity':{'Key':'2673731','LocalizedName':'Komorów','EnglishName':'Komorów'},'SupplementalAdminAreas':[{'Level':2,'LocalizedName':'Busko','EnglishName':'Busko'},{'Level':3,'LocalizedName':'Pacanów','EnglishName':'Pacanów'}],'DataSets':['AirQualityCurrentConditions','AirQualityForecasts','Alerts','DailyPollenForecast','ForecastConfidence','FutureRadar','MinuteCast','Radar']}]";
  
  public CityFounderStub(){
    Gson gson = new Gson();
    //For array as a root object in json if we want to make it e.g. List object
    Type foundListType = new TypeToken<List<CityData>>() {}.getType();
    this.cityData = gson.fromJson(jsonStringFromApi, foundListType);
  }
  
  public List<CityData> getCityDataStub() {
    return cityData;
  }
  
  public String getJsonStringFromApi() {
    return jsonStringFromApi;
  }
}
