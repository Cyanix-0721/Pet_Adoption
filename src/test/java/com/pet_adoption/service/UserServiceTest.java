package com.pet_adoption.service;

import com.pet_adoption.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> list = userService.findAll();
        for (User user : list)
            System.out.println(user.toString());
    }

    @Test
    public void testFindByName() {
        List<User> list = userService.findByUserName("孤");
        for (User user : list)
            System.out.println(user.toString());
    }

    //新增用户
    @Test
    public void testInsert() {
        User user = new User("test", "123456", "男", 18, "13913913913", "", "test", "test", 1);
        boolean result = userService.insert(user);
        System.out.println(result);
    }

    //更新用户
    @Test
    public void testUpdate() {
        User user = new User(41, "test", "123456", "男", 18, "13913913913", "", "test", "test", 1);
        boolean result = userService.update(user);
        System.out.println(result);
    }
}
