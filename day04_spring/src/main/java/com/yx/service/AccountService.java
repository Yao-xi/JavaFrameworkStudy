package com.yx.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountService {
    void updateAccount();
    
    @Transactional(readOnly = true)
    void findAll();
}
