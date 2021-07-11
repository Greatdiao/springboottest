package com.odianyun.springboottest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: EDZ
 * @time: 16:38
 * @date: 2021/7/10
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
