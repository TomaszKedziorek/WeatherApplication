package com.tom.model;

import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


class RequestCallerTest {
  
  @Test
  void shouldThrownExceptionIfUriIsWrong() {
    //given
    HttpClient client = mock(HttpClient.class);
    RequestCaller requestCaller = new RequestCaller(client);
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> requestCaller.callRequestAsync(anyString()));
  }
}