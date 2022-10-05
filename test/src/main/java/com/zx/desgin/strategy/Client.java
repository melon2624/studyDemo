package com.zx.desgin.strategy;

/**
 * @author zhangxin
 * @date 2022/6/30 11:11
 */
public class Client {

    public static void main(String[] args) {
        //创建策略对象
        Strategy strategy = new LargeCustomerStrategy();

        //创建上下文
        Price price = new Price(strategy);
        //计算报价
        double quote = price.quote(1000);
        System.out.println("向客户报价：" + quote);

    }

}
