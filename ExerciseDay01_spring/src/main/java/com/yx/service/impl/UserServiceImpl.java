package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserMapper;
import com.yx.domain.User;
import com.yx.service.UserService;


import java.util.List;

public class UserServiceImpl implements UserService {
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
