package com.zx.desgin.strategy;

/**
 * @author zhangxin
 * @date 2022/6/30 10:59
 */
public class OldCustomerStrategy implements Strategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于老客户，统一折扣5%");
        return goodsPrice*(1-0.05);
    }
}
