package com.yx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.dao.CourseMapper;
import com.yx.domain.Course;
import com.yx.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService{

    @Override
    public List<Course> findAll() {
        return baseMapper.findAll();
    }
}
