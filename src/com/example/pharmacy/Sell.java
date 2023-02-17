package com.example.pharmacy;

import com.example.Data.Query;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Sell {
    public JInternalFrame sell() throws SQLException {
        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
        String[] unitlist = new String[]{
                "Kg",
                "g",
                "mg",
                "mcg",
                "L",
                "ml",
                "cc",
                "mol",
                "mmol"
        };
        String[] dosagelist = new String[]{
                "Powder",
                "Tablet",
                "Capsule",
                "Solution",
                "Suspension",
                "Emulsion",
                "Syrup",
                "Elixir",
                "Magma",
                "Gel",
                "Cachet",
                "Pill",
                "Ointment",
                "Cream",
                "Paste",
                "Lotion",
                "Plaster",
                "Suppositorie",
                "Enema",
                "Douche",
                "Spray",
                "Inhalation",
                "Lozenge",
        };
        JInternalFrame sell = new JInternalFrame("Drug Sell Form", false, true, false, false);
        sell.setLayout(new BorderLayout());
        JPanel p_table = new JPanel();
        p_table.setLayout(new GridLayout(1, 1));
        JPanel p_form = new JPanel();
        p_form.setLayout(null);

        ///////
        JLabel message = new JLabel("Drug Name");
        message.setBounds(10, 10 + m, 500, 30);
        p_form.add(message);

        ArrayList<String> list = new ArrayList<>();
        Query query = new Query();
        ResultSet resultSet = query.retrieveData("SELECT * FROM Drug");
        while (resultSet.next()) {
            list.add(resultSet.getString("Drug_name"));
        }

        AutoCompleteComboBox drug_name = new AutoCompleteComboBox(new Vector<String>(list));
        drug_name.setBounds(10, 35 + m, 550, 27);
        drug_name.setFont(font);
        p_form.add(drug_name);
        ///////

        ///////
        JLabel passwordLabel = new JLabel("Quantity");
        passwordLabel.setBounds(10, 65 + m, 200, 25);
        p_form.add(passwordLabel);

        JTextField drug_code = new JTextField(20);
        drug_code.setBounds(10, 90 + m, txt_width, txt_height);
        drug_code.setFont(font);
        p_form.add(drug_code);
        //////

        //////
        JLabel batch = new JLabel("Dosage Form");
        batch.setBounds(300, 65 + m, 120, 25);
        p_form.add(batch);
        JComboBox dossage = new JComboBox(dosagelist);
        dossage.setBounds(300, 90 + m, 120, txt_height);
        dossage.setFont(font);
        p_form.add(dossage);
        /////

        /////
        JLabel manu = new JLabel("Unit");
        manu.setBounds(440, 65 + m, 120, 25);
        p_form.add(manu);

        JComboBox unit = new JComboBox(unitlist);
        unit.setBounds(440, 90 + m, 120, txt_height);
        unit.setFont(font);
        p_form.add(unit);

        /////

        JLabel expire_date1 = new JLabel("Patient Name");
        expire_date1.setBounds(10, 125 + m, txt_width, 25);
        p_form.add(expire_date1);
        JTextField patient = new JTextField();
        patient.setFont(font);
        patient.setBounds(10, 150 + m, txt_width, txt_height);
        p_form.add(patient);

        JLabel Addressl = new JLabel("Card Number ");
        Addressl.setBounds(300, 125 + m, 200, 25);
        p_form.add(Addressl);

        JTextField Address = new JTextField();
        Address.setBounds(300, 150 + m, txt_width, txt_height);
        Address.setFont(font);
        p_form.add(Address);
        /////
        ///
        JLabel origin = new JLabel("Address ");
        origin.setBounds(10, 175 + m, 200, 25);
        p_form.add(origin);

        JTextField address = new JTextField();

        address.setBounds(10, 200 + m, txt_width, txt_height);
        address.setFont(font);
        p_form.add(address);
        /////
        //////
        JLabel sex1 = new JLabel("Sex");
        sex1.setBounds(300, 175 + m, 120, 25);
        p_form.add(sex1);
        JComboBox sex = new JComboBox();
        sex.addItem("Male");
        sex.addItem("Female");
        sex.setBounds(300, 200 + m, 120, txt_height);
        sex.setFont(font);
        p_form.add(sex);
        /////

        /////
        JLabel agl = new JLabel("age");
        agl.setBounds(440, 175 + m, 120, 25);
        p_form.add(agl);

        JTextField age = new JTextField();
        age.setBounds(440, 200 + m, 120, txt_height);
        age.setFont(font);
        p_form.add(age);

        /////
        JLabel invnum = new JLabel(" Health Center ");
        invnum.setBounds(10, 230 + m, 200, 25);
        p_form.add(invnum);

        JTextField health_center = new JTextField(20);
        health_center.setBounds(10, 255 + m, txt_width, txt_height);
        health_center.setFont(font);
        p_form.add(health_center);
        /////
        JLabel invdate = new JLabel("Date ");
        invdate.setBounds(300, 230 + m, 200, 25);
        p_form.add(invdate);

        JDateChooser Date_per = new JDateChooser(new Date());
        Date_per.setDateFormatString("dd/MM/yyyy");
        Date_per.setBounds(300, 255 + m, txt_width, txt_height);
        Date_per.setFont(font);
        p_form.add(Date_per);
        /////
        JLabel invattJLabel = new JLabel("Prescription Attachment");
        invattJLabel.setBounds(10, 290 + m, 200, 25);
        p_form.add(invattJLabel);

        JTextField _att = new JTextField();
        _att.setBounds(10, 315 + m, 163, txt_height);
        _att.setFont(font);
        p_form.add(_att);

        JButton Browse = new JButton("Browse");
        Browse.setBounds(173, 315 + m, 98, txt_height);
        Browse.setFont(font);
        Browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ////////////////// file chooser///////////////////////
                JFileChooser fileopen = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("Scanned Files", "jpg", "jpeg", "Pdf", "Png");
                fileopen.addChoosableFileFilter(filter);

                int ret = fileopen.showDialog(null, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    _att.setText(file.toString());

                }
                if (ret == JFileChooser.CANCEL_OPTION) {

                }
                if (ret == JFileChooser.ERROR) {
                    System.out.println("Error");
                }
                ////////////////////////////////////////////////////////////////

            }
        });
        p_form.add(Browse);
        /////
        /////
        JLabel sellJLabel = new JLabel("Description");
        sellJLabel.setBounds(300, 290 + m, 200, 25);
        p_form.add(sellJLabel);

        JTextArea Description = new JTextArea();
        Description.setAutoscrolls(true);
        Description.setBounds(300, 315 + m, txt_width, 55);
        Description.setFont(font);
        p_form.add(Description);
        /////
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Drug Name");
        tableModel.addColumn("Drug Code");
        tableModel.addColumn("Batch Number");
        tableModel.addColumn("Manufacturer");

        ResultSet rs = query.retrieveData("SELECT * FROM Drug ORDER BY Drug_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("Drug_id"),
                    rs.getString("Drug_name"),
                    rs.getString("Drug_code"),
                    rs.getString("batch_number"),
                    rs.getString("manufacturer")
            });

        }

        p_form.setPreferredSize(new Dimension(500, 600));
        p_table.setPreferredSize(new Dimension(600, 200));
        p_table.add(table);
        p_table.setVisible(true);
        p_form.setVisible(true);
        sell.add(p_form, BorderLayout.NORTH);
        sell.add(p_table, BorderLayout.SOUTH);

        sell.pack();
        sell.setBounds(0, 0, 600, 800);
        sell.setVisible(true);
        return sell;
    }
}
