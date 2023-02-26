package com.example.Drug;

import com.example.Data.Query;
import com.example.Home;
import com.example.functions.Dialogs;
import com.example.functions.Functions;
import com.mysql.cj.util.StringUtils;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Add_drug {

    public void add_drug() {

    }

    public void placeComponents(JPanel p_container) throws SQLException {

        String[] countries = new String[]
                {"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
                        "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
                        "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
                        "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
                        "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia",
                        "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
                        "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
                        "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)",
                        "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor",
                        "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                        "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan",
                        "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany",
                        "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea",
                        "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras",
                        "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland",
                        "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
                        "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan",
                        "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
                        "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
                        "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                        "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia",
                        "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands",
                        "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
                        "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama",
                        "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar",
                        "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
                        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal",
                        "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands",
                        "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena",
                        "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden",
                        "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan",
                        "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia",
                        "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
                        "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu",
                        "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands",
                        "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};
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
        String[] primarypacklist = new String[]{
                "vial",
                "Bottle",
                "sachet",
                "Syringe",
                "Ampoule"
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
        JButton Save = new JButton("Save");
        String selected_id;
        Functions function = new Functions();
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
        Dialogs dialog = new Dialogs();
        p_container.setLayout(new BorderLayout());
        JPanel P_table = new JPanel();
        P_table.setLayout(new GridLayout());
        ////////////////////////////// table//////////////////////////////////////
        Query query = new Query();
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Drug Name");
        tableModel.addColumn("Drug Code");
        tableModel.addColumn("Batch Number");
        tableModel.addColumn("Expire Date");
        tableModel.addColumn("Category");
        tableModel.addColumn("Shelf");
        tableModel.addColumn("Shelf Row");
        tableModel.addColumn("Shelf Column");
        tableModel.addColumn("Number of Pack");
        ResultSet rs = query.retrieveData("SELECT * FROM Drug ORDER BY Drug_id desc");
        while (rs.next()) {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                    rs.getString("Drug_id"),
                    rs.getString("Drug_name"),
                    rs.getString("Drug_code"),
                    rs.getString("batch_number"),
                    rs.getString("expire_date"),
                    rs.getString("catagory_id"),
                    rs.getString("shelf"),
                    rs.getString("shelf_row"),
                    rs.getString("shelf_colmn"),
                    rs.getString("num_pack")
            });

        }


        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // finalPopupMenu.setEnabled(true);
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();

            }
        });

//
        JScrollPane sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        P_table.add(sp);
        //// -----------------------------------------------------------------///////////////////////////


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
        JTextField batch_n = new JTextField();
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

        JDateChooser manuf_date = new JDateChooser(new Date());
        manuf_date.setDateFormatString("dd/MM/yyyy");
        manuf_date.setFont(font);
        manuf_date.setBounds(300, 145 + m, txt_width, txt_height);
        p_form.add(manuf_date);
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
        for (String counry : countries) {
            D_origin.addItem(counry);
        }

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

        JTextField invoice_att = new JTextField();
        invoice_att.setBounds(10, 315 + m, 163, txt_height);
        invoice_att.setFont(font);
        p_form.add(invoice_att);

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
                    invoice_att.setText(file.toString());

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
        JLabel sellJLabel = new JLabel("Sell Price (Birr)");
        sellJLabel.setBounds(300, 290 + m, 200, 25);
        p_form.add(sellJLabel);

        JFormattedTextField price = new JFormattedTextField(numberFormatter);
        price.setBounds(300, 315 + m, txt_width, txt_height);
        price.setFont(font);
        p_form.add(price);
        //// -----------------------------------------------------------------///////////////////////////
        JPanel p_form1 = new JPanel();
        JLabel category_JLabel = new JLabel("Category");
        category_JLabel.setBounds(10, 10 + m, 200, 25);
        p_form1.add(category_JLabel);
        ArrayList<String> list = new ArrayList<>();

        ResultSet resultSet = query.retrieveData("SELECT * FROM category");
        while (resultSet.next()) {
            list.add(resultSet.getString("catagory_name"));
        }
        JComboBox catagory = new JComboBox(new Vector<String>(list));

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
        JFormattedTextField shelf_row = new JFormattedTextField(numberFormatter);
        shelf_row.setBounds(300, 90 + m, 120, txt_height);
        shelf_row.setFont(font);
        p_form1.add(shelf_row);
        /////

        /////
        JLabel colmnJLabel = new JLabel("Shelf column");
        colmnJLabel.setBounds(440, 65 + m, 120, 25);
        p_form1.add(colmnJLabel);

        JFormattedTextField shelf_col = new JFormattedTextField(numberFormatter);
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
        JFormattedTextField number_of_pack = new JFormattedTextField(numberFormatter);
        number_of_pack.setBounds(300, 145 + m, 120, txt_height);
        number_of_pack.setFont(font);
        p_form1.add(number_of_pack);
        JLabel numberpackJLabelQ = new JLabel("qua. per pack");
        numberpackJLabelQ.setBounds(440, 120 + m, 120, 25);
        p_form1.add(numberpackJLabelQ);
        JFormattedTextField quantity_per_pack = new JFormattedTextField(numberFormatter);
        quantity_per_pack.setBounds(440, 145 + m, 120, txt_height);
        quantity_per_pack.setFont(font);
        p_form1.add(quantity_per_pack);
        ////
        JLabel ppackJLabel = new JLabel("Primary pack.");
        ppackJLabel.setBounds(10, 175 + m, 120, 25);
        p_form1.add(ppackJLabel);
        Arrays.sort(primarypacklist);
        JComboBox primary_pack = new JComboBox();
        for (String p_pack : primarypacklist) {
            primary_pack.addItem(p_pack);
        }

        primary_pack.setBounds(10, 200 + m, 120, txt_height);
        primary_pack.setFont(font);
        p_form1.add(primary_pack);

        JLabel unitJLabel = new JLabel("Drug Unit");
        unitJLabel.setBounds(150, 175 + m, 120, 25);
        p_form1.add(unitJLabel);

        JComboBox unit = new JComboBox();
        for (String unitlst : unitlist) {
            unit.addItem(unitlst);
        }

        unit.setBounds(150, 200 + m, 120, txt_height);
        unit.setFont(font);
        p_form1.add(unit);

        /////
        JLabel tempJLabel = new JLabel("Temprature(°C)");
        tempJLabel.setBounds(300, 175 + m, 120, 25);
        p_form1.add(tempJLabel);

        JFormattedTextField temprature = new JFormattedTextField(numberFormatter);
        temprature.setBounds(300, 200 + m, 120, txt_height);
        temprature.setFont(font);
        p_form1.add(temprature);

        JLabel humiditylJLabel = new JLabel("humidity(%)");
        humiditylJLabel.setBounds(440, 175 + m, 120, 25);
        p_form1.add(humiditylJLabel);

        JFormattedTextField humidity = new JFormattedTextField(numberFormatter);
        humidity.setBounds(440, 200 + m, 120, txt_height);
        humidity.setFont(font);
        p_form1.add(humidity);
        // ///// Lumen (Lm)
        JLabel lightJLabel = new JLabel("Light/Illumination(Lm)");
        lightJLabel.setBounds(10, 230 + m, 200, 25);
        p_form1.add(lightJLabel);

        JFormattedTextField light = new JFormattedTextField(numberFormatter);
        light.setBounds(10, 255 + m, txt_width, txt_height);
        light.setFont(font);
        p_form1.add(light);
        // /////

        JLabel dossagelJLabel = new JLabel("Dossage Form");
        dossagelJLabel.setBounds(300, 230 + m, 200, 25);
        p_form1.add(dossagelJLabel);
        JComboBox Dossage = new JComboBox();
        Arrays.sort(dosagelist);
        for (String dosg : dosagelist) {
            Dossage.addItem(dosg);
        }

        Dossage.setBounds(300, 255 + m, txt_width, txt_height);
        Dossage.setFont(font);
        p_form1.add(Dossage);
        ///////

        JLabel strengthlJLabel = new JLabel("Strength");
        strengthlJLabel.setBounds(10, 290 + m, 200, 25);
        p_form1.add(strengthlJLabel);
        JComboBox strength = new JComboBox();
        strength.addItem("mg");
        strength.addItem("ml");
        strength.setBounds(10, 315 + m, txt_width, txt_height);
        strength.setFont(font);
        p_form1.add(strength);
        ///////
        class inner {
            void clr() {
                drug_name.setText(null);
                drug_code.setText(null);
                batch_n.setText(null);
                manifacturer.setText(null);
                invoice_num.setText(null);
                invoice_att.setText(null);
                price.setText(null);
                serial.setText(null);
                shelf_number.setText(null);
                shelf_row.setText(null);
                shelf_col.setText(null);
                tag_number.setText(null);
                number_of_pack.setText(null);
                quantity_per_pack.setText(null);
                //primary_pack.setText(null);
                // unit.setText(null);
                temprature.setText(null);
                humidity.setText(null);
                light.setText("");
                // Dossage.setText(null);
            }
        }
        // /////


        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                date = manuf_date.getDate();
                SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
                String today = DateFor.format(new Date());
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();

                if (Objects.equals(drug_name.getText(), "")) {
                    dialog.error("Please enter Drug Name", "Validation Error");
                    return;
                } else if (Objects.equals(drug_code.getText(), "")) {
                    dialog.error("Please enter Drug Code", "Validation Error");
                    return;
                } else if (Objects.equals(batch_n.getText(), "")) {
                    dialog.error("Please enter Batch number", "Validation Error");
                    return;
                } else if (Objects.equals(manifacturer.getText(), "")) {
                    dialog.error("Please enter Drug Manufacturer", "Validation Error");
                    return;
                } else if (Objects.equals(manuf_date.getDate(), "")) {
                    dialog.error("Please enter Manufactured Date", "Validation Error");
                    return;
                } else if (DateFor.format(manuf_date.getDate()).compareTo(today) > 0) {
                    dialog.error("Please Enter Valid Manufacture date", "Validation Error");
                    return;
                } else if (Objects.equals(dateChooser_exp.getDate(), "")) {
                    dialog.error("Please enter Expire Date", "Validation Error");
                    return;
                } else if (DateFor.format(dateChooser_exp.getDate()).compareTo(DateFor.format(manuf_date.getDate())) <= 0) {
                    dialog.error("Please Enter Valid Expire date", "Validation Error");
                    return;
                } else if (Objects.equals(D_origin.getSelectedItem(), "")) {
                    dialog.error("Please enter Drug Name", "Validation Error");
                    return;
                } else if (Objects.equals(invoice_num.getText(), "")) {
                    dialog.error("Please enter Invoice Number", "Validation Error");
                    return;
                } else if (Objects.equals(invoice_date.getDate(), "")) {
                    dialog.error("Please enter Invoice Date", "Validation Error");
                    return;
                } else if (DateFor.format(invoice_date.getDate()).compareTo(DateFor.format(manuf_date.getDate())) < 0) {
                    dialog.error("Please Enter Valid Invoice date", "Validation Error");
                    return;
                } else if (Objects.equals(invoice_att.getText(), "")) {
                    dialog.error("Please Attach invoice", "Validation Error");
                    return;
                } else if (Objects.equals(price.getText(), "")) {
                    dialog.error("Please enter Drug Name", "Validation Error");
                    return;
                } else if (Objects.equals(catagory.getSelectedItem(), "")) {
                    dialog.error("Please enter Category", "Validation Error");
                    return;
                } else if (Objects.equals(serial.getText(), "")) {
                    dialog.error("Please enter Serial Number", "Validation Error");
                    return;
                } else if (Objects.equals(shelf_number.getText(), "")) {
                    dialog.error("Please enter Shelf Number", "Validation Error");
                    return;
                } else if (Objects.equals(shelf_row.getText(), "")) {
                    dialog.error("Please enter Shelf Row", "Validation Error");
                    return;
                } else if (Objects.equals(shelf_col.getText(), "")) {
                    dialog.error("Please enter Shelf Column", "Validation Error");
                    return;
                } else if (Objects.equals(tag_number.getText(), "")) {
                    dialog.error("Please enter Tag Number", "Validation Error");
                    return;
                } else if (Objects.equals(number_of_pack.getText(), "")) {
                    dialog.error("Please enter Number of Pack", "Validation Error");
                    return;
                } else if (Objects.equals(quantity_per_pack.getText(), "")) {
                    dialog.error("Please enter Quantity Per Pack", "Validation Error");
                    return;
                } else if (Objects.equals(primary_pack.getSelectedItem(), "")) {
                    dialog.error("Please enter Primary Pack ", "Validation Error");
                    return;
                } else if (Objects.equals(unit.getSelectedItem(), "")) {
                    dialog.error("Please enter Unit", "Validation Error");
                    return;
                } else if (Objects.equals(temprature.getText(), "")) {
                    dialog.error("Please enter Temperature", "Validation Error");
                    return;
                } else if (Objects.equals(humidity.getText(), "")) {
                    dialog.error("Please enter Humidity", "Validation Error");
                    return;
                } else if (Objects.equals(light.getText(), "")) {
                    dialog.error("Please enter Light/Illumination", "Validation Error");
                    return;
                } else if (Objects.equals(Dossage.getSelectedItem(), "")) {
                    dialog.error("Please enter Dosage Form", "Validation Error");
                    return;
                } else if (Objects.equals(drug_name.getText(), "")) {
                    dialog.error("Please enter Drug Name", "Validation Error");
                    return;
                }


                try {


                    Query query = new Query();
                    if (Save.getText().equals("Save")) {
                        function.copyFile(new File(invoice_att.getText()),
                                new File(function.random_string() + "." + function.getExtension(invoice_att.getText())));

                        query.insert("INSERT INTO inventory.Drug\n" +
                                "(Drug_name, Drug_code, batch_number, manufacturer, manufacture_date, expire_date, origin, invoice_number," +
                                " invoice_date, invoice_attachment, single_price, catagory_id, serial_number, shelf, shelf_row, shelf_colmn, " +
                                "tag, num_pack, qua_per_pack, primary_pack, unit, temp, humudity, light, Dossage_form)\n" +
                                "VALUES('" + drug_name.getText() + "', '" + drug_code.getText() + "', '" + batch_n.getText() + "', '" + manifacturer.getText() + "'," +
                                " '" + DateFor.format(manuf_date.getDate()) + "', '" + DateFor.format(dateChooser_exp.getDate()) + "', '" + D_origin.getSelectedItem() + "', " +
                                "'" + invoice_num.getText() + "', '" + DateFor.format(invoice_date.getDate()) + "', '" + "files/" + function.random_string() + "." + function.getExtension(invoice_att.getText()) + "', " + price.getText() + ", " +
                                "'" + catagory.getSelectedItem() + "', '" + serial.getText() + "', '" + shelf_number.getText() + "', " + shelf_row.getText() + "," +
                                " " + shelf_col.getText() + ", '" + tag_number.getText() + "', " + number_of_pack.getText() + ", " + quantity_per_pack.getText() + "," +
                                " '" + primary_pack.getSelectedItem() + "', '" + unit.getSelectedItem() + "', " + temprature.getText() + ", " + humidity.getText() + "," +
                                " " + light.getText() + ", '" + Dossage.getSelectedItem() + "');\n");

                        dialog.info("Drug Successfully Saved.", "Add drug");
                        inner in = new inner();
                        in.clr();
                    } else {
                        String path = "";
                        String s = invoice_att.getText();
                        String upToNCharacters = s.substring(0, Math.min(s.length(), 5));
                        if (upToNCharacters.equals("files")) {
                            path = "";
                        } else {
                            function.copyFile(new File(invoice_att.getText()),
                                    new File(function.random_string() + "." + function.getExtension(invoice_att.getText())));
                            path = "files/";
                        }
                        String sql = "UPDATE inventory.Drug\n" +
                                "SET Drug_name='" + drug_name.getText() + "', Drug_code='" + drug_code.getText() + "', batch_number='" + batch_n.getText() + "'," +
                                " manufacturer='" + manifacturer.getText() + "', manufacture_date='" + DateFor.format(manuf_date.getDate()) + "', expire_date='" + DateFor.format(dateChooser_exp.getDate()) + "', " +
                                "origin='" + D_origin.getSelectedItem() + "', invoice_number='" + invoice_num.getText() + "', invoice_date='" + DateFor.format(invoice_date.getDate()) + "', " +
                                "invoice_attachment='" + function.random_string() + "." + path + function.getExtension(invoice_att.getText()) + "', single_price=" + price.getText() + ", catagory_id='" + catagory.getSelectedItem() + "', " +
                                "serial_number='" + serial.getText() + "', shelf='" + shelf_number.getText() + "', shelf_row=" + shelf_row.getText() + "," +
                                " shelf_colmn=" + shelf_col.getText() + ", tag='" + tag_number.getText() + "', num_pack=" + number_of_pack.getText() + ", qua_per_pack=" + quantity_per_pack.getText() + "," +
                                " primary_pack='" + primary_pack.getSelectedItem() + "', unit='" + unit.getSelectedItem() + "', temp=" + temprature.getText() + ", humudity=" + humidity.getText() + ", " +
                                "light=" + light.getText() + ", Dossage_form='" + Dossage.getSelectedItem() + "', status='active'" +
                                "WHERE drug_id=" + table.getValueAt(row, 0) + ";";
                        query.Delete_update(sql, "Data updated successfully.", "update", "can't update", "Error", "Do you want to update?");


                        inner in = new inner();
                        in.clr();
                    }


                    tableModel.getDataVector().removeAllElements();
                    tableModel.fireTableDataChanged();
                    ResultSet rs = query.retrieveData("SELECT * FROM Drug ORDER BY Drug_id desc");
                    while (rs.next()) {
                        tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                                rs.getString("Drug_id"),
                                rs.getString("Drug_name"),
                                rs.getString("Drug_code"),
                                rs.getString("batch_number"),
                                rs.getString("expire_date"),
                                rs.getString("catagory_id"),
                                rs.getString("shelf"),
                                rs.getString("shelf_row"),
                                rs.getString("shelf_colmn"),
                                rs.getString("num_pack")
                        });

                    }
                } catch (Exception err) {
                    dialog.error("error:" + err.getMessage(), "Error");
                }

            }
        });
        Save.setBounds(300, 315 + m, 120, txt_height);
        Save.setFont(font);
        p_form1.add(Save);

        JButton Clear = new JButton("Clear");
        Clear.setBounds(440, 315 + m, 120, txt_height);
        Clear.setFont(font);
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inner in = new inner();
                in.clr();
                Save.setText("Save");


            }
        });

        p_form1.add(Clear);

///////////////////////////////////
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();
        JMenuItem menuItemUpdate = new JMenuItem("Update");
        menuItemUpdate.addActionListener(e -> {
            Save.setText("Update");
            try {
                Date date = new Date();
                SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");

                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                ResultSet result = query.retrieveData("SELECT * FROM Drug WHERE drug_id='" + table.getValueAt(row, 0) + "' ");
                while (result.next()) {
                    drug_name.setText(result.getString("Drug_name"));
                    drug_code.setText(result.getString("Drug_code"));
                    batch_n.setText(result.getString("batch_number"));
                    manifacturer.setText(result.getString("manufacturer"));

                    // Date manu_date = new SimpleDateFormat("dd/MM/yyyy").parse(DateFor.format(result.getString("manufacture_date")));

                    // manuf_date.setDate(manu_date);
                    // Date manu_date_exp = new SimpleDateFormat("dd/MM/yyyy").parse(DateFor.format(result.getString("expire_date")));
                    //  dateChooser_exp.setDate(manu_date_exp);
                    D_origin.setSelectedItem(result.getString("origin"));
                    invoice_num.setText(result.getString("invoice_number"));
                    //Date invdatee = new SimpleDateFormat("dd/MM/yyyy").parse(DateFor.format(result.getString("invoice_date")));
                    // invoice_date.setDate(invdatee);
                    invoice_att.setText("files/" + result.getString("invoice_attachment"));
                    price.setText(result.getString("single_price"));
                    catagory.setSelectedItem(result.getString("catagory_id"));
                    //dialog.info(result.getString("catagory_id"),"");

                    serial.setText(result.getString("serial_number"));
                    shelf_number.setText(result.getString("shelf"));
                    shelf_row.setValue(Integer.parseInt(result.getString("shelf_row")));
                    shelf_col.setValue(Integer.parseInt(result.getString("shelf_colmn")));
                    tag_number.setText(result.getString("tag"));
                    number_of_pack.setValue(Double.valueOf(result.getString("num_pack")));
                    quantity_per_pack.setValue(Double.valueOf(result.getString("qua_per_pack")));
                    primary_pack.setSelectedItem(result.getString("primary_pack"));
                    unit.setSelectedItem(result.getString("unit"));
                    temprature.setValue(Double.valueOf(result.getString("temp")));
                    humidity.setValue(Double.valueOf(result.getString("humudity")));
                    light.setValue(Double.valueOf(result.getString("light")));//
                    Dossage.setSelectedItem(result.getString("Dossage_form"));
                }

            } catch (SQLException ex) {
                dialog.error("Error:" + ex.getMessage(), "Error");
            }

        });
        JMenuItem menuItemDelete = new JMenuItem("Delete");
        menuItemDelete.addActionListener(e -> {
            try {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                System.out.println();
                query.Delete_update("DELETE  FROM Drug WHERE drug_id='" + table.getValueAt(row, 0) + "'", "Drug Deleted successfully.",
                        "Message", "Drug Can not Delete.", "Error", "Are you sure to delete permanently?"
                );
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();
                ResultSet resultS = query.retrieveData("SELECT * FROM Drug ORDER BY Drug_id desc");
                while (resultS.next()) {
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                            resultS.getString("Drug_id"),
                            resultS.getString("Drug_name"),
                            resultS.getString("Drug_code"),
                            resultS.getString("batch_number"),
                            resultS.getString("expire_date"),
                            resultS.getString("catagory_id"),
                            resultS.getString("shelf"),
                            resultS.getString("shelf_row"),
                            resultS.getString("shelf_colmn"),
                            resultS.getString("num_pack")
                    });

                }
            } catch (Exception ex) {
                dialog.error("Error: " + ex.getMessage(), "Error");
            }
        });
        JMenuItem menuItemDispose = new JMenuItem("Dispose");
        menuItemDispose.addActionListener(e -> {
            try {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                String q = "UPDATE inventory.Drug  SET status='disposed' WHERE drug_id='" + table.getValueAt(row, 0) + "';";
                query.Delete_update(q, "Drug Disposed successfully.",
                        "Message", "Drug Can not Dispose.", "Error", "Are you sure to Dispose?"
                );
                tableModel.getDataVector().removeAllElements();
                tableModel.fireTableDataChanged();


                ResultSet resultSe = query.retrieveData("SELECT * FROM Drug ORDER BY Drug_id desc");
                while (resultSe.next()) {
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                            resultSe.getString("Drug_id"),
                            resultSe.getString("Drug_name"),
                            resultSe.getString("Drug_code"),
                            resultSe.getString("batch_number"),
                            resultSe.getString("expire_date"),
                            resultSe.getString("catagory_id"),
                            resultSe.getString("shelf"),
                            resultSe.getString("shelf_row"),
                            resultSe.getString("shelf_colmn"),
                            resultSe.getString("num_pack")


                    });

                }
            } catch (Exception ex) {
                dialog.error("Error: " + ex.getMessage(), "Error");
            }
        });
        JMenuItem menuItemDetail = new JMenuItem("Detail");
        menuItemDetail.addActionListener(e -> {

            int row = table.getSelectedRow();
            Detail detail=new Detail();
            detail.detail( Integer.parseInt (table.getValueAt(row, 0).toString()));

          // detail.detail((Integer) table.getValueAt(row, 0));
            //function.frame_dialog(detail.detail((Integer) table.getValueAt(row, 0)), 500,500);


        });

        popupMenu.add(menuItemUpdate);
        popupMenu.add(menuItemDelete);
        popupMenu.add(menuItemDispose);
        popupMenu.add(menuItemDetail);


        table.setComponentPopupMenu(popupMenu);
        /////////////////////////////////////////
        //// -----------------------------------------------------------------///////////////////////////
        JPanel p_form3 = new JPanel();
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

        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDefaultEditor(Object.class, null);

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
