package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.domain.Student;

import java.util.List;
public interface StudentService extends IService<Student>{


    List<Student> findAll();

}
