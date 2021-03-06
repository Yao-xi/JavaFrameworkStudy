package com.itheima.spring.day01.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.spring.day01.dao.UserMapper;
import com.itheima.spring.day01.domain.User;
import com.itheima.spring.day01.service.UserServiceA;

import java.util.List;

public class UserServiceAImpl implements UserServiceA {
    private UserMapper userMapper;
    
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    
    @Override
    public PageInfo<User> findAll(int page, int size) {
        PageHelper.startPage(page, size);
        List<User> all = userMapper.findAll();
        return new PageInfo<>(all);
    }
}
