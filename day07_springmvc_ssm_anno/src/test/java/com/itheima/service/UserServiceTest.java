package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.config.SpringConfig;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceTest {
    
    @Autowired
    UserService userService;
    
    @Test
    public void findAll() {
        PageInfo<User> all = userService.findAll(1, 10);
    }
}