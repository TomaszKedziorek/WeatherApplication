package com.tom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ForecastForCity {
  @SerializedName("DailyForecasts")
  private List<DailyForecasts> dailyForecasts;
  
  public List<DailyForecasts> getDailyForecasts() {
    return dailyForecasts;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    ForecastForCity that = (ForecastForCity) o;
    
    return Objects.equals(dailyForecasts, that.dailyForecasts);
  }
  
  @Override
  public int hashCode() {
    return dailyForecasts != null ? dailyForecasts.hashCode() : 0;
  }
  
  public class DailyForecasts {
    @SerializedName("Date")
    private String date;
    @SerializedName("Temperature")
    private Temperature temperature;
    @SerializedName("Day")
    private DayNight day;
    @SerializedName("Night")
    private DayNight night;
    
    public String getDate() {
      return date;
    }
    
    public Temperature getTemperature() {
      return temperature;
    }
    
    public DayNight getDay() {
      return day;
    }
    
    public DayNight getNight() {
      return night;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      DailyForecasts forecasts = (DailyForecasts) o;
      
      if (!Objects.equals(date, forecasts.date)) return false;
      if (!Objects.equals(temperature, forecasts.temperature))
        return false;
      if (!Objects.equals(day, forecasts.day)) return false;
      return Objects.equals(night, forecasts.night);
    }
    
    @Override
    public int hashCode() {
      int result = date != null ? date.hashCode() : 0;
      result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
      result = 31 * result + (day != null ? day.hashCode() : 0);
      result = 31 * result + (night != null ? night.hashCode() : 0);
      return result;
    }
  }
  
  public class Temperature {
    @SerializedName("Minimum")
    private MinMax minimum;
    @SerializedName("Maximum")
    private MinMax maximum;
    
    public MinMax getMinimum() {
      return minimum;
    }
    
    public MinMax getMaximum() {
      return maximum;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      Temperature that = (Temperature) o;
      
      if (!Objects.equals(minimum, that.minimum)) return false;
      return Objects.equals(maximum, that.maximum);
    }
    
    @Override
    public int hashCode() {
      int result = minimum != null ? minimum.hashCode() : 0;
      result = 31 * result + (maximum != null ? maximum.hashCode() : 0);
      return result;
    }
  }
  
  public class MinMax {
    @SerializedName("Value")
    private double value;
    @SerializedName("Unit")
    private String unit;
    @SerializedName("UnitType")
    private int unitType;
    
    public double getValue() {
      return value;
    }
    
    public String getUnit() {
      return unit;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      MinMax minMax = (MinMax) o;
      
      if (Double.compare(minMax.value, value) != 0) return false;
      if (unitType != minMax.unitType) return false;
      return Objects.equals(unit, minMax.unit);
    }
    
    @Override
    public int hashCode() {
      int result;
      long temp;
      temp = Double.doubleToLongBits(value);
      result = (int) (temp ^ (temp >>> 32));
      result = 31 * result + (unit != null ? unit.hashCode() : 0);
      result = 31 * result + unitType;
      return result;
    }
  }
  
  public class DayNight {
    @SerializedName("Icon")
    private int icon;
    @SerializedName("IconPhrase")
    private String iconPhrase;
    @SerializedName("HasPrecipitation")
    private boolean hasPrecipitation;
    @SerializedName("PrecipitationType")
    private String precipitationType;
    @SerializedName("PrecipitationIntensity")
    private String precipitationIntensity;
    
    public int getIcon() {
      return icon;
    }
    
    public String getIconPhrase() {
      return iconPhrase;
    }
    
    public boolean hasPrecipitation() {
      return hasPrecipitation;
    }
    
    public String getPrecipitationType() {
      return precipitationType;
    }
    
    public String getPrecipitationIntensity() {
      return precipitationIntensity;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      DayNight dayNight = (DayNight) o;
      
      if (icon != dayNight.icon) return false;
      if (hasPrecipitation != dayNight.hasPrecipitation) return false;
      if (!Objects.equals(iconPhrase, dayNight.iconPhrase)) return false;
      if (!Objects.equals(precipitationType, dayNight.precipitationType))
        return false;
      return Objects.equals(precipitationIntensity, dayNight.precipitationIntensity);
    }
    
    @Override
    public int hashCode() {
      int result = icon;
      result = 31 * result + (iconPhrase != null ? iconPhrase.hashCode() : 0);
      result = 31 * result + (hasPrecipitation ? 1 : 0);
      result = 31 * result + (precipitationType != null ? precipitationType.hashCode() : 0);
      result = 31 * result + (precipitationIntensity != null ? precipitationIntensity.hashCode() : 0);
      return result;
    }
  }
}
