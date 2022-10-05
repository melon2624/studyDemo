package com.zx.desgin.strategy;

/**
 * @author zhangxin
 * @date 2022/6/30 11:02
 */
public class Price {

    /**
     * 持有一个具体的策略
     */
    private Strategy strategy = null;

    /**
     * 构造方法传入一个具体的策略对象
     * @param strategy
     */
    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double goodsPrice) {
        return this.strategy.calcPrice(goodsPrice);
    }

}
