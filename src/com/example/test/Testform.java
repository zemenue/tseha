package com.example.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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

    JPanel panel_container = new JPanel();
    panel_container.setLayout(new FlowLayout());
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.BLACK);
    panel1.setSize(width, height);
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.BLUE);
    panel2.setSize(width, height);
    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.MAGENTA);
    panel3.setSize(width, height);
    JPanel panel4 = new JPanel();
    panel4.setBackground(Color.green);
    panel4.setSize(width, height);

    panel1.setVisible(true);
    panel1.setLayout(null);
    panel1.setBounds(20, 20, txt_width, txt_height);
    JLabel message = new JLabel("Drug Name");
    message.setBounds(10, 10 + m, 80, 30);
    message.setVisible(true);
    panel1.add(message);

    JTextField drug_name = new JTextField(100);
    drug_name.setBounds(10, 35 + m, 80, 27);
    drug_name.setFont(font);
    drug_name.setVisible(true);
    panel1.add(drug_name);
    panel1.setPreferredSize(new Dimension(200, 200));
    panel_container.add(panel1);
    panel_container.add(panel2);
    panel_container.add(panel3);
    panel_container.add(panel4);

    form.add(panel_container);
    form.pack();
    form.setSize(1000, 800);
    form.setVisible(true);
  }

  public static void main(String[] args) {
    testform();
  }
}
