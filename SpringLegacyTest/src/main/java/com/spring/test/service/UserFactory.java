package com.spring.test.service;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import com.spring.test.dao.JdbcContext;
import com.spring.test.dao.UserDao;

@Service
public class UserFactory {

  @Bean
  // 미묘한 부분이 JdbcContext의 경우 interface가 아니라, 직접적으로 서술 된 클래스인데, 그것을 그대로 전달 받는다. 결합도는 낮으나, 응집도가
  // 떨어진다(의존성 주입은 맞는것 같다...)
  public UserDao userDao() {
    UserDao userDao = new UserDao(dataSource());
    userDao.setJdbcContext(jdbcContext());
    return userDao;
  }

  /*
   * @Bean public ConnectionMaker connectionMaker() { return new DiquestConnection(); }
   */
  // 이것은 Bean을 통해서 DataSource를 DI받는 구조이다.
  @Bean
  public JdbcContext jdbcContext() {
    JdbcContext jdbcContext = new JdbcContext();
    jdbcContext.setDataSource(dataSource());
    return jdbcContext;
  }

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
