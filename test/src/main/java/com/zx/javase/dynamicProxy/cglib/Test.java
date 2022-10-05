package com.zx.javase.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhangxin
 * @date 2022-02-20 0:25
 */
public class Test {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyCalcutor.class);

        enhancer.setCallback(new MyCglib());
        MyCalcutor myCalcutor = (MyCalcutor) enhancer.create();
        int a = myCalcutor.add(1, 1);
        System.out.println(a);
    }

}
