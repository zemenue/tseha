package com.example;

import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("calender");
        JDateChooser dateChooser = new JDateChooser(new Date());
        dateChooser.setLocale(new Locale("am"));
        dateChooser.setDateFormatString("dd/MM/yyyy");
        f.add(dateChooser);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Home m = new Home();
        m.home();

        /*
         * Login l = new Login();
         * l.login();
         */

    }

}
