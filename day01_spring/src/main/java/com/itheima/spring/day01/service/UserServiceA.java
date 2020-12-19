package com.itheima.spring.day01.service;

import com.github.pagehelper.PageInfo;
import com.itheima.spring.day01.domain.User;

import java.util.List;

public interface UserServiceA {
    List<User> findAll();
    PageInfo<User> findAll(int page,int size);
}
