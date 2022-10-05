package com.zx.wechatPay.dto;

import lombok.Data;

/**
 * JSAPI 统一下单返回结果
 */
@Data
public class WxPayJsApiUnifiedOrderResult {
    private String return_code;
    private String return_msg;
    private String appid;//公众账号ID
    private String mch_id;//商户号
    private String device_info;//设备号
    private String nonce_str;// 随机字符串
    private String sign;//微信返回的签名值
    private String result_code;//状态码 SUCCESS/FAIL
    private String err_code;//错误代码 当result_code为FAIL时返回错误代码：WxPayJsApiUnifiedOrderResultCodeEnum
    private String err_code_des;//错误代码描述

    //以下字段在return_code 和result_code都为SUCCESS的时候有返回
    private String trade_type;//交易类型 JSAPI -JSAPI支付 NATIVE -Native支付APP -APP支付
    private String prepay_id;//预支付交易会话标识	微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
    private String code_url;// 二维码链接  trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。 二维码url 的值并非固定，使用时按照URL格式转成二维码即可
}
