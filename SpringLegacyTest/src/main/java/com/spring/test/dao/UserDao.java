package com.spring.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.spring.test.domain.User;

public class UserDao {

  /* ConnectionMaker connectionMaker = null; */
  private DataSource dataSource;

  public UserDao(DataSource dataSource) {
    /* this.connectionMaker = connectionMaker; */
    this.dataSource = dataSource;
  }

  public void add(User user) throws SQLException {

    /* Connection conn = connectionMaker.getConnection(); */
    Connection conn = dataSource.getConnection();
    PreparedStatement ps =
        conn.prepareStatement("insert into users (id, password, name) values (?,?,?)");
    ps.setString(1, user.getId());
    ps.setString(2, user.getPassword());
    ps.setString(3, user.getName());
    ps.executeUpdate();
    ps.close();
  }

  public User getId(String id) throws SQLException {

    /* Connection conn = connectionMaker.getConnection(); */
    Connection conn = dataSource.getConnection();
    PreparedStatement psmt = conn.prepareStatement("select * from users where id = ?");
    psmt.setString(1, id);

    ResultSet rs = psmt.executeQuery();

    rs.next();

    User getUser = new User(rs.getString("id"), rs.getString("password"), rs.getString("name"));

    rs.close();
    psmt.close();

    return getUser;
  }

  public void deleteAll() throws SQLException {
    /* Connection conn = connectionMaker.getConnection(); */
    Connection conn = dataSource.getConnection();
    PreparedStatement psmt = conn.prepareStatement("delete users");
    psmt.executeQuery();

    psmt.close();
  }
}
