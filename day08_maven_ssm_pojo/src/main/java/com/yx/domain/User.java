package com.yx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 昵称
     */
    private String nickname;
    
    /**
     * 性别
     */
    private Integer gender;
    
    /**
     * 生日
     */
    private Date birthday;
}