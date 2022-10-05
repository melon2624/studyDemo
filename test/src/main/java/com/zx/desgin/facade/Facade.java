package com.zx.desgin.facade;

/**
 * @author zhangxin
 * @date 2022/8/5 10:51
 */
public class Facade {

    private Facade() {

    }

    public static void test() {
        AModuleApi a = new AModuleApi();
        a.test();
        BmoduleApi b = new BmoduleApi();
        b.test();
        CModuleApi c = new CModuleApi();
        c.test();
    }

}
