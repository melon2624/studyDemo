package com.zx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxin
 * @date 2022-12-13 0:25
 */
@RestController
public class SecurityController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/test2")
    public String test2(){
        return "test2";
    }

}
