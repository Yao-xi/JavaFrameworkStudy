package com.yx.springanno.service;

import com.github.pagehelper.PageInfo;
import com.yx.springanno.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAll();
    PageInfo<User> findAll(int page, int size);
}
