package com.itheima.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;
    
    @Test
    public void insert() {
    }
    
    @Test
    public void updateByPrimaryKey() {
    }
    
    @Test
    public void findAll() {
        userService.findAll().forEach(System.out::println);
    }
    
    @Test
    public void findById() {
    }
    
    @Test
    public void deleteById() {
    }
}