package com.example.Logic;

import com.example.Data.Query;

public class Login {
  public int login(String username, String password) {
    Query q = new Query();
    int response = q
        .query_none("SELECT * FROM users WHERE username='" + username + "' And password='" + password + "'");
    return response;
  }

 
}
