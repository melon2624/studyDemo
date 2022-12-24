package com.zx.lambda;

import java.util.function.Predicate;

/**
 * @author zhangxin
 * @date 2022/12/21 11:14
 */
public class PredicateLambda {

    public static void main(String[] args) {

        andMethod((s -> s.contains("W")),s->s.contains("h"));

        orMethod(s->s.contains("w"),s -> s.contains("h"));

        negateMethod(s -> s.length()<5);

    }

    static  void andMethod(Predicate<String> one,Predicate<String> two){

        boolean isValid=one.and(two).test("helloWorld");
        System.out.println("字符串符合要求吗："+isValid);

    }

    static void  orMethod(Predicate<String> one, Predicate<String> two){
        boolean isValid=one.or(two).test("helloWorld");
        System.out.println("字符串符合要求吗："+isValid);
    }

    static  void negateMethod(Predicate<String> predicate){
        boolean veryLong=predicate.negate().test("HelloWorld");
        System.out.println("字符串很长吗:"+veryLong);
    }



}
