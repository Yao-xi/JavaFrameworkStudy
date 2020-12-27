package com.yx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "用户名不能为空")
    private String username;
    
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 8, message = "长度至少8位")
    private String password;
    
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    
    /**
     * 性别
     */
    // @Gender(message = "性别只能为0或1")
    private Integer gender;
    
    /**
     * 生日
     */
    private Date birthday;
}