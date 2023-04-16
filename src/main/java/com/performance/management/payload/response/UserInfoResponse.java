package com.performance.management.payload.response;

import java.util.List;

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
public class UserInfoResponse {
  private String _id;
  private String username;
  private String email;
  private List<String> roles;
  private String accessToken;
  private String employeeId;
  private String managersId;
}
