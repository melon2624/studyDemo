package com.zx.wechatPay.dto;

import lombok.Data;

/**
 * JSAPI微信支付：统一下单
 */
@Data
public class WxPayJsApiUnifiedOrderDto /*extends BaseDto*/{
    private WxPayJsApiUnifiedOrder data = new WxPayJsApiUnifiedOrder();
    private Integer wxId;//微信公众id
    private Integer userId;//用户id
    private Integer clientId;//机构id
}
