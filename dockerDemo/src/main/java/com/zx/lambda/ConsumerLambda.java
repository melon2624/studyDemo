package com.zx.lambda;

import java.util.function.Consumer;

/**
 * @author zhangxin
 * @date 2022/12/21 10:38
 */
public class ConsumerLambda {


    public static void main(String[] args) {

      //  consumerString((s)-> System.out.println(s));

        consumerString(
                s-> System.out.println(s.toUpperCase()),
                s-> System.out.println(s.toLowerCase())

        );

    }


    static  void consumerString(Consumer<String> consumer){
        consumer.accept("hello");
    }


    static  void  consumerString(Consumer<String> first,Consumer<String> second){

        first.andThen(second).accept("hello");

    }




}
