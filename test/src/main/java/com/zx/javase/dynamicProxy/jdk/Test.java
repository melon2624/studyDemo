package com.zx.javase.dynamicProxy.jdk;

/**
 * @author zhangxin
 * @date 2022-02-19 20:09
 */
public class Test {


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Calcutor proxy = CalcutorProxy.getProxy(new MyCalcutor());
        int a = proxy.add(4, 6);
        int b=proxy.mult(4,6);
        System.out.println(b);
        System.out.println(proxy.getClass());
        System.out.println(a);

    }

}
