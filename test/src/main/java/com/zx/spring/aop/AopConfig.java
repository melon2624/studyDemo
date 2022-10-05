package com.zx.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author : zhangxin
 * @date : 2021-09-17 15:20
 **/
@Aspect
@Configuration
public class AopConfig {

    /**
     *
     */
    @Pointcut("execution(* com.zx.spring.aop.TestAopController.*(..))")
    public void execute() {

    }

    /**
     * 切点executeAdvice()的前置增强方法
     *
     * @param joinPoint
     */
    @Before(value = "execute()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Object[] paramArray = joinPoint.getArgs();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "->beforeAdvice获取到了被增强方法的参数，为：" + Arrays.toString(paramArray));

    }

    /**
     * 切点executeAdvice()的后增强方法
     */
    @After(value = "execute()")
    public void afterAdvice() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "->后置增强afterAdvide执行了");

    }

    @AfterReturning(value = "execute()", returning = "zx")
    public void afterReturnAdvice(String zx) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "afterReturnAdvice获得了返回结果 zhangxin->" + zx);
    }

    @AfterThrowing(value = "execute()", throwing = "e")
    public void afterThrowing(Exception e) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "->afterThrowing捕获到了-->" + e);

    }

    @Around(value = "execute()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + "->环绕增强aroundAdvice--> before proceed执行了");
        // 执行被增强方法，并获取到返回值
        // 类似于 过滤器的chain.doFilter(req,resp)方法
        Object obj = proceedingJoinPoint.proceed();
        System.out.println(threadName + "->环绕增强aroundAdvice --> after proceed()执行了");

    }


}
