package com.smallking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: learning-log
 * @description: ceshi
 * @author: smallking
 * @create: 2019-07-28 05:02
 **/
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "asfd";
    }
}
