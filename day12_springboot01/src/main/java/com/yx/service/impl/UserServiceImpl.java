package com.yx.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yx.dao.UserMapper;
import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }
    
    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
    
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
    
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
    
    @Override
    public User login(String username, String password) {
        String s = redisTemplate.opsForValue().get("user::" + username + "::" + password);
        if (s != null && s.length() > 0) {
            try {
                return new ObjectMapper().readValue(s, User.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        User user = null;
        List<User> list = userMapper.findByUsernameAndPassword(username, password);
        if (list != null && list.size() > 0) {
            user = list.get(0);
            if (user != null) {
                try {
                    String s1 = new ObjectMapper().writeValueAsString(user);
                    redisTemplate.opsForValue().set("user::" + username + "::" + password, s1, 3, TimeUnit.MINUTES);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return user;
    }
    
}
