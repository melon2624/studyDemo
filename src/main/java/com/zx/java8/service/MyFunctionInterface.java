package com.zx.java8.service;

/**
 * @author： zhangxin
 * @date： 2021-06-26 17:39
 */
@FunctionalInterface
public interface MyFunctionInterface {
    void test();

    default void add() {

    }

    String toString();
}
