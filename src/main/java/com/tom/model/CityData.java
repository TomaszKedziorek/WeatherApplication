package com.tom.model;

import com.google.gson.annotations.SerializedName;

public class CityData{
  @SerializedName("LocalizedName")
  private String localizedName;
  @SerializedName("EnglishName")
  private String englishName;
  @SerializedName("Type")
  private String type;
  @SerializedName("Key")
  private String key;
  @SerializedName("GeoPosition")
  private GeoPosition geoPosition;
  @SerializedName("Country")
  private Country country;
  @SerializedName("AdministrativeArea")
  private AdministrativeArea administrativeArea;
  @SerializedName("TimeZone")
  private TimeZone timeZone;
  
  public String getLocalizedName() {
    return localizedName;
  }
  public String getEnglishName() {
    return englishName;
  }
  public String getKey() {
    return key;
  }
  public GeoPosition getGeoPosition() {
    return geoPosition;
  }
  public Country getCountry() {
    return country;
  }
  public AdministrativeArea getAdministrativeArea() {
    return administrativeArea;
  }
  
  public class GeoPosition {
    @SerializedName("Latitude")
    private double latitude;
    @SerializedName("Longitude")
    private double longitude;
    
    public double getLatitude() {
      return latitude;
    }
    public double getLongitude() {
      return longitude;
    }
  }
  
  public class Country {
    @SerializedName("ID")
    private String id;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("EnglishName")
    private String englishName;
    
    public String getLocalizedName() {
      return localizedName;
    }
    public String getEnglishName() {
      return englishName;
    }
  }
  
  public class AdministrativeArea {
    @SerializedName("ID")
    private String id;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("EnglishName")
    private String englishName;
    @SerializedName("LocalizedType")
    private String localizedType;
    @SerializedName("EnglishType")
    private String englishType;
    
    public String getLocalizedName() {
      return localizedName;
    }
    public String getEnglishName() {
      return englishName;
    }
  }
  
  public class TimeZone {
    @SerializedName("Code")
    private String code;
    @SerializedName("Name")
    private String name;
    @SerializedName("GmtOffset")
    private double gmtOffset;
    @SerializedName("IsDaylightSaving")
    private boolean isDaylightSaving;
    @SerializedName("NextOffsetChange")
    private String nextOffsetChange;
  }
  
}
