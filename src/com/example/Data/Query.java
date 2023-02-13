package com.example.Data;

import com.example.functions.Functions;

import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class Query {
    static Connection conn = null;
    ResultSet resultSet;
    Statement statement;
    Functions fn = new Functions();

    public int  insert (String query_string) {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");

            statement = conn.createStatement();

           if( statement.executeUpdate(query_string)>=1)
           {
               return 1;
           }
        } catch (SQLException ex) {
            // custom title, error icon
            JFrame frame = new JFrame("Error");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Server Error (" + ex.getSQLState() + " " + ex.getErrorCode() + ")",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

        }
        return 2;
    }

    public int query_none(String query) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "P@$$w0rd");
            Statement statement;
            statement = conn.createStatement();



            if (  statement.executeUpdate(query)>1) {

                statement.close();
                conn.close();
                return 1;
            } else {

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
