package com.zx.javase.dynamicProxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangxin
 * @date 2022-02-19 20:34
 */
public class MyCglib implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("zhangxin6666");
        Object o1=methodProxy.invokeSuper(o,objects);

        return o1;

    }
}
