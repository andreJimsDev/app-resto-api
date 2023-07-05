package com.opendevup.shop.adapters.restapi.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
  private String token;
  private Long id;
  private String username;
  private List<String> roles;
}
