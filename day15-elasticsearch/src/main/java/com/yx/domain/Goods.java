package com.yx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    
    private String title;
    private Double price;
    private Date createTime;
    private String categoryName;
    private String brandName;
    private Integer saleNum;
    private Integer stock;
    private String spec;
}
