package com.spring.test;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.test.dao.UserDao;
import com.spring.test.domain.User;
import com.spring.test.service.UserFactory;

public class UserDaoTest {

  @Test
  public void test() throws SQLException {

    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(UserFactory.class);
    UserDao userDao = context.getBean("userDao", UserDao.class);
    userDao.deleteAll();

    User user = new User("1", "1234", "exi");

    userDao.add(user);
    User getUser = userDao.getId("1");
    assertEquals(getUser.getName(), "exi");
  }

}
