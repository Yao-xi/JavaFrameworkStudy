package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.domain.Sc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScMapper extends BaseMapper<Sc> {
    List<Sc> findAll();
}