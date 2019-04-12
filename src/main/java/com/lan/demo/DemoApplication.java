package com.lan.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author Lan
 * @description 启动类
 * @date 2019/4/4 13:56
 */
@SpringBootApplication
@MapperScan("com.lan.demo.mapper")
@EnableWebSecurity
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
