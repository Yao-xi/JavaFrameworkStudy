package com.itheima.spring.day01.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceATest {
    
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceA userServiceA = (UserServiceA) ac.getBean("userServiceA");
        System.out.println(userServiceA.findAll());
    }
}