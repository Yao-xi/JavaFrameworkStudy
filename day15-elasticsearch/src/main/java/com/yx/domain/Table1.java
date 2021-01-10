package com.yx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 测试表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "table_1")
public class Table1 implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "age")
    private Integer age;

    private static final long serialVersionUID = 1L;
}