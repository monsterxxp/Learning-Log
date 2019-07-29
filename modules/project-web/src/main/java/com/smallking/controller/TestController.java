package com.smallking.controller;

import com.smallking.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Log
    @GetMapping("/hello")
    public String test() {
        return "123";
    }
}
