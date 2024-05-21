package com.pet_adoption.dao;

import com.pet_adoption.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindAll() {
        List<User> list = userDAO.findAll();
        for (User admin : list)
            System.out.println(admin.toString());
    }

    @Test
    public void testLogin() {
        User admin = userDAO.login("白白", "123456");
        System.out.println(admin.toString());
    }

    @Test
    public void testInsert() {
        User user = new User("test", "123456", "男", 18, "13913913913", "test@Outlook.com", "test", "test", 1);
        int result = userDAO.insert(user);
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        User user = new User(41, "test", "123456", "男", 18, "13913913913", "test@Outlook.com", "test", "test", 1);
        int result = userDAO.update(user);
        System.out.println(result);
    }
}
