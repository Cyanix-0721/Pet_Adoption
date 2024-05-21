package com.pet_adoption.service;

import com.pet_adoption.entity.User;

import java.util.List;

public interface UserService {
    User login(String userName, String userPwd);

    List<User> findAll();

    boolean insert(User user);

    boolean update(User user);

    boolean delete(Integer id);

    User findByUserId(Integer id);

    List<User> findByUserName(String userName);
}
