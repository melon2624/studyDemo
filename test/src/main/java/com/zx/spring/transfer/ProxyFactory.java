package com.zx.spring.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : zhangxin
 * @date : 2021-09-15 17:47
 * 代理对象工厂：生成代理对象的
 **/

@Component
public class ProxyFactory {

    @Autowired
    private TransactionManager transactionManager;

   /* public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }*/


    public Object getJdkProxy(Object obj) {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object result;
                        try {
                            // 开启事务(关闭事务的自动提交)
                            transactionManager.beginTransaction();
                            result = method.invoke(obj, args);
                            // 提交事务
                            transactionManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 回滚事务
                            transactionManager.rollback();
                            // 抛出异常便于上层servlet捕获
                            throw e;
                        }

                        return result;
                    }
                }
        );

    }


    public Object getCglibProxy(Object object) {

        return null;
    }

}
