package com.yx.springanno.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    @Value("A001")
    private String id;
    @Value("zhangsan")
    private String username;
    @Value("zs@zs.com")
    private String email;
    
    public User() {}
}
