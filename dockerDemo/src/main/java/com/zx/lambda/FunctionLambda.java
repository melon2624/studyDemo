package com.zx.lambda;

import java.util.function.Function;

/**
 * @author zhangxin
 * @date 2022/12/21 13:47
 */
public class FunctionLambda {

    public static void main(String[] args) {

        method(s -> Integer.parseInt(s) + 10, i -> i = i * 10);

        String str = "张鑫,25";

        int age = getAgeNum(str, s -> s.split(",")[1], s -> Integer.parseInt(s), s -> s + 10);

        System.out.println(age);

    }

    static void method(Function<String, Integer> one, Function<Integer, Integer> two) {
        Integer num = one.andThen(two).apply("10");
        System.out.println(num);
    }

    static int getAgeNum(String str, Function<String, String> one, Function<String, Integer> two, Function<Integer, Integer> three) {

        return one.andThen(two).andThen(three).apply(str);
    }


}
