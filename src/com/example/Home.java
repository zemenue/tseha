package com.example;

import com.example.Drug.Add_drug;
import com.example.users.Manage_user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Home {
    public int id;
    public String Username;
    Font font = new Font("SansSerif", Font.BOLD, 14);
    JDesktopPane desktopPane = new JDesktopPane();
    JFrame frame = new JFrame();
    JInternalFrame register = new JInternalFrame("Register Drug", true, true, true, true);

    public Home(int id, String username) throws SQLException {
        this.id = id;
        this.Username = username;
        Add_drug drug = new Add_drug();
        frame.setTitle("Drug Store Inventory Managment System - " + Username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        register.setBounds(10, 10, 900, 700);
        JLabel label = new JLabel(register.getTitle(), JLabel.CENTER);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.add(label);
        drug.placeComponents(panel2);
        register.add(panel2, BorderLayout.CENTER);
        // register.add(panel, BorderLayout.WEST);


        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        JLabel footer_text = new JLabel("Server: Connected");
        footer_text.setFont(font);
        footer.add(footer_text, BorderLayout.EAST);

        register.setVisible(true);

        desktopPane.add(register);

        frame.setJMenuBar(createMenuBar());
        frame.add(desktopPane, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.PAGE_END);
        try {
            register.setMaximum(true);
        } catch (PropertyVetoException e1) {

            System.out.println(e1.getMessage());
        }
        frame.setSize(1000, 800);
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public JMenuBar createMenuBar() {

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JMenuItem rdmi;
        // Create the menu bar.
        menuBar = new JMenuBar();
        /////////////////////////////////////////////////////////////////////////////////////////
        // Build the File Menu.
        menu = new JMenu("Drug");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        // a group of JMenuItems

        ImageIcon icon = new ImageIcon("icon/add.png");
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("New Drug.", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menuItem.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                if (register.getParent() == null) {
                    register.setVisible(true);
                    desktopPane.add(register);
                }

            }

        });

        menu.add(menuItem);

        menuItem = new JMenuItem("Add Drug",
                new ImageIcon("images/newfile.png"));
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);

        // a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        JMenuItem  category = new JMenuItem("Classification", icon);

        category.setMnemonic(KeyEvent.VK_R);
        group.add(category);
        menu.add(category);

        rdmi = new JMenuItem("Category");
        rdmi.setMnemonic(KeyEvent.VK_O);
        group.add(rdmi);
        menu.add(rdmi);

        // a submenu
        menu.addSeparator();
        submenu = new JMenu("Null 0");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("Null 1");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Null 2");
        submenu.add(menuItem);
        menu.add(submenu);

        ////////////////////////////////////////////////////////
        menu = new JMenu("Store");

        menuBar.add(menu);

        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("Shelf", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menu.add(menuItem);
        ////////////////////////////////////////////////////////
        menu = new JMenu("Report");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("New Drug.", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menu.add(menuItem);
        ////////////////////////////////////////////////////////
        menu = new JMenu("Settings");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("Server Settings", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menu.add(menuItem);
        // a submenu
        menu.addSeparator();
        submenu = new JMenu("Manage Users");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("Add Users");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage_user user=new Manage_user();
                JInternalFrame internal=user.add_user();
                if (internal.getParent() == null) {
                    internal.setVisible(true);

                    desktopPane.add(internal);
                }
            }
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("Reset Password");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Manage Role");
        submenu.add(menuItem);
        menu.add(submenu);
        ////////////////////////////////////////////////////////
        menu = new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("New Drug.", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menu.add(menuItem);
        ////////////////////////////////////////////////////////
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menu);

        icon = new ImageIcon(newimg); // transform it back
        menuItem = new JMenuItem("New Drug.", icon);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "New Drug");
        menu.add(menuItem);
        //////////////////////////////////////////////////////////////////////
        // Build Edit menu in the menu bar.

        return menuBar;

    }
}
