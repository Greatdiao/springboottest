package com.odianyun.springboottest.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: EDZ
 * @time: 16:24
 * @date: 2021/7/10
 */
@SpringBootApplication(scanBasePackages = "com.odianyun.springboottest")
@MapperScan("com.odianyun.springboottest.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
