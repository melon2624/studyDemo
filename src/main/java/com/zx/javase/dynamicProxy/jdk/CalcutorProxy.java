package com.zx.javase.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangxin
 * @date 2022-02-19 20:02
 */
public class CalcutorProxy {


    public static Calcutor getProxy(final Calcutor calcutor) {

        ClassLoader classLoader = calcutor.getClass().getClassLoader();
        Class<?>[] interfaces = calcutor.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object invoke = null;

                try {
                    System.out.println("张鑫666666");
                    invoke = method.invoke(calcutor, args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return invoke;
            }
        };

        Object o = Proxy.newProxyInstance(classLoader, interfaces, h);

        return (Calcutor) o;

    }

}
