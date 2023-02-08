package com.example.Drug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class Add_drug {

  public void add_drug() {

  }

  public void placeComponents(JPanel p_container) {
    Font font = new Font("SansSerif", Font.BOLD, 14);
    int m = 0;
    int txt_width = 260;
    int txt_height = 27;
    Color background_color = new Color(199, 203, 199);
    Color panel_color = new Color(149, 150, 149);
    p_container.setLayout(new BorderLayout());
    JPanel p_form = new JPanel();
    JPanel P_table = new JPanel();
    P_table.setLayout(new GridLayout());
    ///////
    JLabel message = new JLabel("Drug Name");
    message.setBounds(10, 10 + m, 500, 30);
    p_form.add(message);
    JTextField drug_name = new JTextField(100);
    drug_name.setBounds(10, 35 + m, 550, 27);
    drug_name.setFont(font);
    p_form.add(drug_name);
    ///////

    ///////
    JLabel passwordLabel = new JLabel("Drug Code");
    passwordLabel.setBounds(10, 65 + m, 200, 25);
    p_form.add(passwordLabel);

    JTextField drug_code = new JTextField(20);
    drug_code.setBounds(10, 90 + m, txt_width, 27);
    drug_code.setFont(font);
    p_form.add(drug_code);
    //////

    //////
    JLabel batch = new JLabel("Batch Number");
    batch.setBounds(300, 65 + m, txt_width, 25);
    p_form.add(batch);
    JTextField batch_n = new JTextField(100);
    batch_n.setBounds(300, 90 + m, txt_width, 27);
    batch_n.setFont(font);
    p_form.add(batch_n);
    /////

    /////
    JLabel manu = new JLabel("Manifacturer");
    manu.setBounds(10, 120 + m, 200, 25);
    p_form.add(manu);

    JTextField manifacturer = new JTextField(20);
    manifacturer.setBounds(10, 145 + m, txt_width, 27);
    manifacturer.setFont(font);
    p_form.add(manifacturer);

    //////
    JLabel manu_d = new JLabel("Manifacturer Date");
    manu_d.setBounds(300, 120 + m, txt_width, 25);
    p_form.add(manu_d);

    JDateChooser dateChooser = new JDateChooser(new Date());
    dateChooser.setDateFormatString("dd/MM/yyyy");
    dateChooser.setFont(font);
    dateChooser.setBounds(300, 145 + m, txt_width, 27);
    p_form.add(dateChooser);
    //////
    JLabel expire_date1 = new JLabel("Expire Date");
    expire_date1.setBounds(10, 175 + m, txt_width, 25);
    p_form.add(expire_date1);

    JDateChooser dateChooser_exp = new JDateChooser(new Date());
    dateChooser_exp.setDateFormatString("dd/MM/yyyy");
    dateChooser_exp.setFont(font);
    dateChooser_exp.setBounds(10, 200 + m, txt_width, 27);
    p_form.add(dateChooser_exp);
    //// -----------------------------------------------------------------///////////////////////////
    JPanel p_form1 = new JPanel();
    ///////
    JLabel message_ = new JLabel("Drug Name");
    message_.setBounds(10, 10 + m, 500, 30);
    p_form1.add(message_);
    JTextField drug_name_ = new JTextField(100);
    drug_name_.setBounds(10, 35 + m, 550, 27);
    drug_name_.setFont(font);
    p_form1.add(drug_name_);
    /////

    /////
    JLabel passwordLabel_ = new JLabel("Drug Code");
    passwordLabel_.setBounds(10, 65 + m, 200, 25);
    p_form1.add(passwordLabel_);

    JTextField drug_code_ = new JTextField(20);
    drug_code_.setBounds(10, 90 + m, txt_width, 27);
    drug_code_.setFont(font);
    p_form1.add(drug_code_);
    /////

    ////
    JLabel batch_ = new JLabel("Batch Number");
    batch_.setBounds(300, 65 + m, txt_width, 25);
    p_form1.add(batch_);
    JTextField batch_n_ = new JTextField(100);
    batch_n_.setBounds(300, 90 + m, txt_width, 27);
    batch_n_.setFont(font);
    p_form1.add(batch_n_);
    /////

    /////
    JLabel manu_ = new JLabel("Manifacturer");
    manu_.setBounds(10, 120 + m, 200, 25);
    p_form1.add(manu_);

    JTextField manifacturer_ = new JTextField(20);
    manifacturer_.setBounds(10, 145 + m, txt_width, 27);
    manifacturer_.setFont(font);
    p_form1.add(manifacturer_);

    //////
    JLabel manu_d_ = new JLabel("Manifacturer Date");
    manu_d_.setBounds(300, 120 + m, txt_width, 25);
    p_form1.add(manu_d_);

    JDateChooser dateChooser_ = new JDateChooser(new Date());
    dateChooser_.setDateFormatString("dd/MM/yyyy");
    dateChooser_.setFont(font);
    dateChooser_.setBounds(300, 145 + m, txt_width, 27);
    p_form1.add(dateChooser_);
    //// -----------------------------------------------------------------///////////////////////////
    JPanel p_form3 = new JPanel();

    //// -----------------------------------------------------------------///////////////////////////
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
    //// -----------------------------------------------------------------///////////////////////////
    TitledBorder border = new TitledBorder("panel");
    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);

    JPanel form_container = new JPanel();
    p_form.setBorder(border);
    p_form1.setBorder(border);
    p_form3.setBorder(border);

    p_form.setBackground(panel_color);
    p_form1.setBackground(panel_color);
    p_form3.setBackground(panel_color);

    p_form.setLayout(null);
    p_form1.setLayout(null);
    p_form3.setLayout(null);

    p_form.setPreferredSize(new Dimension(600, 400));
    p_form1.setPreferredSize(new Dimension(600, 200));
    p_form3.setPreferredSize(new Dimension(600, 200));
    P_table.setPreferredSize(new Dimension(4, 200));

    form_container.setLayout(new FlowLayout());
    form_container.setPreferredSize(new Dimension(1000, 800));

    form_container.add(p_form);
    form_container.add(p_form1);
    form_container.add(p_form3);
    form_container.setBackground(background_color);
    JScrollPane scroll = new JScrollPane(form_container);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    ///////////////////////////////////////////////////////////////////////////
    p_container.add(scroll, BorderLayout.CENTER);
    p_container.add(P_table, BorderLayout.SOUTH);
    p_container.setBackground(background_color);
  }
}
