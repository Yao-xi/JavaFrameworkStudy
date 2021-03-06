package com.yx.service.impl;

import com.yx.dao.UserMapper;
import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional // 添加事务
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public void save() {
        System.out.println("UserService save running...");
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
    }
}
