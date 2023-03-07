package com.example.Casher;

import com.example.Data.Query;
import com.example.functions.Dialogs;
import com.example.functions.Functions;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sun.java.accessibility.util.SwingEventMonitor.addInternalFrameListener;
import static javafx.application.Platform.exit;

public class Collect {
    Dialogs dialog = new Dialogs();
    Functions function = new Functions();
    Query query = new Query();

    public JInternalFrame collect() {
        JInternalFrame classification = new JInternalFrame("Payment", true, true, true, true);


        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
        ///
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
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

        try {

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();

        JMenuItem menuItemDelete = new JMenuItem("Paid");
        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                try {
                    Print print = new Print();
                    JDialog dialog1 = print.print(Integer.parseInt(table.getValueAt(row, 0).toString()));
                    // print.print(Integer.parseInt(table.getValueAt(row, 0).toString()));

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

        ActionListener taskPerformer = evt -> {
            System.out.println("Reading SMTP Info.");
        };
        Timer timer = new Timer(100, taskPerformer);
        timer.setRepeats(false);


        classification.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("starts");
                timer.start();
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                System.out.println("closing");

                //timer.stop();
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("closed");

               timer.stop();
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
               // timer.stop();
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
              //  timer.stop();
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {

            }


        });

        popupMenu.add(menuItemDelete);

        table.setComponentPopupMenu(popupMenu);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);

        p_form.setPreferredSize(new Dimension(0, 0));
        p_table.setPreferredSize(new Dimension(600, 200));

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
