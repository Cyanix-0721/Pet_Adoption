package com.pet_adoption.service.impl;

import com.pet_adoption.dao.UserDAO;
import com.pet_adoption.entity.User;
import com.pet_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String userName, String userPwd) {
        return userDAO.login(userName, userPwd);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean insert(User user) {
        return userDAO.insert(user) == 1;
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return userDAO.delete(id) == 1;
    }

    @Override
    public User findByUserId(Integer id) {
        return userDAO.findByUserId(id);
    }

    @Override
    public List<User> findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }
}
