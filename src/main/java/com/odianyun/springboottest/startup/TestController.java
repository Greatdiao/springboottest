package com.odianyun.springboottest.startup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: EDZ
 * @time: 16:54
 * @date: 2021/7/10
 */
@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        return "test";
    }
}
