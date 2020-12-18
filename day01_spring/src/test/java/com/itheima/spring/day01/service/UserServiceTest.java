package com.itheima.spring.day01.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void test01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-service.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        userService.save();
    }
}