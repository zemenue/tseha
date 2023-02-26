package com.example.Drug;

import com.example.Data.Query;
import com.example.functions.Dialogs;
import com.example.pharmacy.AutoCompleteComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class Add_category {
    Dialogs dialog = new Dialogs();

    public JInternalFrame add_cat() throws SQLException {
        Font font = new Font("SansSerif", Font.BOLD, 14);
        int m = 0;
        int txt_width = 260;
        int txt_height = 27;
        Color background_color = new Color(199, 203, 199);
        Color panel_color = new Color(149, 150, 149);
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
        JInternalFrame category = new JInternalFrame("Category", true, true, true, true);
        category.setLayout(new BorderLayout());
        JPanel p_table = new JPanel();
        p_table.setLayout(new GridLayout(1, 1));
        JPanel p_form = new JPanel();
        p_form.setLayout(null);

        ///////
        JLabel message = new JLabel("Classification");
        message.setBounds(10, 10 + m, 500, 30);
        p_form.add(message);

        ArrayList<String> list = new ArrayList<>();
        Query query = new Query();
        ResultSet resultSet = query.retrieveData("SELECT * FROM classification");
        while (resultSet.next()) {
            list.add(resultSet.getString("class_name"));
        }

        AutoCompleteComboBox Classification = new AutoCompleteComboBox(new Vector<String>(list));
        Classification.setBounds(10, 35 + m, 550, 27);
        Classification.setFont(font);
        p_form.add(Classification);
        ///////

        ///////
        JLabel passwordLabel = new JLabel("Category Name");
        passwordLabel.setBounds(10, 65 + m, 200, 25);
        p_form.add(passwordLabel);

        JTextField cat_name = new JTextField(20);
        cat_name.setBounds(10, 90 + m, txt_width, txt_height);
        cat_name.setFont(font);
        p_form.add(cat_name);
        //////

        //////
        JLabel batch = new JLabel("Category Code");
        batch.setBounds(300, 65 + m, 120, 25);
        p_form.add(batch);
        JTextField cat_code = new JTextField();
        cat_code.setBounds(300, 90 + m, 120, txt_height);
        cat_code.setFont(font);
        p_form.add(cat_code);
        /////
        JButton Save = new JButton("Save");
        Save.setBounds(440, 90 + m, 100, 25);
        Save.setFont(font);
        Save.addActionListener(e -> {
            try {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (Objects.equals(cat_name.getText(), "")) {
                    dialog.error("Please enter Category Name", "Validation Error");
                    return;
                } else if (Objects.equals(cat_code.getText(), "")) {
                    dialog.error("Please enter Category Code", "Validation Error");
                    return;
                } else if (Objects.equals(Classification.getSelectedItem(), "")) {
                    dialog.error("Please enter Classification", "Validation Error");
                    return;
                }
                if (Save.getText().equals("Save")) {
                    query.insert("INSERT INTO inventory.category (catagory_name,cat_code,calss_name)\n" +
                            "VALUES('" + cat_name.getText() + "', '" + cat_code.getText() + "', '" + Classification.getSelectedItem() + "')");
                    dialog.info("Category inserted", "Category");
                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    ResultSet rs = query.retrieveData("SELECT * FROM category ORDER BY catagory_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("catagory_id"),
                                rs.getString("catagory_name"),
                                rs.getString("cat_code"),
                                rs.getString("calss_name")
                        });
                    }
                    Save.setText("Save");
                } else {
                    String q = "UPDATE inventory.category SET catagory_name='" + cat_name.getText() + "'," +
                            "cat_code='" + cat_code.getText() + "'," +
                            "calss_name='" + Classification.getSelectedItem() + "'" +
                            " WHERE catagory_id=" + table.getValueAt(row, 0) + "" ;

                    query.Delete_update(q, "Category updated successfully", "Update", "Can't Update Category", "Error", "Are you sure to update category?");

                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    ResultSet rs = query.retrieveData("SELECT * FROM category ORDER BY catagory_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("catagory_id"),
                                rs.getString("catagory_name"),
                                rs.getString("cat_code"),
                                rs.getString("calss_name")
                        });
                    }
                    Save.setText("Save");
                }


            } catch (Exception err) {
                dialog.error(err.getMessage(), "Error");
            }
        });
        p_form.add(Save);
        /////
        tableModel.addColumn("ID");
        tableModel.addColumn("Category");
        tableModel.addColumn("Category Code");
        tableModel.addColumn("Classification");
        ResultSet rs = query.retrieveData("SELECT * FROM category ORDER BY catagory_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("catagory_id"),
                    rs.getString("catagory_name"),
                    rs.getString("cat_code"),
                    rs.getString("calss_name")
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
                    ResultSet result = query.retrieveData("SELECT * FROM category  WHERE catagory_id='" + table.getValueAt(row, 0) + "' ");
                    while (result.next()) {
                        Classification.setSelectedItem(result.getString("calss_name"));
                        cat_code.setText(result.getString("cat_code"));
                        cat_name.setText(result.getString("catagory_name"));

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

                query.Delete_update("DELETE FROM category  WHERE catagory_id=" + table.getValueAt(row, 0) + "", "Category Deleted."
                        , "Delete", "Can't Delete category.", "Error", "Are you sure to delete category"
                );
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                try {
                    ResultSet rs = query.retrieveData("SELECT * FROM category ORDER BY catagory_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("catagory_id"),
                                rs.getString("catagory_name"),
                                rs.getString("cat_code"),
                                rs.getString("calss_name")
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
        category.setLayout(new FlowLayout());
        category.add(p_form);
        category.add(p_table);
        category.pack();
        category.setBounds(0, 0, 600, 420);
        category.setVisible(true);
        return category;
    }

}
