package com.yx.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String email;
    
    public User() {}
}
