package com.yx.service.impl;


import com.yx.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(weight = 100)
public class UserServiceImpl implements UserService {
    static int i = 0;
    
    @Override
    public String sayHello() {
        System.out.println("hello 100 " + i++);
        return "hello v1";
    }
}
