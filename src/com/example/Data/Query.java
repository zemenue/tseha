package com.example.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Query {
  static Connection conn = null;

  public ArrayList query(String query_string) {
    ArrayList ls = new ArrayList<>();
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
      // custom title, error icon
      JFrame frame = new JFrame("Swing Tester");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, ex.getMessage(),
          "Server Error (" + ex.getSQLState() + " " + ex.getErrorCode() + ")",
          JOptionPane.ERROR_MESSAGE);
    }
    return ls;
  }
}
