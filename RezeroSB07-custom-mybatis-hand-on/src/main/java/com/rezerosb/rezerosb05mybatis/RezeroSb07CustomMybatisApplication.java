package com.rezerosb.rezerosb05mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rezerosb")
public class RezeroSb07CustomMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RezeroSb07CustomMybatisApplication.class, args);
    }

}
