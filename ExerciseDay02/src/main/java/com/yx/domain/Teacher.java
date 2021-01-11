package com.yx.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "teacher")
public class Teacher implements Serializable {
    @TableId(value = "tid", type = IdType.ASSIGN_UUID)
    private String tid;

    @TableField(value = "tname")
    private String tname;

    private static final long serialVersionUID = 1L;
}