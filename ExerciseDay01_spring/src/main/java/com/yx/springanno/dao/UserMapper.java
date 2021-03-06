package com.yx.springanno.dao;


import com.yx.springanno.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAll();
}
