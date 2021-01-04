package com.yx;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Day13SpringbootAdminServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Day13SpringbootAdminServerApplication.class, args);
    }
    
}
