package com.tom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastForCity {
//  @SerializedName("Headline")
//  private Headline headline;
  @SerializedName("DailyForecasts")
  private List<DailyForecasts> dailyForecasts;
  public List<DailyForecasts> getDailyForecasts() {
    return dailyForecasts;
  }

//  public Headline getHeadline() {
//    return headline;
//  }
  
  public class DailyForecasts {
    @SerializedName("Date")
    private String date;
    @SerializedName("EpochDate")
    private long epochDate;
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
  }
  
  public class Headline {
    @SerializedName("EffectiveDate")
    private String effectiveDate;
    @SerializedName("EffectiveEpochDate")
    private long effectiveEpochDate;
    @SerializedName("Severity")
    private int severity;
    @SerializedName("Text")
    private String text;
    @SerializedName("Category")
    private String category;
    @SerializedName("EndDate")
    private String endDate;
    @SerializedName("EndEpochDate")
    private long endEpochDate;
    @SerializedName("Link")
    private String link;
  }
}
