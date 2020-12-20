package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

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
    
    User findById(@Param("id") Integer id);
    
    int deleteById(@Param("id") Integer id);
}