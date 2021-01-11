package com.yx.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sc")
public class Sc implements Serializable {
    @TableField(value = "sid")
    private String sid;

    @TableField(value = "cid")
    private String cid;

    @TableField(value = "score")
    private Double score;

    private static final long serialVersionUID = 1L;
}