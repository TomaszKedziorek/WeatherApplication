package com.tom.model;

import com.tom.stub.CityFounderStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CityFounderTest {

  private static CityFounder cityFounder;
  private static RequestCaller requestCaller;
  private HttpResponse httpResponse;
  
  @BeforeAll
  public static void initializeBeforeAll(){
    requestCaller = mock(RequestCaller.class);
    cityFounder = new CityFounder(requestCaller);
  }
  @BeforeEach
  public void initializeBeforeEach(){
    httpResponse = mock(HttpResponse.class);
  }
  
  @Test
  void shouldReturnNullIfStatusCodeIsNot200(){
    //given
    given(httpResponse.statusCode()).willReturn(500);
    given(requestCaller.callRequestAsync(anyString())).willReturn(httpResponse);
    //when
    cityFounder.findCityByName(anyString());
    //then
    assertNull(cityFounder.getCityData());
  }

  @Test
  void shouldReturnCityFounderDataStabIfStatusCodeIs200() {
    //given
    CityFounderStub cityFounderStub = new CityFounderStub();
    given(requestCaller.callRequestAsync(anyString())).willReturn(httpResponse);
    given(httpResponse.statusCode()).willReturn(200);
    given(httpResponse.body()).willReturn(cityFounderStub.getJsonStringFromApi());
        //when
    cityFounder.findCityByName(anyString());
    //then
    assertEquals(cityFounder.getCityData().size(), cityFounderStub.getCityDataStub().size());
    assertEquals(cityFounder.getCityData(), cityFounderStub.getCityDataStub());
    assertNotSame(cityFounder.getCityData(), cityFounderStub.getCityDataStub());
  }
}