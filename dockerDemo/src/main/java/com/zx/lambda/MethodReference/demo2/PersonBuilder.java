package com.zx.lambda.MethodReference.demo2;

/**
 * @author zhangxin
 * @date 2022/12/21 18:29
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个方法,根据传递的姓名,创建Person对象返回
    Person builderPerson(String name);
}
