package com.example.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.functions.Functions;

public class Query {
  static Connection conn = null;
  ResultSet resultSet;
  Statement statement;
  Functions fn = new Functions();

  public List<Map<String, ?>> query(String query_string) {

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");

      statement = conn.createStatement();

      resultSet = statement.executeQuery(query_string);

      /*
       * int code;
       * String title;
       * while (resultSet.next()) {
       * code = resultSet.getInt("code");
       * title = resultSet.getString("title").trim();
       * System.out.println("Code : " + code
       * + " Title : " + title);
       * }
       */

      return fn.resultSetToList(resultSet);

    } catch (SQLException ex) {
      // custom title, error icon
      JFrame frame = new JFrame("Error");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, ex.getMessage(),
          "Server Error (" + ex.getSQLState() + " " + ex.getErrorCode() + ")",
          JOptionPane.ERROR_MESSAGE);
    } finally {

    }
    return null;
  }

  public int query_none(String query) {
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");
      Statement statement;
      statement = conn.createStatement();
      ResultSet resultSet;
      resultSet = statement.executeQuery(query);
     

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

  public  ResultSet retrieveData(String Query) throws SQLException {
    try {
      // Registering the Driver
     // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      // Getting the connection

      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");

      // Creating a Statement object
      Statement stmt = con.createStatement();
      // Retrieving the data
      ResultSet rs = stmt.executeQuery(Query);
      return rs;
    } catch (Exception ex) {
      // custom title, error icon
      JFrame frame = new JFrame("Error");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, ex.getMessage(),
          "Server Error",
          JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }
}
