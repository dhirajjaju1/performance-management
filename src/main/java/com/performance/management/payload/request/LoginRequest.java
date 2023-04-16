package com.performance.management.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
