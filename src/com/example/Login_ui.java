package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.Logic.Login;

public class Login_ui {
  JFrame login_JFrame = new JFrame("Login");
  public void login() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    login_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Define the panel to hold the buttons
    JPanel panel = new JPanel();
    login_JFrame.add(panel);
    placeComponents(panel);
    login_JFrame.pack();
    login_JFrame.setSize(420, 250);
    login_JFrame.setLocation(500, 500);
    login_JFrame.setVisible(true);
  }

  private void placeComponents(JPanel panel) {
    int m = 50;
    panel.setLayout(null);
    ///////////////// ----------------/////////////
    JLabel message = new JLabel("Message");
    message.setBounds(100, 10 + m, 300, 25);
    panel.add(message);
    ///////////////// --------------/////////////
    JLabel userLabel = new JLabel("Username");
    userLabel.setBounds(50, 50 + m, 80, 25);
    panel.add(userLabel);
    //////////////// ---------------/////////////
    JTextField userText = new JTextField(20);
    userText.setBounds(150, 50 + m, 200, 25);
    panel.add(userText);
    /////////////// ---------------//////////////
    JLabel passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(50, 80 + m, 80, 25);
    panel.add(passwordLabel);
    ////////////// -------------//////////////
    JPasswordField passwordText = new JPasswordField(20);
    passwordText.setBounds(150, 80 + m, 200, 25);
    panel.add(passwordText);
    ////////////// ------------//////////////
    JButton loginButton = new JButton("Login");
    loginButton.setBounds(170, 120 + m, 80, 25);
    loginButton.addActionListener(new ActionListener() {
     
      @Override
      public void actionPerformed(ActionEvent e) {
        Login login = new Login();
        int res = login.login(userText.getText(), String.valueOf(passwordText.getPassword()));
        Home m = new Home();
        if (res == 1) {
          m.home();
          login_JFrame.dispose();
        } else if (res == 0) {
          message.setText("Username or password error");
        }
        else {
          message.setText("Server Error.");
        }
      }
    });
    panel.add(loginButton);
    /////////////// -----------/////////////
    JButton cancel = new JButton("Cancel");
    cancel.setBounds(260, 120 + m, 90, 25);
    cancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);

      }
    });
    panel.add(cancel);
  }
}