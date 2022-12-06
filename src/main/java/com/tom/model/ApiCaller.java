package com.tom.model;

import java.net.http.HttpResponse;

public abstract class ApiCaller {
  private final RequestCaller requestCaller;
  private String errorString;
  
  public ApiCaller(RequestCaller requestCaller){
    this.requestCaller = requestCaller;
  }
  protected abstract HttpResponse<String> callForData(String endPoint);
  
  public RequestCaller getRequestCaller() {
    return requestCaller;
  }
  
  public String getErrorString() {
    return errorString;
  }
  
  public boolean isStatusCode200(int statusCode){
    switch (statusCode) {
      case 200:
        errorString = "OK";
        return true;
      case 400:
        errorString = "Request had bad syntax or the parameters supplied were invalid.";
        return false;
      case 401:
        errorString = "Unauthorized. API authorization failed.";
        return false;
      case 403:
        errorString = "Unauthorized. You do not have permission to access this endpoint.";
        return false;
      case 404:
        errorString = "Server has not found a route matching the given URI.";
        return false;
      case 500:
        errorString = "Server encountered an unexpected condition which prevented it from fulfilling the request.";
        return false;
      case 503:
        errorString = "The allowed number of requests has been exceeded.";
        return false;
      default:
        errorString = "Error occurred.";
        return false;
    }
  }
}
