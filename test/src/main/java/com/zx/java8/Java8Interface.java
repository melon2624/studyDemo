package com.zx.java8;

public interface Java8Interface {

    void add();

    default void getDefault() {
        System.out.println("default");
    }

    static void getStatic() {
        System.out.println("static");
    }
}
