package com.yx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.domain.Sc;

import java.util.List;
public interface ScService extends IService<Sc>{


    List<Sc> findAll();

}
