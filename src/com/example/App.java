package com.example;

import java.io.File;
import java.io.IOException;

import com.example.Data.Query;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        File f = new File("icon/add.png");
        if (f.exists()) {
           // System.out.println("eehhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhe");
        }
       
        Query q = new Query();
        q.query("null");
        Home m = new Home();
        m.home();

        /*
         * Login l = new Login();
         * l.login();
         */

    }

}
