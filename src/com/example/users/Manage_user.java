package com.example.users;

import com.example.users.ui.Add_user;

import javax.swing.*;

public class Manage_user {
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
