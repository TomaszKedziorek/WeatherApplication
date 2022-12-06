package com.tom.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class RequestCaller {
  
  private final HttpClient client;
  
  
  public RequestCaller() {
    client = HttpClient.newHttpClient();
  }
  
  private HttpRequest getNewRequest(String uri) {
    uri = uri.replaceAll("\\s+","%20");
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .GET()
            .build();
    return request;
  }
  public HttpResponse<String> callRequestAsync(String uri) {
    HttpRequest request = getNewRequest(uri);
    HttpResponse<String> httpResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .join();
    return httpResponse;
  }
}
