package com.example.functions;

import com.example.Data.Query;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class Functions {
  Dialogs dialog=new Dialogs();
  Query query=new Query();
  public  List<Map<String, ?>> resultSetToList(ResultSet rs)
      throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List<Map<String, ?>> results = new ArrayList<Map<String, ?>>();
    while (rs.next()) {
      Map<String, Object> row = new HashMap<String, Object>();
      for (int i = 1; i <= columns; i++) {
        row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
      } /* w ww. j a v a 2 s . c o m */
      results.add(row);
    }
    return results;
  }


  public   void copyFile(File source, File dest) throws IOException {
    FileChannel sourceChannel = null;
    FileChannel destChannel = null;
    try {
      sourceChannel = new FileInputStream(source).getChannel();
      destChannel = new FileOutputStream("files/"+dest).getChannel();
      destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
    }catch (Exception e){
      dialog.error("Error:"+e.getMessage(),"File Error");
    }
    finally{
      sourceChannel.close();
      destChannel.close();
    }
  }
  public String getExtension(String filename) {
    return FilenameUtils.getExtension(filename);
  }
  public String random_string()  {
    return UUID.randomUUID().toString();
  }
  ///////////////////////////////drugs///////////////////////


  public void check_expired_drugs(){
    try{

     ResultSet resultset = query.retrieveData("SELECT * FROM Drug WHERE expire_date <= CURRENT_DATE()");
      int i = 0;
      while (resultset.next()) {
        i++;
      }
      if(i>0){
        dialog.error("There are "+i+" Expired Drugs ","Expired Drugs");
      }
    } catch (Exception e){
      dialog.error(e.getMessage(),"Error");

    }
  }

  public ResultSet get_expired_drugs( ) {
    try {
      return query.retrieveData("SELECT * FROM Drug WHERE expire_date <= CURRENT_DATE()");
    } catch (SQLException e) {
      dialog.error(e.getMessage(),"Error m");
    }
    return null;
  }
  public void frame_dialog( JFrame frame,int width,int height) {
    JDialog dialog = new JDialog(frame);
    dialog.setTitle("Dialog created without extending JDialog class.");
    dialog.setSize(new Dimension(width, height));
    dialog.setLocationRelativeTo(frame);
    dialog.setModal(true);
    dialog.setVisible(true);
  }

  //////////////////////////////end drugs//////////////////////////////
}
