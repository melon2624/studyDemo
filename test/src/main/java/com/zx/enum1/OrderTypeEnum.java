package com.zx.enum1;

/**
 * @author zhangxin
 * @date 2022/10/15 13:39
 */
public enum OrderTypeEnum implements IDict {

    // 订单类型枚举
    NORMAL(1, "普通订单"),
    FREE(2, "免费订单"),
    SECKILL(3, "秒杀订单"),
    VIRTUAL(4, "虚拟商品订单"),
    ;

    OrderTypeEnum(Integer code, String text) {
            init(code,text);
    }


}
