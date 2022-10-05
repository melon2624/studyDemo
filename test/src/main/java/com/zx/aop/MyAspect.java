package com.zx.aop;

import com.zx.Annotation.MyAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhangxin
 * @date 2022/5/7 10:11
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("@annotation(com.zx.Annotation.MyAnnotation)")
    public void doAspect() {

    }

    @Before("doAspect()")
    public void doBefore(JoinPoint joinPoint){

        System.out.printf( joinPoint.getSignature().getName());
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        method.getAnnotation(MyAnnotation.class);
        System.out.printf("zhangxin aop");

    }


}
