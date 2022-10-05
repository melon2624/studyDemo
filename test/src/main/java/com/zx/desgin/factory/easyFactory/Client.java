package com.zx.desgin.factory.easyFactory;

/**
 * @author zhangxin
 * @date 2022/7/26 14:18
 */
public class Client {


    public static void main(String[] args) {
        Api api= Factory.createApi(1);

        api.operation("zzzzz");
    }


}
