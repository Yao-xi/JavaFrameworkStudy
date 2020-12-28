package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserService {
    @Transactional(readOnly = false)
    boolean deleteByPrimaryKey(Integer id);
    
    @Transactional(readOnly = false)
    boolean insert(User record);
    
    @Transactional(readOnly = false)
    boolean updateByPrimaryKey(User record);
    
    PageInfo<User> findAll(int pageNum, int pageSize);
    
    User findById(Integer id);
    
    User login(String username, String password);
    
}
