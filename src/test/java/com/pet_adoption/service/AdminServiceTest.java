package com.pet_adoption.service;

import com.pet_adoption.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testLogin() {
        Admin admin = adminService.login("admin", "123456");
        if (admin != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void testFindAll() {
        List<Admin> admins = adminService.findAll();
        for (Admin admin : admins) {
            System.out.println(admin.toString());
        }
    }
}