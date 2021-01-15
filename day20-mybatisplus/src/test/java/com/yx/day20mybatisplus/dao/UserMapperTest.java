package com.yx.day20mybatisplus.dao;

import com.yx.day20mybatisplus.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}