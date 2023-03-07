package com.example.pharmacy;

import com.example.Data.Query;
import com.example.functions.Dialogs;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;

public class Sell {
    public JInternalFrame sell() throws SQLException {
        Dialogs dialogs = new Dialogs();
        Query query = new Query();
        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        NumberFormat longFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0l); //Optional
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Drug Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Dosage");
        tableModel.addColumn("unit");
        tableModel.addColumn("Patient Name");
        tableModel.addColumn("Card NUmber");
        tableModel.addColumn("Address");
        tableModel.addColumn("Sex");
        tableModel.addColumn("Age");
        tableModel.addColumn("Status");


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
        JInternalFrame sell = new JInternalFrame("Drug Sell Form", true, true, true, true);
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

        JFormattedTextField quantity = new JFormattedTextField(numberFormatter);
        quantity.setBounds(10, 90 + m, txt_width, txt_height);
        quantity.setFont(font);
        p_form.add(quantity);
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

        JTextField card = new JTextField();
        card.setBounds(300, 150 + m, txt_width, txt_height);
        card.setFont(font);
        p_form.add(card);
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

        JFormattedTextField age = new JFormattedTextField(numberFormatter);
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
        sellJLabel.setBounds(10, 350 + m, 200, 25);
        p_form.add(sellJLabel);

        JTextArea Description = new JTextArea();
        Description.setAutoscrolls(true);
        Description.setBounds(10, 375 + m, 540, 100);
        Description.setFont(font);
        p_form.add(Description);
        /////

        JButton Save = new JButton("Save");
        Save.setBounds(440, 480 + m, 100, 30);
        Save.setFont(font);

        Date date = new Date();

        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        String today = DateFor.format(new Date());
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                query.insert("INSERT INTO inventory.sell\n" +
                        "( drug_id, quantity, dosage, unit, patient_name, card_number, address, sex, age, health_center, `date`, prescription_att, description)\n" +
                        "VALUES( '" + drug_name.getSelectedItem() + "', " +Double.valueOf(quantity.getText())  + ", '" + dossage.getSelectedItem() + "', '" + unit.getSelectedItem() + "'," +
                        " '" + patient.getText() + "', '" + card.getText() + "', '" + address.getText() + "', '" + sex.getSelectedItem() + "'," +
                        " " + age.getText() + ", '" + health_center.getText() + "', '" + DateFor.format(Date_per.getDate()) + "', '" + _att.getText() + "', '" + Description.getText() + "');\n");

                dialogs.info("Data inserted", "Message");

                try {
                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    ResultSet rs = query.retrieveData("SELECT * FROM sell ORDER BY sell_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("sell_id"),
                                rs.getString("drug_id"),
                                rs.getString("quantity"),
                                rs.getString("dosage"),
                                rs.getString("unit"),
                                rs.getString("patient_name"),
                                rs.getString("card_number"),
                                rs.getString("address"),
                                rs.getString("sex"),
                                rs.getString("age"),
                                rs.getString("status")
                        });

                    }
                } catch (SQLException ex) {
                    dialogs.error("Error:"+ex.getMessage(),"Error");
                }





            }
        });
        p_form.add(Save);
        /////

        /////
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();
        JMenuItem menuItemDelete = new JMenuItem("Cancel Request");
        menuItemDelete.addActionListener(e -> {
            int row = table.getSelectedRow();


            try {
                query.Delete_update("DELETE FROM sell  WHERE sell_id=" + table.getValueAt(row, 0) + " AND status='pending'",
                        "Sell  Canceled."
                        , "cancel", "Can't cancel Sell.",
                        "Error", "Are you sure to cancel Sell?"
                );

                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                ResultSet rs1 = query.retrieveData("SELECT * FROM sell ORDER BY sell_id desc");
                while (rs1.next()) {
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                            rs1.getString("sell_id"),
                            rs1.getString("drug_id"),
                            rs1.getString("quantity"),
                            rs1.getString("dosage"),
                            rs1.getString("unit"),
                            rs1.getString("patient_name"),
                            rs1.getString("card_number"),
                            rs1.getString("address"),
                            rs1.getString("sex"),
                            rs1.getString("age"),
                            rs1.getString("status")

                    });

                }
            } catch (SQLException ex) {
                dialogs.error(ex.getMessage(), "Error");
            }

        });
        popupMenu.add(menuItemDelete);

        table.setComponentPopupMenu(popupMenu);

        ResultSet rs = query.retrieveData("SELECT * FROM sell ORDER BY sell_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("sell_id"),
                    rs.getString("drug_id"),
                    rs.getString("quantity"),
                    rs.getString("dosage"),
                    rs.getString("unit"),
                    rs.getString("patient_name"),
                    rs.getString("card_number"),
                    rs.getString("address"),
                    rs.getString("sex"),
                    rs.getString("age"),
                    rs.getString("status")
            });

        }
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);

        p_form.setPreferredSize(new Dimension(600, 530));
        p_table.setPreferredSize(new Dimension(600, 200));
        p_table.setVisible(true);
        p_form.setVisible(true);
        p_table.add(new JScrollPane(table));
        p_form.setLayout(null);
        sell.setLayout(new FlowLayout());
        sell.add(p_form);
        sell.add(p_table);
        sell.pack();
        sell.setBounds(0, 0, 600, 800);
        sell.setVisible(true);
        return sell;
    }
}
