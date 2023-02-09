package com.example.test;

import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.example.test.print.print;

public class Testform {

  public static void filechooser() {
    // int width = 200;
    // int height = 200;
    // Font font = new Font("SansSerif", Font.BOLD, 14);
    // int m = 0;
    // int txt_width = 260;
    // int txt_height = 27;
    JFileChooser fileopen = new JFileChooser();
    FileFilter filter = new FileNameExtensionFilter("Scanned Files", "jpg", "jpeg", "Pdf", "Png");
    fileopen.addChoosableFileFilter(filter);

    int ret = fileopen.showDialog(null, "Open file");

    if (ret == JFileChooser.APPROVE_OPTION) {
      File file = fileopen.getSelectedFile();
      System.out.println(file);
    }
    if (ret == JFileChooser.CANCEL_OPTION) {
      System.out.println("cancel");

    }
    if (ret == JFileChooser.ERROR) {
      System.out.println("Error");
    }
  }

  public static void main(String[] args) {
    print print = new print();
    JPanel p = new JPanel();
    JFrame frame = new JFrame();
    p.setBounds(10, 10, 500, 400);
    p.setBackground(Color.GRAY);
    print.printComponenet(p);
  }
}
