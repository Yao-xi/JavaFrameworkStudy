package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.domain.Teacher;

import java.util.List;
public interface TeacherService extends IService<Teacher>{


    List<Teacher> findAll();

}
