package com.tom.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class CityData {
  @SerializedName("LocalizedName")
  private String localizedName;
  @SerializedName("Key")
  private String key;
  @SerializedName("Country")
  private Country country;
  @SerializedName("AdministrativeArea")
  private AdministrativeArea administrativeArea;
  
  public String getLocalizedName() {
    return localizedName;
  }
  
  public String getKey() {
    return key;
  }
  
  public Country getCountry() {
    return country;
  }
  
  public AdministrativeArea getAdministrativeArea() {
    return administrativeArea;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    CityData cityData = (CityData) o;
    
    if (!Objects.equals(localizedName, cityData.localizedName))
      return false;
    if (!Objects.equals(key, cityData.key)) return false;
    if (!Objects.equals(country, cityData.country)) return false;
    return Objects.equals(administrativeArea, cityData.administrativeArea);
  }
  
  @Override
  public int hashCode() {
    int result = localizedName != null ? localizedName.hashCode() : 0;
    result = 31 * result + (key != null ? key.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (administrativeArea != null ? administrativeArea.hashCode() : 0);
    return result;
  }
  
  public class Country {
    @SerializedName("LocalizedName")
    private String localizedName;
    
    public String getLocalizedName() {
      return localizedName;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      Country country = (Country) o;
      
      return Objects.equals(localizedName, country.localizedName);
    }
    
    @Override
    public int hashCode() {
      return localizedName != null ? localizedName.hashCode() : 0;
    }
  }
  
  public class AdministrativeArea {
    @SerializedName("LocalizedName")
    private String localizedName;
    
    public String getLocalizedName() {
      return localizedName;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      
      AdministrativeArea that = (AdministrativeArea) o;
      
      return Objects.equals(localizedName, that.localizedName);
    }
    
    @Override
    public int hashCode() {
      return localizedName != null ? localizedName.hashCode() : 0;
    }
  }
}
