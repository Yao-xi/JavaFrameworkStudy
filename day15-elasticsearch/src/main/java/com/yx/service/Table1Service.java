package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.domain.Table1;

import java.util.List;

public interface Table1Service extends IService<Table1>{


    List<Table1> findAll();

    Table1 findById(String id);

}
