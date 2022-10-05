package com.zx.wechatPay.dto;

import lombok.Data;

/**
 * JSAPI微信  统一下单接口对应的实体bean
 */
@Data
public class WxPayJsApiUnifiedOrder {
    private String appid;//微信支付分配的公众账号ID
    private String mch_id;//微信支付分配的商户号
    private String device_info;//自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
    private String nonce_str;//随机字符串，长度要求在32位以内。
    private String sign;//通过签名算法计算得出的签名值
    private String sign_type = "MD5";//签名类型，默认为MD5，支持HMAC-SHA256和MD5。
    private String body;//商品描述
    private String detail;//商品详情
    private String attach;//附加数据
    private String out_trade_no	;//商户订单号
    private String fee_type = "CNY";//标价币种 默认人民币：CNY
    private int total_fee;//订单总金额，单位为分
    private String spbill_create_ip;//终端IP
    private String time_start;//交易起始时间  订单生成时间，格式为yyyyMMddHHmmss
    private String time_expire;//交易结束时间
    private String goods_tag;//订单优惠标记
    private String notify_url;//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
    private String trade_type;//交易类型  JSAPI -JSAPI支付 NATIVE -Native支付 APP -APP支付
    private String product_id;//商品ID  trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    private String limit_pay;//指定支付方式 上传此参数no_credit--可限制用户不能使用信用卡支付
    private String openid;//用户标识  trade_type=JSAPI时（即JSAPI支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。
    private String receipt;//电子发票入口开放标识  传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
   // private WxPayJsApiUnifiedOrderSceneInfo scene_info;//该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。该字段为JSON对象数据
}
