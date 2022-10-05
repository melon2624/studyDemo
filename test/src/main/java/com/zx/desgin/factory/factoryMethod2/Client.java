package com.zx.desgin.factory.factoryMethod2;

/**
 * @author zhangxin
 * @date 2022/8/22 20:21
 */
public class Client {

    public static void main(String[] args) {
        ExportOperate operate = new ExportOperate2();
        operate.export(1,"zxxxxx");
        operate.export(2,"zxxxxx");
        operate.export(3,"zxxxxx");
    }

}
