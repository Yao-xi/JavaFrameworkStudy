package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.domain.User;


import java.util.List;

public interface UserService {
    List<User> findAll();
    PageInfo<User> findAll(int page, int size);
}
