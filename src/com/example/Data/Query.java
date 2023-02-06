package com.example.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.functions.Functions;

public class Query {
  static Connection conn = null;
  Functions fn = new Functions();

  public ArrayList query(String query_string) {
    ArrayList ls = new ArrayList<>();
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "P@$$w0rd");
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
  public int query_none(String query) {
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");
      Statement statement;
      statement = conn.createStatement();
      ResultSet resultSet;
      resultSet = statement.executeQuery(query);
      System.out.println(fn.resultSetToList(resultSet));

      if (fn.resultSetToList(resultSet).size() >= 1) {
        resultSet.close();
        statement.close();
        conn.close();
        return 1;
      } else {
        resultSet.close();
        statement.close();
        conn.close();
        return 0;
      }

    } catch (SQLException ex) {
      // custom title, error icon
      JFrame frame = new JFrame("Error");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, ex.getMessage(),
          "Server Error (" + ex.getSQLState() + " " + ex.getErrorCode() + ")",
          JOptionPane.ERROR_MESSAGE);
    }
    return 2;
  }

}
