package com.example.springbootmybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.springbootmybatistest.mapper")
@EnableSwagger2
public class SpringbootMybatisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisTestApplication.class, args);
    }

}
