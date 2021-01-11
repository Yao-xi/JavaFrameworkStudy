package com.yx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.dao.StudentMapper;
import com.yx.domain.Student;
import com.yx.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

    @Override
    public List<Student> findAll() {
        return baseMapper.findAll();
    }
}
