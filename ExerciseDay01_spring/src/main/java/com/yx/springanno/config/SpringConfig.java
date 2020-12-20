package com.yx.springanno.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.yx.springanno")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
