package com.example.Drug;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Add_drug {

  public void add_drug() {

  }

  public void placeComponents(JPanel p_container) {
    Font font = new Font("SansSerif", Font.BOLD, 14);
    int m = 0;
    int txt_width = 260;
    int txt_height = 27;
    p_container.setLayout(new BorderLayout());
    JPanel p_form = new JPanel();
    p_form.setLayout(null);
    // p_form.setBackground(Color.BLACK);
    JPanel P_table = new JPanel();
    P_table.setLayout(new GridLayout());
    ///////////////// ----------------/////////////
    JLabel message = new JLabel("Drug Name");
    message.setBounds(10, 10 + m, 500, 30);
    p_form.add(message);
    JTextField drug_name = new JTextField(100);
    drug_name.setBounds(10, 35 + m, 550, 27);
    drug_name.setFont(font);
    p_form.add(drug_name);
    ///////////////// --------------/////////////

    /////////////// ---------------//////////////
    JLabel passwordLabel = new JLabel("Drug Code");
    passwordLabel.setBounds(600, 10 + m, 80, 25);
    p_form.add(passwordLabel);

    JTextField drug_code = new JTextField(20);
    drug_code.setBounds(600, 35 + m, txt_width, 27);
    drug_code.setFont(font);
    p_form.add(drug_code);
    ////////////// ------------//////////////
    ///////////////////////////////////////////// 1///////////////////////////////////////////////

    ///////////////// ----------------/////////////
    JLabel batch = new JLabel("Batch Number");
    batch.setBounds(10, 65 + m, 200, 25);
    p_form.add(batch);
    JTextField batch_n = new JTextField(100);
    batch_n.setBounds(10, 90 + m, txt_width, 27);
    batch_n.setFont(font);
    p_form.add(batch_n);
    ///////////////// --------------/////////////

    /////////////// ---------------//////////////
    JLabel manu = new JLabel("Manifacturer");
    manu.setBounds(300, 65 + m, txt_width, 25);
    p_form.add(manu);

    JTextField manifacturer = new JTextField(20);
    manifacturer.setBounds(300, 90 + m, txt_width, 27);
    manifacturer.setFont(font);
    p_form.add(manifacturer);

    ///////////////// ---------------////////////
    JLabel manu_d = new JLabel("Manifacturer Date");
    manu_d.setBounds(600, 65 + m, txt_width, 25);
    p_form.add(manu_d);

    JDateChooser dateChooser = new JDateChooser(new Date());
    dateChooser.setDateFormatString("dd/MM/yyyy");
    dateChooser.setFont(font);
    dateChooser.setBounds(600, 90 + m, txt_width, 27);
    p_form.add(dateChooser);
    ////////////////////////////// table//////////////////////////////////////
    String[][] data = {
        { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },
        { "Paracitamole", "P001", "25,8,2023" }, { "Panadol", "P002", "25,8,2024" },

    };
    String[] columnNames = { "Drug Name ", "Drug Code ", "Expire Date " };
    JTable table = new JTable(data, columnNames);
    JScrollPane sp = new JScrollPane(table);
    P_table.add(sp);
    ///////////////////////////////////////////////////////////////////////////
    p_container.add(p_form, BorderLayout.CENTER);
    p_container.add(P_table, BorderLayout.SOUTH);
  }
}
