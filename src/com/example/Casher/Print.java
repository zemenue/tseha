package com.example.Casher;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class Print {
  StringBuilder txt;

  public void print() {

    String HTMLTEXT = "";
    ;
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
        "</style>" +

        "<table style=\"height: 54px;\" border=\"0\" width=\"100%\">\n" +
        "<tbody>\n" +
        "<tr>\n" +
        "<td style=\"width: 230.5px; text-align: left;\">\n" +
        "<h1><strong><img style=\"display: block; margin-left: auto; margin-right: auto; float: left;\" src=\"https://www.vhv.rs/dpng/d/588-5889568_snc-logo-sierra-nevada-college-eagle-logo-hd.png\" alt=\"\" width=\"85\" height=\"85\" /></strong></h1>\n"
        +

        "</td>\n" +
        "<td style=\"width: 230.5px; text-align: right;\">\n" +
        "<h1><strong>Invoice</strong></h1>\n" +
        "</td>\n" +
        "</tr>\n" +
        "<tr>\n" +
        "<td style=\"width: 230.5px;\">\n" +
        "<p>Dilled to:</p>\n" +
        "<p>Abrham Yishak</p>\n" +
        "<p>Address :Addis Ababa Ethiopia</p>\n" +
        "</td>\n" +
        "<td style=\"width: 230.5px; text-align: right;\">\n" +
        "<p>Invoice No. </p>\n" +
        "<p>20/5/2023</p>\n" +
        "</td>\n" +
        "</tr>\n" +
        "</tbody>\n" +
        "</table>" +
        "</br>" +
        "<p></p>" +
        "<p></p>" +

        "<table  id=\"invoice\"  style=\"width:100%\">\n" +
        "  <tr>\n" +
        "    <th>Item</th>\n" +
        "    <th>Quantity</th>\n" +
        "    <th>Unit Price</th>\n" +
        "    <th>Total</th>\n" +
        "  </tr>\n");
    for (int i = 0; i <= 4; i++) {
      txt.append("  <tr  style=\" text-align: right;\">\n" +
          "    <td  >paracetamol</td>\n" +
          "    <td >5</td>\n" +
          "    <td>25</td>\n" +
          "    <td>125</td>\n" +
          "  </tr>\n");
    }
    txt.append("  <tr>\n" +
        "<td rowspan=\"3\" colspan=\"2\"> </td>" +
        "<td   style=\" text-align: right;\">Subtotal</td>" +

        "    <td>100</td>\n" +
        "  </tr>\n" +
        "  <tr>\n" +

        "<td   style=\" text-align: right;\">Tax(15%)</td>" +

        "    <td>15</td>\n" +
        "  </tr>\n" +
        "  <tr>\n" +

        "<td  style=\" text-align: right;\">Total</td>" +

        "    <td>115</td>\n" +
        "  </tr>\n" +

        "</body>\n" +
        "</html>");
    textPane1.setText(String.valueOf(txt));
    textPane1.setEditable(false); // as before
    textPane1.setBackground(null); // this is the same as a JLabel
    textPane1.setBorder(null); // remove the border
    textPane1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(textPane1));
    f.setSize(600, 700);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

}
