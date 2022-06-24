package com.cqu.pls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqu.pls.dao")
public class PlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlsApplication.class, args);
    }

}
