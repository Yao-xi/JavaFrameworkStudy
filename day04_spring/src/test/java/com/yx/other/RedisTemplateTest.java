package com.yx.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisTemplateTest {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    
    @Test
    public void test01() {
        redisTemplate.opsForValue().set("account::id::001", "A001");
        redisTemplate.opsForValue().set("account::name::001", "zhangsan");
        for (int i = 0; i < 50; i++) {
            redisTemplate.opsForList().leftPush("list1", String.valueOf(i));
        }
        
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(keys);
    }
    
    @Test
    public void test02() {
        List<String> list1 = redisTemplate.opsForList().range("list1", 0, -1);
        if (list1 != null) {
            list1.forEach(System.out::println);
        }
    }
}
