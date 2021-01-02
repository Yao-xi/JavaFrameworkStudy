package com.yx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.Set;

@SpringBootTest
public class RedisTest {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Test
    public void testSet() {
        //存入数据
        redisTemplate.boundValueOps("name" + new Date().getTime()).set("zhangsan");
    }
    
    @Test
    public void testGet() {
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(keys);
        
        String s = redisTemplate.opsForValue().get("name1609589729081");
        System.out.println(s);
    }
}
