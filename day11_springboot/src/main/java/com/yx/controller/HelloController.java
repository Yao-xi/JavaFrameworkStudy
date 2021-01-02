package com.yx.controller;

import com.yx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Autowired
    User user;
    
    @GetMapping("hello")
    public String hello() {
        System.out.println(user);
        return "hello";
    }
}
