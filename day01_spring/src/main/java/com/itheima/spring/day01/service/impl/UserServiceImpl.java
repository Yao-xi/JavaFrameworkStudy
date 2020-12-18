package com.itheima.spring.day01.service.impl;

import com.itheima.spring.day01.dao.UserDao;
import com.itheima.spring.day01.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public void save() {
        userDao.save();
        System.out.println("UserService...save...");
    }
}
