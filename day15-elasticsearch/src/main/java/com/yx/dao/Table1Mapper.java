package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.domain.Table1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Table1Mapper extends BaseMapper<Table1> {
    List<Table1> findAll();
    
    Table1 findById(@Param("id") String id);
}