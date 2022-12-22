package com.tom.model;

import com.tom.stub.ForecastForCityStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ForecastLoaderTest {
  private static ForecastLoader forecastLoader;
  private static RequestCaller requestCaller;
  private HttpResponse httpResponse;
  
  @BeforeAll
  public static void initializeBeforeAll() {
    requestCaller = mock(RequestCaller.class);
    forecastLoader = new ForecastLoader(requestCaller);
  }
  
  @BeforeEach
  public void initializeBeforeEach() {
    httpResponse = mock(HttpResponse.class);
  }
  
  @Test
  void shouldReturnNullIfStatusCodeIsNot200() {
    //given
    given(httpResponse.statusCode()).willReturn(500);
    given(requestCaller.callRequestAsync(anyString())).willReturn(httpResponse);
    //when
    forecastLoader.findForecastsForCityByCityKey(anyString());
    //then
    assertNull(forecastLoader.getForecastForCity());
  }
  
  @Test
  void shouldReturnForecastForCityStabDataIfStatusCodeIs200() {
    //given
    ForecastForCityStub forecastForCityStub = new ForecastForCityStub();
    given(requestCaller.callRequestAsync(anyString())).willReturn(httpResponse);
    given(httpResponse.statusCode()).willReturn(200);
    given(httpResponse.body()).willReturn(forecastForCityStub.getJsonStringFromApi());
    //when
    forecastLoader.findForecastsForCityByCityKey(anyString());
    //then
    assertEquals(forecastLoader.getForecastForCity(), forecastForCityStub.getForecastForCityStub());
    assertNotSame(forecastLoader.getForecastForCity(), forecastForCityStub.getForecastForCityStub());
  }
}