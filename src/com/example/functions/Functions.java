package com.example.functions;

import com.example.Data.Query;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class Functions {
  Dialogs dialog=new Dialogs();
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

  public void check_expired_drugs() {

  }
  public void get_expired_drugs( String from,String to) {

  }


  //////////////////////////////end drugs//////////////////////////////
}
