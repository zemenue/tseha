package com.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
    frame.setJMenuBar(mbar);
    frame.add(desktopPane, BorderLayout.CENTER);
    frame.setSize(1000, 800);
    frame.setVisible(true);

  }

}
