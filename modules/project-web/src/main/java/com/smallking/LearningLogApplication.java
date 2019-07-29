package com.smallking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LearningLogApplication extends SpringBootServletInitializer {

    /**
     * 1、启动类继承SpringBootServletInitializer
     * 2、重写configure方法
     * @description:
     * @author: smallking
     * @date: 2019年9月29日
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LearningLogApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LearningLogApplication.class, args);
    }

}
