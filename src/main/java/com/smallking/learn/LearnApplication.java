package com.smallking.learn;

import com.smallking.learn.model.BeanProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@SpringBootApplication
@RestController
public class LearnApplication {

    @Autowired
    private BeanProperties beanProperties;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!" + beanProperties.getTitle() + beanProperties.getName();
    }
    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
