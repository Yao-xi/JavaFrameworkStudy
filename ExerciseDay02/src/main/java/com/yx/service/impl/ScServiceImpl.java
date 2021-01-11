package com.yx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.dao.ScMapper;
import com.yx.domain.Sc;
import com.yx.service.ScService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScServiceImpl extends ServiceImpl<ScMapper, Sc> implements ScService{

    @Override
    public List<Sc> findAll() {
        return baseMapper.findAll();
    }
}
