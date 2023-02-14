package com.example.users;

import com.example.users.ui.Add_user;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Manage_user {
    public  byte[] encrypt(String txt){
        MessageDigest md= null;
        try {
            md = MessageDigest.getInstance("MD5");
           return md.digest(txt.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
    Add_user userui = new Add_user();

    public JInternalFrame add_user() {

        return userui.add_user();
    }
    public void  test(){
        userui.test();
    }
    public  int register (String query){
        return 0;
    }
}
