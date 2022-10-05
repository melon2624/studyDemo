package com.zx.wechatPay.dto;

import lombok.Data;

/**
 * JSAPI维信支付：统一下单返回给前端的
 * 为了不将多余的WxUnifiedOrderResult信息返回给前端，所以新增该实体类
 * 用以对应统一下单的返回结果
 */
@Data
public class WxPayJsApiUnifiedOrderResultVo {
    private String appId;//公众号id
    private String timeStamp;//时间戳 自1970年1月1日 0点0分0秒以来的秒数
    private String nonceStr;// 随机字符串
    private String package_;// 订单详情扩展字符串 统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
    private String signType = "MD5";//签名类型，默认为MD5，支持HMAC-SHA256和MD5。注意此处需与统一下单的签名类型一致
    private String paySign;//签名  参与签名的参数为：appId、timeStamp、nonceStr、package、signType，参数区分大小写
}
