package com.tom.model;

import java.net.http.HttpResponse;

public class ApiCaller {
  private final RequestCaller requestCaller;
  
  public ApiCaller(RequestCaller requestCaller) {
    this.requestCaller = requestCaller;
  }
  
  private RequestCaller getRequestCaller() {
    return requestCaller;
  }
  
  protected HttpResponse<String> callForData(String uri) {
    return getRequestCaller().callRequestAsync(uri);
  }
  
  public ApiCallResult result(int statusCode) {
    if (statusCode >= 200 && statusCode < 300) {
      return new ApiCallResult(true, "");
    } else {
      switch (statusCode) {
        case 400:
          return new ApiCallResult(false, "Request had bad syntax or the parameters supplied were invalid.");
        case 401:
          return new ApiCallResult(false, "Unauthorized. Check your API_KEY.");
        case 403:
          return new ApiCallResult(false, "Unauthorized. You do not have permission to access this endpoint. Check your API_KEY.");
        case 404:
          return new ApiCallResult(false, "Server has not found a route matching the given URI.");
        case 500:
          return new ApiCallResult(false, "Server encountered an unexpected condition which prevented it from fulfilling the request.");
        case 503:
          return new ApiCallResult(false, "The allowed number of requests has been exceeded.");
        default:
          return new ApiCallResult(false, "Error occurred. Please try again.");
      }
    }
  }
}
