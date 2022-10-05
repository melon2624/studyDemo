package com.zx.desgin.strategy;

/**
 * @author zhangxin
 * @date 2022/6/30 10:42
 */
public class NormalCustomerStrategy implements Strategy {

    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于普通用户或者新客户，没有折扣");
        return goodsPrice;
    }
}
