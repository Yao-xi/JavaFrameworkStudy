package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.domain.Course;

import java.util.List;
public interface CourseService extends IService<Course>{


    List<Course> findAll();

}
