package com.yx.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        User user = new User();
        user.setUsername("bab");
        user.setPassword("aaa");
        user.setNickname("aaa");
        user.setGender(0);
        user.setBirthday(new Date());
        
        int i = userMapper.insert(user);
        System.out.println("已更新: " + i);
    }
    
    @Test
    void test04() {
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 2), null);
        System.out.println(userPage.getRecords());
    }
    
    @Test
    void test05() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, 8);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    
    @Test
    void test06() {
        User user = new User();
        user.setUsername("CCC");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 8);
        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }
    
    @Test
    void test07() {
        List<User> list =
            userMapper.selectList(
                new QueryWrapper<User>()
                    .likeRight("username", "zhang"));
        System.out.println(list);
    }
    
    @Test
    void test08() {
        int j = 0;
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUsername(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10));
            user.setPassword("aaa");
            user.setNickname("aaa");
            user.setGender(0);
            user.setBirthday(new Date());
            try {
                j += userMapper.insert(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("已更新: " + j);
    }
}