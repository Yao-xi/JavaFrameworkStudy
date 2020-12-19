package com.yx.dao;


import com.yx.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
