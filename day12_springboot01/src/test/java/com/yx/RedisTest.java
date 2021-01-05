package com.yx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Test
    public void testSet() {
        //存入数据
        redisTemplate.boundValueOps("name").set("zhangsan", 3, TimeUnit.MINUTES);
    }
    
    @Test
    public void testGet() {
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(keys);
        redisTemplate.boundValueOps("name");
        String s = redisTemplate.boundValueOps("name").get();
        System.out.println(s);
    }
}
