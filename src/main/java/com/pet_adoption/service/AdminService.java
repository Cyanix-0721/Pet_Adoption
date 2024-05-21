package com.pet_adoption.service;

import com.pet_adoption.entity.Admin;

import java.util.List;


public interface AdminService {
    Admin login(String adminName, String adminPwd);

    List<Admin> findAll();

    boolean insert(Admin admin);

    boolean update(Admin admin);

    boolean delete(Integer id);

    Admin findByAdminId(Integer id);

    List<Admin> findByAdminName(String adminName);
}
