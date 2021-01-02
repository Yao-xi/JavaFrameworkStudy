package com.yx.controller;

import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/user")
    public String show() {
        List<User> list = userService.findAll();
        System.out.println(list);
        return "show";
    }
    
    @RequestMapping("/login")
    public User login(String username, String password) {
        User login = userService.login(username, password);
        System.out.println(login);
        return login;
    }
}
