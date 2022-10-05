package com.zx.desgin.strategy;

/**
 * @author zhangxin
 * @date 2022/6/30 11:01
 */
public class LargeCustomerStrategy implements Strategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于大客户，统一折扣10%");
        return goodsPrice*(1-0.1);
    }
}
