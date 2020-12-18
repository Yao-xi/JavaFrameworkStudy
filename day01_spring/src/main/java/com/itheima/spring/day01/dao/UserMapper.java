package com.itheima.spring.day01.dao;

import com.itheima.spring.day01.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
