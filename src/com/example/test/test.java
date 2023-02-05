package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
  static Connection conn = null;

  public static void main(String[] args) {
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
      Statement statement;
      statement = conn.createStatement();
      ResultSet resultSet;
      resultSet = statement.executeQuery(
          "select * from designation");
      int code;
      String title;
      while (resultSet.next()) {
        code = resultSet.getInt("code");
        title = resultSet.getString("title").trim();
        System.out.println("Code : " + code
            + " Title : " + title);
      }
      resultSet.close();
      statement.close();
      conn.close();

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }

}
