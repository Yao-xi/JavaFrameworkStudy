package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    int insert(User record);
    
    int updateByPrimaryKey(User record);
    
    List<User> findAll();
    
    User findById(Integer id);
    
    int deleteById(Integer id);
}

