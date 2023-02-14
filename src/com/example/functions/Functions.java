package com.example.functions;

import com.example.Data.Query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functions {
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

  public  ResultSet refresh_table() throws SQLException {
    Query query=new Query();
    return query.retrieveData(" SELECT * FROM Drug");

  }
}
