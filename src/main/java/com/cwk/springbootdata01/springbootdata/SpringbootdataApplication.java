package com.cwk.springbootdata01.springbootdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cwk.springbootdata01.springbootdata.mapper")
@SpringBootApplication
public class SpringbootdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdataApplication.class, args);
    }

}
