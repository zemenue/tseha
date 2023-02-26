package com.example.Drug;

import com.example.Data.Query;
import com.example.functions.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detail {
    StringBuilder txt;
    Query query = new Query();
    Dialogs dialog = new Dialogs();

    public JDialog detail(Integer id) {

        String HTMLTEXT = "";
        JTextPane textPane1 = new JTextPane();

        textPane1.setContentType("text/html");

        txt = new StringBuilder();
        txt.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<style>\n" +
                "#invoice { border: 2px solid black ;" +

                "border-spacing: 0px;\n" +
                "border-color: gray;}\n" +
                "#invoice td { border: thin solid black }" +
                "ul {\n" +
                "  list-style-type: none;\n" +
                "}" +
                "strong{" +
                "text-decoration: underline;" +
                "}"+
                "</style>" +

                "<table style=\"height: 54px;\" border=\"0\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td style=\"width: 230.5px; text-align: left;\">\n" +
                "<h1><strong>Drug detail</strong></h1>\n"
                +

                "</td>\n" +

                "</tr>\n" +

                "</tr>\n" +
                "</tbody>\n" +
                "</table>" +
                "</br>" +
                "<p></p>" +
                "<ul >");
        try {
            ResultSet rs = query.retrieveData("SELECT * FROM Drug WHERE drug_id='" + id + "';");
            while (rs.next()) {
                txt.append("<li><strong>Drug Name: </strong> " + rs.getString("Drug_name") + "</li>\n");
                txt.append("<li><strong>Drug Code: </strong> " + rs.getString("Drug_code") + "</li>\n");
                txt.append("<li><strong>Batch Number: </strong> " + rs.getString("batch_number") + "</li>\n");
                txt.append("<li><strong>Manufacturer: </strong> " + rs.getString("manufacturer") + "</li>\n");
                txt.append("<li><strong>Manufactured Date: </strong> " + rs.getString("manufacture_date") + "</li>\n");
                txt.append("<li><strong>Expire Date: </strong> " + rs.getString("expire_date") + "</li>\n");
                txt.append("<li><strong>Country of Origin: </strong> " + rs.getString("origin") + "</li>\n");
                txt.append("<li><strong>Invoice Number: </strong> " + rs.getString("invoice_number") + "</li>\n");
                txt.append("<li><strong>Invoice Date: </strong> " + rs.getString("invoice_date") + "</li>\n");
                txt.append("<li><strong>Single Price: </strong> " + rs.getString("single_price") + "</li>\n");
                txt.append("<li><strong>Category: </strong> " + rs.getString("catagory_id") + "</li>\n");
                txt.append("<li><strong>Serial Number: </strong> " + rs.getString("serial_number") + "</li>\n");
                txt.append("<li><strong>Shelf: </strong> " + rs.getString("shelf") + "</li>\n");
                txt.append("<li><strong>Shelf Row: </strong> " + rs.getString("shelf_row") + "</li>\n");
                txt.append("<li><strong>Shelf Column: </strong> " + rs.getString("shelf_colmn") + "</li>\n");
                txt.append("<li><strong>Tag Number: </strong> " + rs.getString("tag") + "</li>\n");
                txt.append("<li><strong>Number of pack: </strong> " + rs.getString("num_pack") + "</li>\n");
                txt.append("<li><strong>Quantity per Pack : </strong> " + rs.getString("qua_per_pack") + "</li>\n");
                txt.append("<li><strong>Primary Pack: </strong> " + rs.getString("primary_pack") + "</li>\n");
                txt.append("<li><strong>Drug Unit: </strong> " + rs.getString("unit") + "</li>\n");
                txt.append("<li><strong>Storage Temperature: </strong> " + rs.getString("temp") + "</li>\n");
                txt.append("<li><strong>Storage Humidity: </strong> " + rs.getString("humudity") + "</li>\n");
                txt.append("<li><strong>Storage Light: </strong> " + rs.getString("light") + "</li>\n");
                //txt.append("<li><strong>Drug Name: </strong> " + rs.getString("Dossage_form") + "</li>\n");
                txt.append("<li><strong>Status: </strong> " + rs.getString("status") + "</li>\n");

            }

        } catch (SQLException e) {
            dialog.error(e.getMessage(), "Error");
        }
        txt.append("</ul> " +

                "</body>\n" +
                "</html>");
        textPane1.setText(String.valueOf(txt));
        textPane1.setEditable(false); // as before
        textPane1.setBackground(null); // this is the same as a JLabel
        textPane1.setBorder(null); // remove the border
        textPane1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JDialog f = new JDialog();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(textPane1));
        f.setSize(500, 600);
        f.setVisible(true);
        f.setAlwaysOnTop(true);
        return f;
    }
}
