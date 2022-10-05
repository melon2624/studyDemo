package com.zx.javase.dynamicProxy.jdk;

/**
 * @author zhangxin
 * @date 2022-02-19 20:01
 */
public class MyCalcutor implements Calcutor {
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    public int mult(int i, int j) {
        int result = i * j;
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
