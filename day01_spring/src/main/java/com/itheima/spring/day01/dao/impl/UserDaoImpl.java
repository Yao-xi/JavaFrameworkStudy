package com.itheima.spring.day01.dao.impl;

import com.itheima.spring.day01.dao.UserDao;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void save() {
        System.out.println("UserDao...save...");
        System.out.println(dataSource);
    }
}
