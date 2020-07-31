package com.spring.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Strategy {
  public PreparedStatement makePrepareStatement(Connection conn) throws SQLException;
}
