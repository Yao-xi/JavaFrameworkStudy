package com.yx.dao;

import com.yx.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    void testFindAll() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }
}