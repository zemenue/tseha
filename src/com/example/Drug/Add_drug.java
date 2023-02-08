package com.example.Drug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

    JPanel P_table = new JPanel();
    P_table.setLayout(new GridLayout());
    ////////// ----------------------------------------------///////////////////////
    JPanel p_form = new JPanel();
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
    drug_code.setBounds(10, 90 + m, txt_width, txt_height);
    drug_code.setFont(font);
    p_form.add(drug_code);
    //////

    //////
    JLabel batch = new JLabel("Batch Number");
    batch.setBounds(300, 65 + m, txt_width, 25);
    p_form.add(batch);
    JTextField batch_n = new JTextField(100);
    batch_n.setBounds(300, 90 + m, txt_width, txt_height);
    batch_n.setFont(font);
    p_form.add(batch_n);
    /////

    /////
    JLabel manu = new JLabel("Manifacturer");
    manu.setBounds(10, 120 + m, 200, 25);
    p_form.add(manu);

    JTextField manifacturer = new JTextField(20);
    manifacturer.setBounds(10, 145 + m, txt_width, txt_height);
    manifacturer.setFont(font);
    p_form.add(manifacturer);

    //////
    JLabel manu_d = new JLabel("Manifacturer Date");
    manu_d.setBounds(300, 120 + m, txt_width, 25);
    p_form.add(manu_d);

    JDateChooser dateChooser = new JDateChooser(new Date());
    dateChooser.setDateFormatString("dd/MM/yyyy");
    dateChooser.setFont(font);
    dateChooser.setBounds(300, 145 + m, txt_width, txt_height);
    p_form.add(dateChooser);
    //////
    JLabel expire_date1 = new JLabel("Expire Date");
    expire_date1.setBounds(10, 175 + m, txt_width, 25);
    p_form.add(expire_date1);

    JDateChooser dateChooser_exp = new JDateChooser(new Date());
    dateChooser_exp.setDateFormatString("dd/MM/yyyy");
    dateChooser_exp.setFont(font);
    dateChooser_exp.setBounds(10, 200 + m, txt_width, txt_height);
    p_form.add(dateChooser_exp);
    /////
    JLabel origin = new JLabel("Drug Orgion/Country");
    origin.setBounds(300, 175 + m, 200, 25);
    p_form.add(origin);

    JComboBox D_origin = new JComboBox();
    D_origin.addItem("Ethiopia");
    D_origin.setBounds(300, 200 + m, txt_width, txt_height);
    D_origin.setFont(font);
    p_form.add(D_origin);
    /////
    JLabel invnum = new JLabel("Invoice Number");
    invnum.setBounds(10, 230 + m, 200, 25);
    p_form.add(invnum);

    JTextField invoice_num = new JTextField(20);
    invoice_num.setBounds(10, 255 + m, txt_width, txt_height);
    invoice_num.setFont(font);
    p_form.add(invoice_num);
    /////
    JLabel invdate = new JLabel("Invoice Date");
    invdate.setBounds(300, 230 + m, 200, 25);
    p_form.add(invdate);

    JDateChooser invoice_date = new JDateChooser(new Date());
    invoice_date.setDateFormatString("dd/MM/yyyy");
    invoice_date.setBounds(300, 255 + m, txt_width, txt_height);
    invoice_date.setFont(font);
    p_form.add(invoice_date);
    /////
    JLabel invattJLabel = new JLabel("Invoice Attachment");
    invattJLabel.setBounds(10, 290 + m, 200, 25);
    p_form.add(invattJLabel);

    JFileChooser invoice_att = new JFileChooser();
    invoice_att.setBounds(10, 315 + m, txt_width, txt_height);
    invoice_att.setFont(font);
    p_form.add(invoice_att);
    /////
    /////
    JLabel sellJLabel = new JLabel("Sell Price (Birr)");
    sellJLabel.setBounds(300, 290 + m, 200, 25);
    p_form.add(sellJLabel);

    JTextField price = new JTextField(20);
    price.setBounds(300, 315 + m, txt_width, txt_height);
    price.setFont(font);
    p_form.add(price);
    //// -----------------------------------------------------------------///////////////////////////
    JPanel p_form1 = new JPanel();
    JLabel category_JLabel = new JLabel("Category");
    category_JLabel.setBounds(10, 10 + m, 200, 25);
    p_form1.add(category_JLabel);
    JTextField catagory = new JTextField(100);
    catagory.setBounds(10, 35 + m, txt_width, txt_height);
    catagory.setFont(font);
    p_form1.add(catagory);
    ///////

    JLabel seri = new JLabel("Serial Number");
    seri.setBounds(300, 10 + m, txt_width, 25);
    p_form1.add(seri);
    JTextField serial = new JTextField(100);
    serial.setBounds(300, 35 + m, txt_width, txt_height);
    serial.setFont(font);
    p_form1.add(serial);
    ///////
    ///////
    JLabel shelflJLabel = new JLabel("Shelf Number/Name");
    shelflJLabel.setBounds(10, 65 + m, 200, 25);
    p_form1.add(shelflJLabel);

    JTextField shelf_number = new JTextField(20);
    shelf_number.setBounds(10, 90 + m, txt_width, txt_height);
    shelf_number.setFont(font);
    p_form1.add(shelf_number);
    //////

    //////
    JLabel shelfrJLabel = new JLabel("Shelf Row");
    shelfrJLabel.setBounds(300, 65 + m, 120, 25);
    p_form1.add(shelfrJLabel);
    JTextField shelf_row = new JTextField(100);
    shelf_row.setBounds(300, 90 + m, 120, txt_height);
    shelf_row.setFont(font);
    p_form1.add(shelf_row);
    /////

    /////
    JLabel colmnJLabel = new JLabel("Shelf column");
    colmnJLabel.setBounds(440, 65 + m, 120, 25);
    p_form1.add(colmnJLabel);

    JTextField shelf_col = new JTextField(20);
    shelf_col.setBounds(440, 90 + m, 120, txt_height);
    shelf_col.setFont(font);
    p_form1.add(shelf_col);

    //////
    JLabel taglJLabel = new JLabel("Tag Number");
    taglJLabel.setBounds(10, 120 + m, txt_width, 25);
    p_form1.add(taglJLabel);
    JTextField tag_number = new JTextField(20);
    tag_number.setBounds(10, 145 + m, txt_width, txt_height);
    tag_number.setFont(font);
    p_form1.add(tag_number);
    //////
    JLabel numberpackJLabel = new JLabel("Number of Pack");
    numberpackJLabel.setBounds(300, 120 + m, 120, 25);
    p_form1.add(numberpackJLabel);
    JTextField number_of_pack = new JTextField(20);
    number_of_pack.setBounds(300, 145 + m, 120, txt_height);
    number_of_pack.setFont(font);
    p_form1.add(number_of_pack);
    JLabel numberpackJLabelQ = new JLabel("qua. per pack");
    numberpackJLabelQ.setBounds(440, 120 + m, 120, 25);
    p_form1.add(numberpackJLabelQ);
    JTextField quantity_per_pack = new JTextField(20);
    quantity_per_pack.setBounds(440, 145 + m, 120, txt_height);
    quantity_per_pack.setFont(font);
    p_form1.add(quantity_per_pack);
    ////
    JLabel unitJLabel = new JLabel("Drug Unit");
    unitJLabel.setBounds(10, 175 + m, txt_width, 25);
    p_form1.add(unitJLabel);

    JTextField unit = new JTextField(20);
    unit.setBounds(10, 200 + m, txt_width, txt_height);
    unit.setFont(font);
    p_form1.add(unit);

    /////
    JLabel tempJLabel = new JLabel("Temprature(°C)");
    tempJLabel.setBounds(300, 175 + m, 120, 25);
    p_form1.add(tempJLabel);

    JTextField temprature = new JTextField(20);
    temprature.setBounds(300, 200 + m, 120, txt_height);
    temprature.setFont(font);
    p_form1.add(temprature);

    JLabel humiditylJLabel = new JLabel("humidity(%)");
    humiditylJLabel.setBounds(440, 175 + m, 120, 25);
    p_form1.add(humiditylJLabel);

    JTextField humidity = new JTextField(20);
    humidity.setBounds(440, 200 + m, 120, txt_height);
    humidity.setFont(font);
    p_form1.add(humidity);
    // ///// Lumen (Lm)
    JLabel lightJLabel = new JLabel("Light/Illumination(Lm)");
    lightJLabel.setBounds(10, 230 + m, 200, 25);
    p_form1.add(lightJLabel);

    JTextField light = new JTextField(20);
    light.setBounds(10, 255 + m, txt_width, txt_height);
    light.setFont(font);
    p_form1.add(light);
    // /////

    JLabel dossagelJLabel = new JLabel("Dossage");
    dossagelJLabel.setBounds(300, 230 + m, 200, 25);
    p_form1.add(dossagelJLabel);
    JTextField Dossage = new JTextField(100);
    Dossage.setBounds(300, 255 + m, txt_width, txt_height);
    Dossage.setFont(font);
    p_form1.add(Dossage);
    ///////

    JLabel strengthlJLabel = new JLabel("Strength");
    strengthlJLabel.setBounds(10, 290 + m, 200, 25);
    p_form1.add(strengthlJLabel);
    JTextField strength = new JTextField(100);
    strength.setBounds(10, 315 + m, txt_width, txt_height);
    strength.setFont(font);
    p_form1.add(strength);
    ///////

    // /////

    JButton Save = new JButton("Save");
    Save.setBounds(300, 315 + m, 120, txt_height);
    Save.setFont(font);
    p_form1.add(Save);

    JButton Clear = new JButton("Clear");
    Clear.setBounds(440, 315 + m, 120, txt_height);
    Clear.setFont(font);
    p_form1.add(Clear);

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
    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    P_table.add(sp);
    //// -----------------------------------------------------------------///////////////////////////
    TitledBorder border = new TitledBorder(".");
    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);

    TitledBorder border1 = new TitledBorder("Storage");
    border1.setTitleJustification(TitledBorder.CENTER);
    border1.setTitlePosition(TitledBorder.TOP);

    TitledBorder border3 = new TitledBorder("Application");
    border3.setTitleJustification(TitledBorder.CENTER);
    border3.setTitlePosition(TitledBorder.TOP);

    JPanel form_container = new JPanel();
    p_form.setBorder(border);
    p_form1.setBorder(border1);
    p_form3.setBorder(border3);

    p_form.setBackground(panel_color);
    p_form1.setBackground(panel_color);
    p_form3.setBackground(panel_color);

    p_form.setLayout(null);
    p_form1.setLayout(null);
    p_form3.setLayout(null);

    p_form.setPreferredSize(new Dimension(600, 360));
    p_form1.setPreferredSize(new Dimension(600, 360));
    p_form3.setPreferredSize(new Dimension(600, 360));
    P_table.setPreferredSize(new Dimension(4, 200));

    form_container.setLayout(new FlowLayout());
    form_container.setPreferredSize(new Dimension(1000, 800));

    form_container.add(p_form);
    form_container.add(p_form1);
    // form_container.add(p_form3);
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
