package com.yx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student implements Serializable {
    @TableId(value = "sid", type = IdType.ASSIGN_UUID)
    private String sid;

    @TableField(value = "sname")
    private String sname;

    @TableField(value = "sage")
    private Date sage;

    @TableField(value = "ssex")
    private String ssex;

    private static final long serialVersionUID = 1L;
}