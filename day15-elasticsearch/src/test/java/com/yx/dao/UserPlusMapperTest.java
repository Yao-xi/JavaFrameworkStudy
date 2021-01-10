package com.yx.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yx.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootTest
@EnableTransactionManagement
public class UserPlusMapperTest {
    @Autowired
    private UserPlusMapper userMapper;
    
    @Test
    void testFindAll() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> list = userMapper.selectList(wrapper);
        System.out.println(list);
    }
    
    @Test
    void test01(){
    }
}