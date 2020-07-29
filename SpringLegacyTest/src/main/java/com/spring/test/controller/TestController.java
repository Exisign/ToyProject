package com.spring.test.controller;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.test.dao.UserDao;
import com.spring.test.domain.User;
import com.spring.test.service.UserFactory;

@Controller
public class TestController {

  private static final Logger logger = LoggerFactory.getLogger(TestController.class);


  @Autowired
  UserFactory userFactory;


  @RequestMapping(value = "/lotto", method = RequestMethod.GET)
  public String lotto(Model model) {


    /*
     * ApplicationContext context = new AnnotationConfigApplicationContext(UserFactory.class);
     * UserDao userDao = context.getBean("userDao", UserDao.class);
     */



    UserDao userDao = userFactory.userDao();


    User returnUser = null;

    try {
      User user = new User("exi2", "1234", "신상용");
      userDao.add(user);

      returnUser = userDao.getId("exi2");

    } catch (SQLException e) {
      logger.error(e.getMessage(), e);
    }

    model.addAttribute("loginInfo", returnUser);
    return "lotto";
  }
}
