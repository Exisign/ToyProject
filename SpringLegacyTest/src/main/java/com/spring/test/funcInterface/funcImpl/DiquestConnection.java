package com.spring.test.funcInterface.funcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.spring.test.funcInterface.ConnectionMaker;

public class DiquestConnection implements ConnectionMaker {

  @Override
  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:root", "exi", "1234");
  }
}
