package com.love.marriage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Crete by Marlon
 * Create Date: 1/9/2018
 * Class Describe
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.love.marriage.dataobject.mapper")
public class NearLoveMarryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NearLoveMarryApplication.class, args);
    }

}
