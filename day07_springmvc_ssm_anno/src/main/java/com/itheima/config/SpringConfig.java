package com.itheima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "com.itheima",excludeFilters =
    @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class}))
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@Import({MyBatisConfig.class,JdbcConfig.class})
public class SpringConfig {
    @Bean("transactionManager")
    public DataSourceTransactionManager getTxManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource);
        return tm;
    }
}






