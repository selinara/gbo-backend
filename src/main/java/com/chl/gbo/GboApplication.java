package com.chl.gbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//spring security 关闭默认安全访问控制
public class GboApplication {

    public static void main(String[] args) {
        SpringApplication.run(GboApplication.class, args);
    }

}
