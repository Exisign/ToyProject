package com.spring.test.service;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import com.spring.test.dao.UserDao;

@Service
public class UserFactory {

  @Bean
  public UserDao userDao() {
    return new UserDao(dataSource());
  }

  /*
   * @Bean public ConnectionMaker connectionMaker() { return new DiquestConnection(); }
   */

  @Bean
  public DataSource dataSource() {

    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/root");
    dataSource.setUsername("exi");
    dataSource.setPassword("1234");

    return dataSource;
  }
}
