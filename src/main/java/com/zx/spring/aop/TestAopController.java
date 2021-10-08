package com.zx.spring.aop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhangxin
 * @date : 2021-09-17 15:23
 **/
@RestController
@RequestMapping("/zx")
public class TestAopController {


    @PostMapping("/aop")
    public  String  aopTest(String zx){
        System.out.println("张鑫的aop");
        //int i=1/0;
        return "张鑫";
    }

}
