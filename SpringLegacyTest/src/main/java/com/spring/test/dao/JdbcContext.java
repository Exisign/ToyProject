package com.spring.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcContext {

  DataSource dataSource = null;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void executeStatementStrategy(Strategy strategy) throws SQLException {

    Connection conn = dataSource.getConnection();
    PreparedStatement psmt = null;

    try {
      psmt = strategy.makePrepareStatement(conn);
      psmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      if (psmt != null) {
        try {
          psmt.close();
        } catch (Exception e) {
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
        }
      }
    }
  }
}
