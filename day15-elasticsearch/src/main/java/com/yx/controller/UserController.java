package com.yx.controller;

import com.yx.domain.Table1;
import com.yx.domain.User;
import com.yx.service.Table1Service;
import com.yx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private Table1Service table1Service;
    
    @RequestMapping("/user")
    public String show() {
        List<User> list = userService.findAll();
        System.out.println(list);
        log.trace("trace....");
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error....");
        return "show";
    }
    
    @RequestMapping("/login")
    public User login(String username, String password) {
        User login = userService.login(username, password);
        System.out.println(login);
        return login;
    }
    
    @GetMapping("/{id}")
    public Table1 getTable(@PathVariable String id) {
        return table1Service.findById(id);
    }
    
    @GetMapping("/like/{username}")
    public List<User> findLikeName(@PathVariable String username) {
        return userService.findLikeName(username);
    }
}
