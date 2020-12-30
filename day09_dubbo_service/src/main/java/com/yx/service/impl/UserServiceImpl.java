package com.yx.service.impl;


import com.yx.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(weight = 200)
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        System.out.println("hello 200");
        return "hello v1";
    }
}
