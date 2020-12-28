package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserMapper;
import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }
    
    @Override
    public boolean insert(User record) {
        return userMapper.insert(record) > 0;
    }
    
    @Override
    public boolean updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record) > 0;
    }
    
    @Override
    public PageInfo<User> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.findAll());
    }
    
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
    
    @Override
    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
    
}
