package com.sean.dds.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.sean.dds.demo.mapper")
//@ComponentScan("com.sean.dds")
public class DdsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdsDemoApplication.class, args);
    }

}
