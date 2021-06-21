package com.zx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	public String a="zx";


    @RequestMapping("/zx/test")
    public  String test(){

        return null;
    }
}
