package com.example.users.ui;

import com.example.Data.Query;
import com.example.users.Manage_user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Add_user {
    //Manage_user manage_user = new Manage_user();
    Font font = new Font("SansSerif", Font.BOLD, 14);
    JInternalFrame adduser = new JInternalFrame("Register Drug", false, true, false, true);
    Query q;
    int m = 0;
    int txt_width = 260;
    int txt_height = 27;
    Color background_color = new Color(199, 203, 199);
    Color panel_color = new Color(149, 150, 149);

    public Add_user() {
        q = new Query();
    }

    public JInternalFrame add_user() {


        // adduser.setDefaultLookAndFeelDecorated(true);
        adduser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        adduser.add(panel);
        placeComponents(panel);
        adduser.pack();
        adduser.setSize(600, 400);
        // adduser.setResizable(false);
        // adduser.setLocation(500, 500);
        adduser.setVisible(true);
        return adduser;
    }

    public void test() {
        JFrame adduser = new JFrame();
        // adduser.setDefaultLookAndFeelDecorated(true);
        adduser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        adduser.add(panel);
        placeComponents(panel);
        adduser.pack();
        adduser.setSize(600, 400);
        adduser.setResizable(false);
        // adduser.setLocation(500, 500);
        adduser.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        int m = 50;
        panel.setLayout(null);

        JPanel p_form = new JPanel();
        p_form.setLayout(null);
        p_form.setSize(700, 500);
        ///////
        JLabel message = new JLabel("Full Name");
        message.setBounds(10, 10 + m, 500, 30);
        p_form.add(message);
        JTextField fname = new JTextField(100);
        fname.setBounds(10, 35 + m, 550, 27);
        fname.setFont(font);
        p_form.add(fname);
        ///////

        ///////
        JLabel passwordLabel = new JLabel("Username");
        passwordLabel.setBounds(10, 65 + m, 200, 25);
        p_form.add(passwordLabel);

        JTextField username = new JTextField(20);
        username.setBounds(10, 90 + m, txt_width, txt_height);
        username.setFont(font);
        p_form.add(username);
        //////

        //////
        JLabel batch = new JLabel("Password");
        batch.setBounds(300, 65 + m, txt_width, 25);
        p_form.add(batch);
        JTextField password = new JTextField(100);
        password.setBounds(300, 90 + m, txt_width, txt_height);
        password.setFont(font);
        p_form.add(password);
        /////

        /////
        JLabel manu = new JLabel("Role");
        manu.setBounds(10, 120 + m, 200, 25);
        p_form.add(manu);

        JComboBox role = new JComboBox();
        role.addItem("Store Keeper");
        role.addItem("Pharmacist");
        role.addItem("Cashier");
        role.addItem("Manager");
        role.addItem("Admin");
        role.setBounds(10, 145 + m, txt_width, txt_height);
        role.setFont(font);
        p_form.add(role);

        /////
        JLabel emaill = new JLabel("Email");
        emaill.setBounds(300, 120 + m, 200, 25);
        p_form.add(emaill);
        JTextField email = new JTextField(20);
        email.setBounds(300, 145 + m, txt_width, txt_height);
        email.setFont(font);
        p_form.add(email);

        ///
        JButton register = new JButton("Register");
        register.setBounds(360, 200 + m, 100, 25);
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Query q = new Query();
                Manage_user manage_user=new Manage_user();
               byte[] hash = manage_user.encrypt(password.getText());
                int res = q.insert("INSERT INTO users (username,password,full_name,role,email,status)" +
                        "VALUES('" + username.getText() + "','" + hash.toString() + "','" + fname.getText() + "','" + role.getSelectedItem() + "'," +
                        "'" + email.getText() + "',2)");


                if (res == 1) {

                    //adduser.dispose();
                } else if (res == 0) {
                    // message.setText("Username or password error");
                } else {
                    // message.setText("Server Error.");
                }

            }
        });
        panel.add(register);
        /////////////// -----------/////////////
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(470, 200 + m, 90, 25);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adduser.dispose();

            }
        });
        panel.add(cancel);
        p_form.setVisible(true);
        panel.add(p_form);
    }


}
