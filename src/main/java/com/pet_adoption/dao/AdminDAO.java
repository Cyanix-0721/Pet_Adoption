package com.pet_adoption.dao;

import com.pet_adoption.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdminDAO")
public interface AdminDAO {
    Admin login(@Param("adminName") String adminName,
                @Param("adminPwd") String adminPwd);

    List<Admin> findAll();

    int insert(@Param("admin") Admin admin);

    int update(@Param("admin") Admin admin);

    int delete(@Param("id") Integer id);

    Admin findByAdminId(@Param("adminId") Integer id);

    List<Admin> findByAdminName(@Param("adminName") String adminName);
}
