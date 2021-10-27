package com.lab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lab.dao")
@EnableTransactionManagement
public class BackApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

}
