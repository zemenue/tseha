package com.example.Data;

import com.example.functions.Dialogs;
import com.example.functions.Functions;

import javax.swing.*;
import java.sql.*;

public class Query {
    static Connection conn = null;
    ResultSet resultSet;
    Statement statement;
   // Functions fn = new Functions();
    Dialogs dialog = new Dialogs();

    public int insert(String query_string) {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");

            statement = conn.createStatement();

            if (statement.executeUpdate(query_string) >= 1) {
                return 1;
            }
        } catch (SQLException ex) {
            dialog.error("Error: " + ex.getMessage(), "Error");
        }
        return 2;
    }

    public int query_none(String query) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");
            Statement statement;
            statement = conn.createStatement();

            if (statement.executeUpdate(query) > 1) {

                statement.close();
                conn.close();
                return 1;
            } else {

                statement.close();
                conn.close();
                return 0;
            }

        } catch (SQLException ex) {
            dialog.error("Error: " + ex.getMessage(), "Error");
        }
        return 2;
    }

    public ResultSet retrieveData(String Query) throws SQLException {
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
            dialog.error("Error: " + ex.getMessage(), "Error");
        }
        return null;
    }

    public void Delete_update(String query, String message, String message_title, String error_message, String error_message_title, String confirm) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");
            Statement statement;
            statement = conn.createStatement();
            if (JOptionPane.showConfirmDialog(null, confirm, message_title,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                statement.executeUpdate(query);

                dialog.info(message, message_title);

                statement.close();
                conn.close();

            } else {
                // dialog.error("Error: " + error_message, error_message_title);
            }


        } catch (SQLException ex) {
            dialog.error("Error: " + error_message + ". " + ex.getMessage(), error_message_title);
        }
    }

}
