package com.zx.desgin.factory.build.example4;

import lombok.val;

/**
 * @author zhangxin
 * @date 2022/8/29 17:59
 */
public class Client {


    public static void main(String[] args) {
        //创建构造器
        ConcreteBuilder builder = new ConcreteBuilder("001", 12345L, 67890L);
        //设置需要的数据，然后构建保险合同对象
        InsuranceContract contract = builder.setPersonName("zhangsan").setOtherData("test").build();
        //操作保险合同对象的方法
        contract.someOperation();
    }

}
