package com.example.Casher;

import com.example.Data.Query;
import com.example.functions.Dialogs;
import com.sun.jndi.cosnaming.IiopUrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Print {
    StringBuilder txt;
    Query query = new Query();
    Dialogs dialog = new Dialogs();

    public JDialog print(int id) throws SQLException {

        ResultSet rs = query.retrieveData("SELECT * FROM sell  WHERE  sell_id=" + id + "");
        String name = null,dosage = null, address = null, sell_id = null,card_num = null, drugname = null, status, unit = null;
        double quant = 0;
        Double price = null;
        while (rs.next()) {

            sell_id = rs.getString("sell_id");
            drugname = rs.getString("drug_id");
            quant = Double.parseDouble(rs.getString("quantity"));
            unit = rs.getString("unit");
            card_num = rs.getString("card_number");
            name = rs.getString("patient_name");
            status = rs.getString("status");
            address = rs.getString("address");
            dosage= rs.getString("dosage");
                    
        }
        ResultSet resultSet=query.retrieveData("SELECT * FROM sell  WHERE  card_number=" + card_num + "");


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
                "<p>" + name + "</p>\n" +
                "<p>Address :" + address + "</p>\n" +
                "</td>\n" +
                "<td style=\"width: 230.5px; text-align: right;\">\n" +
                "<p>Invoice No." + sell_id + "" +
                "<p>" + new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()) + "</p>\n" +
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
        double total=0;
        while (resultSet.next()){
           ResultSet r= query.retrieveData("SELECT Drug FROM Drug WHERE Drug_name='"+drugname+"'" +
                    "AND unit='"+ unit+"'  AND Dossage_form='"+dosage+"'");

            while (r.next()){
                price=r.getDouble("single_price");
            }
            total=total+(price*quant);
            txt.append("  <tr  style=\" text-align: right;\">\n" +
                    "    <td >"+drugname+"</td>\n" +
                    "    <td >"+quant+"</td>\n" +
                    "    <td>"+price+"</td>\n" +
                    "    <td>"+price*quant +
                    "  </tr>\n");
        }


        txt.append("  <tr>\n" +
                "<td rowspan=\"3\" colspan=\"2\"> </td>" +
                "<td   style=\" text-align: right;\">Subtotal</td>" +

                "    <td>"+total+"</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +

                "<td   style=\" text-align: right;\">Tax(15%)</td>" +

                "    <td>"+(total*15)/100+"</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +

                "<td  style=\" text-align: right;\">Total</td>" +

                "    <td>"+((total*15)/100)+total+"</td>\n" +
                "  </tr>\n" +

                "</body>\n" +
                "</html>");
        textPane1.setText(String.valueOf(txt));
        textPane1.setEditable(false); // as before
        textPane1.setBackground(null); // this is the same as a JLabel
        textPane1.setBorder(null); // remove the border
        textPane1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu = new JPopupMenu();

        JMenuItem menuItemDelete = new JMenuItem("Paid And Print");
        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                query.Delete_update("Update sell SET status='Paid'   WHERE sell_id=" + id + "", "Drug Paid."
                        , "Sell", "Can't pay.", "Error", "Are you sure you collect rhe money"
                );
                printComponenet(textPane1);

            }
        });

        popupMenu.add(menuItemDelete);
        textPane1.setComponentPopupMenu(popupMenu);
        JDialog f = new JDialog();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(textPane1));
        f.setSize(600, 700);
        f.setAlwaysOnTop(true);
        f.setVisible(true);
        return f;
    }

    public void printComponenet(Component component) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                component.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (!pj.printDialog())
            return;
        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }

}
