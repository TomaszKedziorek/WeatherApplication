package com.tom.model;

public class ApiCallResult {
  
  private boolean isStatusCode200;
  private String errorString;
  
  public ApiCallResult(boolean isStatusCode200, String errorString) {
    this.errorString = errorString;
    this.isStatusCode200 = isStatusCode200;
  }
  
  public boolean isStatusCode200() {
    return isStatusCode200;
  }
  
  public String getErrorString() {
    return errorString;
  }
  
}
