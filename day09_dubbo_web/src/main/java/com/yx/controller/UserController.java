package com.yx.controller;

import com.yx.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    UserService userService;
    
    @GetMapping("/a")
    public String sayHello() {
        return userService.sayHello();
    }
}
