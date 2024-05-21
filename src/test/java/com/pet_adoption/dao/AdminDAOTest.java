package com.pet_adoption.dao;

import com.pet_adoption.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminDAOTest {

    @Autowired
    private AdminDAO adminDAO;

    @Test
    public void testFindAll() {
        List<Admin> list = adminDAO.findAll();
        for (Admin admin : list)
            System.out.println(admin.toString());
    }

    @Test
    public void testLogin() {
        Admin admin = adminDAO.login("白白", "123456");
        System.out.println(admin.toString());
    }
}
