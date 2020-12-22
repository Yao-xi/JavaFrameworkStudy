package com.yx.service.impl;

import com.yx.dao.AccountMapper;
import com.yx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountMapper accountMapper;
    
    @Override
    public void updateAccount() {
        accountMapper.outMoney("zs", 200);
        int i = 1 / 0;
        accountMapper.inMoney("ls", 200);
    }
    
    @Override
    public void findAll() {
    
    }
}
