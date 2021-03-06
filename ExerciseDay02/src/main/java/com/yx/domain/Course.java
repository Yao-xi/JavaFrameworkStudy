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
@TableName(value = "course")
public class Course implements Serializable {
    @TableId(value = "cid", type = IdType.ASSIGN_UUID)
    private String cid;

    @TableField(value = "cname")
    private String cname;

    @TableField(value = "tid")
    private String tid;

    private static final long serialVersionUID = 1L;
}