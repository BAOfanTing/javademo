package com.example.demo.controller;

import com.example.demo.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @RequestMapping("/sayHello")
    public Result<String> sayHello(@RequestParam String name ) {
        return Result.success("hello " + name);
    }
}
