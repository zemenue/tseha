package com.example.Drug.Casher;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Reciept {
  public void preview_reciept() {
    JFrame frame = new JFrame();

    JPanel container = new JPanel();
    JPanel recieptJPanel = new JPanel();
    recieptJPanel.setLayout(new BorderLayout());
    String[][] data = {
        { "1", "Paracitamol", "25", "25" },
        { "3", "Malatine", "50", "150" },

        { "", "", "Sub Total", "175" },
        { "", "", "Sales Tax", "26.25" },
        { "", "", "Total", "201.25" },
    };
    String[] columnNames = { "QTY ", " DESCRIPTION ", "UNIT PRICE ", "AMOUNT" };

    JTable table = new JTable(data, columnNames);

    recieptJPanel.add(table, BorderLayout.CENTER);
    frame.add(recieptJPanel);
    frame.setSize(500, 800);
    frame.setVisible(true);
  }
}
