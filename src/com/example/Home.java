package com.example;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import com.example.Drug.Add_drug;

public class Home {
  public void home() {
    Add_drug drug = new Add_drug();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JDesktopPane desktopPane = new JDesktopPane();
    JInternalFrame register = new JInternalFrame("Register user", true, true, true, true);

    register.setBounds(10, 10, 900, 700);
    JLabel label = new JLabel(register.getTitle(), JLabel.CENTER);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    panel.add(label);
    drug.placeComponents(panel2);
    register.add(panel2, BorderLayout.CENTER);
    // register.add(panel, BorderLayout.WEST);

    /////////////////// menu////////////////
    JMenuBar mbar = new JMenuBar();
    JMenu m = new JMenu("File");
    JMenuItem m_new = new JMenuItem("New");
    m_new.addActionListener(new ActionListener() {
      int count = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        count = count + 1;
        if (register.getParent() == null) {
          register.setVisible(true);
          desktopPane.add(register);
        }
      }

    });
    JMenuItem m_print = new JMenuItem("Print");
    JMenuItem m_preference = new JMenuItem("export");
    JMenuItem m_exit = new JMenuItem("exit");
    m.add(m_new);
    m.add(m_print);
    m.add(m_preference);
    m.add(m_exit);
    mbar.add(m);
    /////////////////// end menu///////////////
    register.setVisible(true);
    desktopPane.add(register);
    frame.setJMenuBar(createMenuBar());
    frame.add(desktopPane, BorderLayout.CENTER);
    frame.setSize(1000, 800);
    frame.setVisible(true);

  }

  public static JMenuBar createMenuBar() {

    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rdmi;
    JCheckBoxMenuItem cbmi;

    // Create the menu bar.
    menuBar = new JMenuBar();

    // Build the File Menu.
    menu = new JMenu("File");
    menu.setMnemonic(KeyEvent.VK_F);
    menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
    menuBar.add(menu);

    // a group of JMenuItems
    
   
    ImageIcon icon = new ImageIcon("icon/add.png");
    Image image = icon.getImage(); // transform it
    Image newimg = image.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    icon = new ImageIcon(newimg); // transform it back
    menuItem = new JMenuItem("New Project...",icon);
    menuItem.setMnemonic(KeyEvent.VK_P);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription(
        "New Project");
    menu.add(menuItem);

    menuItem = new JMenuItem("New File...",
        new ImageIcon("images/newfile.png"));
    menuItem.setMnemonic(KeyEvent.VK_F);
    menu.add(menuItem);

    // a group of check box menu items
    menu.addSeparator();
    cbmi = new JCheckBoxMenuItem("A check box menu item");
    cbmi.setMnemonic(KeyEvent.VK_C);
    menu.add(cbmi);

    cbmi = new JCheckBoxMenuItem("Another one");
    cbmi.setMnemonic(KeyEvent.VK_H);
    menu.add(cbmi);

    // a group of radio button menu items
    menu.addSeparator();
    ButtonGroup group = new ButtonGroup();
    rdmi = new JRadioButtonMenuItem("Radio button menu item");
    rdmi.setSelected(true);
    rdmi.setMnemonic(KeyEvent.VK_R);
    group.add(rdmi);
    menu.add(rdmi);

    rdmi = new JRadioButtonMenuItem("Another radio button");
    rdmi.setMnemonic(KeyEvent.VK_O);
    group.add(rdmi);
    menu.add(rdmi);

    // a submenu
    menu.addSeparator();
    submenu = new JMenu("A submenu");
    submenu.setMnemonic(KeyEvent.VK_S);

    menuItem = new JMenuItem("Menu item in the submenu");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_2, ActionEvent.ALT_MASK));
    submenu.add(menuItem);

    menuItem = new JMenuItem("Another menu item");
    submenu.add(menuItem);
    menu.add(submenu);

    // Build Edit menu in the menu bar.
    menu = new JMenu("Edit");
    menu.setMnemonic(KeyEvent.VK_E);
    menu.getAccessibleContext().setAccessibleDescription(
        "Edit Menu");
    menuBar.add(menu);
    return menuBar;

  }
}
