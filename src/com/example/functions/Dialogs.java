package com.example.functions;

import javax.swing.*;

public class Dialogs {
    public void info(String message, String title) {
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void error(String message, String title) {
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

}
