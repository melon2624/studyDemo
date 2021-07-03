package com.zx.java8;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zx.java8.service.MyFunctionInterface;
import com.zx.java8.service.OrderService;
import com.zx.java8.service.YouCanFunctionInterface;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author： zhangxin
 * @date： 2021-06-26 17:19
 */
public class Test02 {

    public static void main(String[] args) {
    /* OrderService orderService=   new OrderService() {
            @Override
            public void get() {
                System.out.println("get");
            }
        };
     orderService.get();*/


/*
        ((OrderService) () -> System.out.println("getzx")).get();
        new Thread(() -> System.out.println(Thread.currentThread().getName()+"run")).start();
     MyFunctionInterface myFunctionInterface=()->{
            System.out.println("test");
        };
     myFunctionInterface.test();*/


       /* YouCanFunctionInterface youcan=(a,b)->{
            return a+"--"+b;
        };
        System.out.println(youcan.test(1,2));
     String a=   new YouCanFunctionInterface() {
            @Override
            public String test(int i, int j) {
                Integer s = i + j;
                return s.toString();
            }
        }.test(1,2);
        System.out.println(a);*/


   /*   String str=  ((YouCanFunctionInterface)(a,b)-> a+"-"+b).test(2,3);
        System.out.println(str);
*/

        ArrayList<String> strings=new ArrayList<>();
        strings.add("zx");
        strings.add("zm");
        strings.add("jy");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        strings.forEach((s)->{
            System.out.println(s);
        });

    }




}
