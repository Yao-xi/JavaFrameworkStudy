package com.yx.dao;

import com.yx.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    Integer insert(User record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    Integer updateByPrimaryKey(User record);

    List<User> findAll();

    User findById(@Param("id") Integer id);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}