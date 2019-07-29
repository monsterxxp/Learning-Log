package com.smallking;

//import com.smallking.annotation.Log;
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

//    @Log("123")
    @GetMapping(value = "/test")
    public String test() {
        return "asfd";
    }
}
