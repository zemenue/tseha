package com.example;

import com.example.Data.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class App {


    private App() {
    }

    public static void main(String[] args) {
        check_new_installation();
        Login_ui l = new Login_ui();
        l.login();
       /* Manage_user user=new Manage_user();
        user.add_user();*/
        // user.test();


    }

    private static void check_new_installation() {
        try {
            Query q = new Query();
            ResultSet resultSet = q.retrieveData("select * from users where username='admin'");

            int count = 0;
            while (resultSet.next()) {
                count = count + 1;
            }
            if (count < 1) {
                q.query_none("INSERT INTO users (username,password,full_name,email,role) VALUES('admin','admin','tsehay taddese','Tsehay@gmail.com','admin')");

                System.out.println("Admin created.");

            }

        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

    }

}
