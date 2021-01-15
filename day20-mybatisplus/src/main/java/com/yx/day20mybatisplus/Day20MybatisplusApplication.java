package com.yx.day20mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yx.day20mybatisplus.dao")
public class Day20MybatisplusApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Day20MybatisplusApplication.class, args);
    }
    
}
