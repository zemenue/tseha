package com.example.Casher;

import com.example.Data.Query;
import com.example.functions.Dialogs;
import com.example.functions.Functions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Collect {
    Dialogs dialog = new Dialogs();
    Functions function = new Functions();
    Query query = new Query();

    public JInternalFrame collect() throws SQLException {
        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
        ///
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);


        //


        JInternalFrame classification = new JInternalFrame("Payment", true, true, true, true);
        classification.setLayout(new BorderLayout());
        JPanel p_table = new JPanel();
        p_table.setLayout(new GridLayout(1, 1));
        JPanel p_form = new JPanel();
        p_form.setLayout(null);

        tableModel.addColumn("ID");
        tableModel.addColumn("Drug name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("unit");
        tableModel.addColumn("Patient name");
        tableModel.addColumn("status");

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        ResultSet rs = query.retrieveData("SELECT * FROM sell  ORDER BY status,sell_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("sell_id"),
                    rs.getString("drug_id"),
                    rs.getString("quantity"),
                    rs.getString("unit"),
                    rs.getString("patient_name"),
                    rs.getString("status")

            });

        }

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();

        JMenuItem menuItemDelete = new JMenuItem("Paid");
        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                Print print=new Print();
                try {
                    print.print(Integer.parseInt(table.getValueAt(row, 0).toString()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                try {


                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    ResultSet rs = query.retrieveData("SELECT * FROM sell  ORDER BY status,sell_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("sell_id"),
                                rs.getString("drug_id"),
                                rs.getString("quantity"),
                                rs.getString("unit"),
                                rs.getString("patient_name"),
                                rs.getString("status")

                        });

                    }
                } catch (SQLException ex) {
                    dialog.error(ex.getMessage(), "Error");
                }

            }
        });

        popupMenu.add(menuItemDelete);

        table.setComponentPopupMenu(popupMenu);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);

        p_form.setPreferredSize(new Dimension(0, 0));
        p_table.setPreferredSize(new Dimension(600, 200));
        p_table.setVisible(true);
        p_form.setVisible(true);
        p_table.add(new JScrollPane(table));
        p_form.setLayout(null);
        classification.setLayout(new FlowLayout());
        classification.add(p_form);
        classification.add(p_table);
        classification.pack();
        classification.setBounds(0, 0, 600, 420);
        classification.setVisible(true);

        return classification;
    }
}
