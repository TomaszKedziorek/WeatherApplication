package com.tom.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.*;

class ApiCallerTest {
  private static ApiCaller apiCaller;
  
  @BeforeAll
  public static void initialize() {
    apiCaller = new ApiCaller(new RequestCaller(HttpClient.newHttpClient()));
  }
  
  @ParameterizedTest
  @ValueSource(ints = {200, 201, 299})
  void shouldReturnTrueIfStatusCodeIs200Something(int statusCode) {
    //given
    //in BeforeAll
    //when
    ApiCallResult result = apiCaller.result(statusCode);
    //then
    assertTrue(result.isStatusCode200());
  }
  
  @ParameterizedTest
  @ValueSource(ints = {300, 400, 401, 402, 403, 500, 503})
  void shouldReturnFalseIfStatusCodeIsOtherThan200Something(int statusCode) {
    //given
    //in BeforeAll
    //when
    ApiCallResult result = apiCaller.result(statusCode);
    //then
    assertFalse(result.isStatusCode200());
  }
  
  @ParameterizedTest
  @ValueSource(ints = {300, 400, 401, 402, 403, 500, 503})
  void errorStringShouldNotBeEmptyIfStatusCodeIsNot200(int statusCode) {
    //given
    //in BeforeAll
    //when
    ApiCallResult result = apiCaller.result(statusCode);
    //then
    assertNotEquals(result.getErrorString(), null);
    assertFalse(result.getErrorString().isEmpty());
  }
  
  @ParameterizedTest
  @ValueSource(ints = {200, 201, 299})
  void errorStringShouldBeEmptyIfStatusCodeIs200(int statusCode) {
    //given
    //in BeforeAll
    //when
    ApiCallResult result = apiCaller.result(statusCode);
    //then
    assertNotEquals(result.getErrorString(), null);
    assertTrue(result.getErrorString().isEmpty());
  }
}