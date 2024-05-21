package com.pet_adoption.dao;

import com.pet_adoption.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDAO")
public interface UserDAO {
    User login(@Param("userName") String userName,
               @Param("userPwd") String userPwd);


    List<User> findAll();

    int insert(@Param("user") User user);

    int update(@Param("user") User user);

    int delete(@Param("id") Integer id);

    User findByUserId(@Param("id") Integer id);

    List<User> findByUserName(@Param("userName") String userName);
}
