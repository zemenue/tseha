package com.example.Drug;

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

public class Add_classification {
    Dialogs dialog = new Dialogs();
    Functions function = new Functions();
    Query query = new Query();

    public JInternalFrame addclassification() throws SQLException {
        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
        ///
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
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

        //


        JInternalFrame classification = new JInternalFrame("Classification", true, true, true, true);
        classification.setLayout(new BorderLayout());
        JPanel p_table = new JPanel();
        p_table.setLayout(new GridLayout(1, 1));
        JPanel p_form = new JPanel();
        p_form.setLayout(null);

        ///////
        JLabel message = new JLabel("Classification Name");
        message.setBounds(10, 10 + m, 500, 30);
        p_form.add(message);

        JTextField class_name = new JTextField();
        class_name.setBounds(10, 35 + m, 550, 27);
        class_name.setFont(font);
        p_form.add(class_name);
        ///////

        ///////
        JLabel passwordLabel = new JLabel("Classification Code");
        passwordLabel.setBounds(10, 65 + m, 200, 25);
        p_form.add(passwordLabel);

        JTextField class_code = new JTextField(20);
        class_code.setBounds(10, 90 + m, txt_width, txt_height);
        class_code.setFont(font);
        p_form.add(class_code);
        //////


        /////


        JButton Save = new JButton("Save");
        Save.setBounds(460, 90 + m, 100, 30);
        Save.setFont(font);
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = table.getSelectedRow();
                    if (Save.getText().equals("Save")) {

                        query.insert("INSERT INTO inventory.classification (class_name,class_code)\n" +
                                "VALUES('" + class_name.getText() + "', '" + class_code.getText() + "')");

                        System.out.println("Data inserted.");
                        tableModel.getDataVector().removeAllElements();
                        tableModel.fireTableDataChanged();
                        ResultSet rs = query.retrieveData("SELECT * FROM classification ORDER BY class_id desc");
                        while (rs.next()) {
                            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                    rs.getString("class_id"),
                                    rs.getString("class_name"),
                                    rs.getString("class_code")

                            });

                        }
                        Save.setText("Save");
                    } else {
                        String q = "UPDATE classification SET class_name='" + class_name.getText() + "'," +
                                "class_code='" + class_code.getText() + "'" +
                                " WHERE class_id=" + table.getValueAt(row, 0) + "";

                        query.Delete_update(q, "Category updated successfully", "Update", "Can't Update Category", "Error", "Are you sure to update category?");

                        tableModel.getDataVector().removeAllElements();
                        tableModel.fireTableDataChanged();
                        ResultSet rs = query.retrieveData("SELECT * FROM classification ORDER BY class_id desc");
                        while (rs.next()) {
                            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                    rs.getString("class_id"),
                                    rs.getString("class_name"),
                                    rs.getString("class_code")

                            });

                        }
                        Save.setText("Save");
                    }

                } catch (Exception err) {
                    System.out.println("error:" + err.getMessage());
                }
            }
        });
        p_form.add(Save);
        /////

        tableModel.addColumn("ID");
        tableModel.addColumn("Classification");
        tableModel.addColumn("Classification Code");

        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        ResultSet rs = query.retrieveData("SELECT * FROM classification ORDER BY class_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("class_id"),
                    rs.getString("class_name"),
                    rs.getString("class_code")

            });

        }

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();
        JMenuItem menuItemUpdate = new JMenuItem("Update");
        menuItemUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    ResultSet result = query.retrieveData("SELECT * FROM classification  WHERE class_id='" + table.getValueAt(row, 0) + "' ");
                    while (result.next()) {
                        class_name.setText(result.getString("class_name"));
                        class_code.setText(result.getString("class_code"));
                    }
                    Save.setText("Update");
                } catch (SQLException ex) {
                    dialog.error(ex.getMessage(), "Error");
                }

            }
        });
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                query.Delete_update("DELETE FROM classification  WHERE class_id=" + table.getValueAt(row, 0) + "", "Classification Deleted."
                        , "Delete", "Can't Delete Classification.", "Error", "Are you sure to delete Classification"
                );
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                try {
                    ResultSet rs = query.retrieveData("SELECT * FROM classification ORDER BY class_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("class_id"),
                                rs.getString("class_name"),
                                rs.getString("class_code")

                        });

                    }
                } catch (SQLException ex) {
                    dialog.error(ex.getMessage(), "Error");
                }

            }
        });
        popupMenu.add(menuItemUpdate);
        popupMenu.add(menuItemDelete);

        table.setComponentPopupMenu(popupMenu);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);

        p_form.setPreferredSize(new Dimension(600, 180));
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
