package com.zx.desgin.factory.easyFactory;

/**
 * 某个接口(通用的、抽象的、非具体的功能)
 * 接口的定义,该接口可以通过简单工厂来创建
 * @author zhangxin
 * @date 2022/7/26 13:38
 */
public interface Api {

    /**
     * 示意,具体功能方法的定义
     * @param s
     */
    public  void  operation(String s);

}
