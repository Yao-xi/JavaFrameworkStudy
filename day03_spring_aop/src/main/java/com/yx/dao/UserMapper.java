package com.yx.dao;

import com.yx.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * insert record to table
     *
     * @param record
     *     the record
     *
     * @return insert count
     */
    int insert(User record);
    
    /**
     * update record
     *
     * @param record
     *     the updated record
     *
     * @return update count
     */
    int updateByPrimaryKey(User record);
    
    List<User> findAll();
    
    User findById(Integer id);
    
    int deleteById(Integer id);
}