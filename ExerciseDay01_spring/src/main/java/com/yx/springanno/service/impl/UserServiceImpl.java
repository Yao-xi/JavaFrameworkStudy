package com.yx.springanno.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.springanno.dao.UserMapper;
import com.yx.springanno.domain.User;
import com.yx.springanno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
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
