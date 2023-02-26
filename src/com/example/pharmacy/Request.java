package com.example.pharmacy;

import com.example.Data.Query;
import com.example.functions.Dialogs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;
public class Request {
    public JInternalFrame request() throws SQLException {
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
        JInternalFrame request = new JInternalFrame("Request Form", false, true, false, false);
        request.setLayout(new BorderLayout());
        JPanel p_table = new JPanel();
        p_table.setLayout(new GridLayout(1, 1));
        JPanel p_form = new JPanel();
        p_form.setLayout(null);
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        Query query = new Query();
        Dialogs dialog = new Dialogs();
        NumberFormat longFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0l); //Optional
        tableModel.addColumn("ID");
        tableModel.addColumn("Drug Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Unit");
        tableModel.addColumn("Dosage");
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

        //////
        JButton Save = new JButton("Save");
        Save.setBounds(440, 140 + m, 120, txt_height);
        Save.setFont(font);
        Save.addActionListener(e -> {
            try {

                query.insert("INSERT INTO inventory.request (Drug_id,quantity,unit,dosage)" +
                        "VALUES(" +
                        "'" + drug_name.getSelectedItem() + "'," +
                        "'" + Double.valueOf(quantity.getText()) + "'," +
                        "'" + unit.getSelectedItem() + "'," +
                        "'" + dossage.getSelectedItem() + "'" +
                        ")");

                dialog.info("Request inserted","request");

                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                ResultSet rs = query.retrieveData("SELECT * FROM request ORDER BY request_id desc");
                while (rs.next()) {
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                            rs.getString("request_id"),
                            rs.getString("Drug_id"),
                            rs.getString("quantity"),
                            rs.getString("unit"),
                            rs.getString("dosage")
                    });

                }
            } catch (SQLException ex) {
                dialog.error(ex.getMessage(), "Error");
            }

        });
        p_form.add(Save);
        ////////////////


        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        ResultSet rs = query.retrieveData("SELECT * FROM request ORDER BY request_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("request_id"),
                    rs.getString("Drug_id"),
                    rs.getString("quantity"),
                    rs.getString("unit"),
                    rs.getString("dosage")
            });

        }

        /////
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();
        JMenuItem menuItemDelete = new JMenuItem("Cancel Request");
        menuItemDelete.addActionListener(e -> {
            int row = table.getSelectedRow();


            try {
                query.Delete_update("DELETE FROM request  WHERE request_id=" + table.getValueAt(row, 0) + "", "Request  Canceled."
                        , "cancel", "Can't cancel request.", "Error", "Are you sure to cancel request?"
                );

                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                ResultSet rs1 = query.retrieveData("SELECT * FROM request ORDER BY request_id desc");
                while (rs1.next()) {
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                            rs1.getString("request_id"),
                            rs1.getString("Drug_id"),
                            rs1.getString("quantity"),
                            rs1.getString("unit"),
                            rs1.getString("dosage")
                    });

                }
            } catch (SQLException ex) {
                dialog.error(ex.getMessage(), "Error");
            }

        });
        popupMenu.add(menuItemDelete);

        table.setComponentPopupMenu(popupMenu);
        p_table.add(new JScrollPane(table) );
        p_form.setPreferredSize(new Dimension(500, 200));
        p_table.setPreferredSize(new Dimension(600, 200));

        p_table.setVisible(true);
        p_form.setVisible(true);
        request.add(p_form, BorderLayout.NORTH);
        request.add(p_table, BorderLayout.WEST);

        request.pack();
        request.setBounds(0, 0, 600, 500);
        request.setVisible(true);
        return request;

    }
}

