package com.yx.dao;

import com.yx.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**
     * delete by primary key
     *
     * @param id
     *     primaryKey
     *
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);
    
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
    
    List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    
    List<User> findLikeName(String username);
}