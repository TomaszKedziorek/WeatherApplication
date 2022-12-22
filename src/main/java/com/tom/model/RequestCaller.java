package com.tom.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class RequestCaller {
  
  private final HttpClient client;
  
  
  public RequestCaller(HttpClient client) {
    this.client = client;
  }
  
  private HttpRequest getNewRequest(String uri) {
    return HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .GET()
            .build();
  }
  
  public HttpResponse<String> callRequestAsync(String uri) {
    HttpRequest request = getNewRequest(uri);
    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .join();
  }
}
