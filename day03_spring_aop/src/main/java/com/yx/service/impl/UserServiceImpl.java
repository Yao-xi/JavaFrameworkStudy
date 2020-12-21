package com.yx.service.impl;

import com.yx.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("UserService save running...");
    }
}
