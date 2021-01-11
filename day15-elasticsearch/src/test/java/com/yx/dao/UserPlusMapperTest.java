package com.yx.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
@EnableTransactionManagement
public class UserPlusMapperTest {
    @Autowired
    private UserPlusMapper userMapper;
    
    @Test
    void testFindAll() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }
    
    @Test
    void test01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 6);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }
    
    @Test
    void test02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("gender", "count(id)").groupBy("gender");
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }
    
    @Test
    void test03() {
        int i = userMapper.insert(new User(null, "aaaaab", "aaa",
                                           "aaa", 0, new Date()));
        System.out.println("已更新: " + i);
    }
    
    @Test
    void test04() {
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 2), null);
        System.out.println(userPage);
    }
}