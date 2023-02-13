package com.example.Logic;

import com.example.Data.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
  public ResultSet login(String username, String password) {
    Query q = new Query();
    ResultSet response;
    try {
      response = q
          .retrieveData("SELECT * FROM users WHERE username='" + username + "' And password='" + password + "'");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return response;
  }

 
}
