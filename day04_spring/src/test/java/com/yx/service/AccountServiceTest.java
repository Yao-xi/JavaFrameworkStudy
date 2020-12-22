package com.yx.service;

import com.yx.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    
    @Autowired
    private AccountService accountService;
    
    @Test
    public void updateAccount() {
        accountService.updateAccount();
    }
}