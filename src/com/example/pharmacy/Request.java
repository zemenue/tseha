package com.example.pharmacy;

import com.example.Data.Query;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        //////
        JButton Save = new JButton("Request");
        Save.setBounds(440, 140 + m, 120, txt_height);
        Save.setFont(font);
        p_form.add(Save);
        ////////////////

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

        /////
        p_table.add(table);
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

// Implementtion of AutoCompleteComboBox
class AutoCompleteComboBox extends JComboBox {
    public int caretPos = 0;
    public JTextField tfield = null;

    public AutoCompleteComboBox(final Vector<String> countries) {
        super(countries);
        setEditor(new BasicComboBoxEditor());
        setEditable(true);
    }

    public void setSelectedIndex(int index) {
        super.setSelectedIndex(index);
        tfield.setText(getItemAt(index).toString());
        tfield.setSelectionEnd(caretPos + tfield.getText().length());
        tfield.moveCaretPosition(caretPos);
    }

    public void setEditor(ComboBoxEditor editor) {
        super.setEditor(editor);
        if (editor.getEditorComponent() instanceof JTextField) {
            tfield = (JTextField) editor.getEditorComponent();
            tfield.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key))) return;
                    caretPos = tfield.getCaretPosition();
                    String text = "";
                    try {
                        text = tfield.getText(0, caretPos);
                    } catch (javax.swing.text.BadLocationException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < getItemCount(); i++) {
                        String element = (String) getItemAt(i);
                        if (element.startsWith(text)) {
                            setSelectedIndex(i);
                            return;
                        }
                    }
                }
            });
        }
    }
}