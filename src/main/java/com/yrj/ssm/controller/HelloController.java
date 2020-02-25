package com.yrj.ssm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/2/25 13:48
 * @description：1.0
 * @version: 测试控制类$
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello () {
        return "hello";
    }
}
