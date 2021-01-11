package com.yx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.dao.TeacherMapper;
import com.yx.domain.Teacher;
import com.yx.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService{

    @Override
    public List<Teacher> findAll() {
        return baseMapper.findAll();
    }
}
