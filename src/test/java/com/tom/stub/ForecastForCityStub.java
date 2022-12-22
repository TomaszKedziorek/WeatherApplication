package com.tom.stub;

import com.google.gson.Gson;
import com.tom.model.ForecastForCity;

public class ForecastForCityStub {
  
  private ForecastForCity forecastForCity;
  private String jsonStringFromApi = "{\"Headline\":{\"EffectiveDate\":\"2022-11-28T19:00:00+01:00\",\"EffectiveEpochDate\":1669658400,\"Severity\":7,\"Text\":\"Zimno w: poniedziałek noc\",\"Category\":\"cold\",\"EndDate\":\"2022-11-29T07:00:00+01:00\",\"EndEpochDate\":1669701600,\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?unit=c\"},\"DailyForecasts\":[{\"Date\":\"2022-11-28T07:00:00+01:00\",\"EpochDate\":1669615200,\"Temperature\":{\"Minimum\":{\"Value\":-3.9,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":2.2,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":7,\"IconPhrase\":\"Pochmurno\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":7,\"IconPhrase\":\"Pochmurno\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=1&unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=1&unit=c\"},{\"Date\":\"2022-11-29T07:00:00+01:00\",\"EpochDate\":1669701600,\"Temperature\":{\"Minimum\":{\"Value\":-6.7,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":0.6,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":8,\"IconPhrase\":\"Ponuro\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":8,\"IconPhrase\":\"Ponuro\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=2&unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=2&unit=c\"},{\"Date\":\"2022-11-30T07:00:00+01:00\",\"EpochDate\":1669788000,\"Temperature\":{\"Minimum\":{\"Value\":-6.7,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":0.6,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":8,\"IconPhrase\":\"Ponuro\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":8,\"IconPhrase\":\"Ponuro\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=3&unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=3&unit=c\"},{\"Date\":\"2022-12-01T07:00:00+01:00\",\"EpochDate\":1669874400,\"Temperature\":{\"Minimum\":{\"Value\":-4.4,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":0.6,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":7,\"IconPhrase\":\"Pochmurno\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":38,\"IconPhrase\":\"Zachmurzenie duże\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=4&unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=4&unit=c\"},{\"Date\":\"2022-12-02T07:00:00+01:00\",\"EpochDate\":1669960800,\"Temperature\":{\"Minimum\":{\"Value\":-5.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":-3.9,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":7,\"IconPhrase\":\"Pochmurno\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":7,\"IconPhrase\":\"Pochmurno\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=5&unit=c\",\"Link\":\"http://www.accuweather.com/pl/pl/warsaw/274663/daily-weather-forecast/274663?day=5&unit=c\"}]}";
  
  public ForecastForCityStub(){
    Gson gson = new Gson();
    this.forecastForCity = gson.fromJson(jsonStringFromApi,ForecastForCity.class);
  }
  
  public ForecastForCity getForecastForCityStub() {
    return forecastForCity;
  }
  
  public String getJsonStringFromApi() {
    return jsonStringFromApi;
  }
  
  
}
