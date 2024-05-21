package com.pet_adoption.service.impl;

import com.pet_adoption.dao.AdminDAO;
import com.pet_adoption.entity.Admin;
import com.pet_adoption.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin login(String adminName, String adminPwd) {
        return adminDAO.login(adminName, adminPwd);
    }

    @Override
    public List<Admin> findAll() {
        return adminDAO.findAll();
    }

    @Override
    public boolean insert(Admin admin) {
        return adminDAO.insert(admin) == 1;
    }

    @Override
    public boolean update(Admin admin) {
        return adminDAO.update(admin) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return adminDAO.delete(id) == 1;
    }

    @Override
    public Admin findByAdminId(Integer id) {
        return adminDAO.findByAdminId(id);
    }

    @Override
    public List<Admin> findByAdminName(String adminName) {
        return adminDAO.findByAdminName(adminName);
    }

}
