package com.zx.desgin.factory.easyFactory;

/**
 * 接口的具体实现对象B
 * @author zhangxin
 * @date 2022/7/26 13:52
 */
public class ImplB  implements Api {
    @Override
    public void operation(String s) {
        //实现功能的代码,示意一下
        System.out.println("ImplB s=="+s);
    }
}
