package com.example.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Testform {

  public static void testform() {
    int width = 200;
    int height = 200;
    Font font = new Font("SansSerif", Font.BOLD, 14);
    int m = 0;
    int txt_width = 260;
    int txt_height = 27;
    JFrame form = new JFrame();
    JFileChooser f = new JFileChooser();


    form.add(f);
    form.pack();
    form.setSize(1000, 800);
    form.setVisible(true);
  }

  public static void main(String[] args) {
    testform();
  }
}
