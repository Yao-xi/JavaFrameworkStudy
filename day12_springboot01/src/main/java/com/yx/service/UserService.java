package com.yx.service;

import com.yx.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface UserService {
    @Transactional
    int deleteByPrimaryKey(Integer id);
    
    @Transactional
    int insert(User record);
    
    @Transactional
    int updateByPrimaryKey(User record);
    
    List<User> findAll();
    
    User findById(Integer id);
    
    User login(String username, String password);
    
}
