package com.yx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.dao.Table1Mapper;
import com.yx.domain.Table1;
import com.yx.service.Table1Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Table1ServiceImpl extends ServiceImpl<Table1Mapper, Table1> implements Table1Service {
    
    @Override
    public List<Table1> findAll() {
        return baseMapper.findAll();
    }
    
    @Override
    public Table1 findById(String id) {
        return baseMapper.findById(id);
    }
}
