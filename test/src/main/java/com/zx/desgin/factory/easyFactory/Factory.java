package com.zx.desgin.factory.easyFactory;

/**
 * @author zhangxin
 * @date 2022/7/26 13:55
 */
public class Factory {

    public static Api createApi(Integer condition) {

        //应该根据某些条件去选择究竟创建哪一个具体的实现对象,
        //这些条件可以从外部传入,也可以从其他途径来获取。
        //如果只有一个实现,可以省略条件,因为没有选择的必要。
        // 示意使用条件
        Api api = null;
        if (condition == 1) {
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }
        return api;
    }

}
