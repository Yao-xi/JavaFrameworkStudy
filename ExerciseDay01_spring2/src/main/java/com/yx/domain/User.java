package com.yx.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("user1")
public class User {
    private String id;
    private String username;
    private String email;
    
    public User() {}
}
