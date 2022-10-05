package com.zx.wechatPay.dto;

import lombok.Data;

/**
 * JSAPI微信支付回调结果
 */
@Data
public class WxPayJsApiNotify {
    private String return_code;//	返回状态码 SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
    private String return_msg;// 返回信息 返回信息，如非空，为错误原因

    //以下字段在return_code为SUCCESS的时候有返回
    private String appid;//公众号id
    private String mch_id;// 商户号
    private String device_info;//设备号，
    private String nonce_str;// 随机字符串
    private String sign;// 签名
    private String sign_type;// 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
    private String result_code;// 业务结果		SUCCESS/FAIL
    private String err_code;// 错误代码 错误返回的信息描述
    private String err_code_des;// 错误代码描述	错误返回的信息描述
    private String openid;// 用户标识	  用户在商户appid下的唯一标识
    private String is_subscribe;// 用户是否关注公众账号，Y-关注，N-未关注
    private String trade_type;// 交易类型		JSAPI、NATIVE、APP
    private String bank_type;// 付款银行	采用字符串类型的银行标识，银行类型见开发文档银行列表
    private Integer total_fee;//	 订单金额	 订单总金额，单位为分
    private Integer settlement_total_fee;// 应结订单金额		应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
    private String fee_type;// 货币种类	CNY	货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private Integer cash_fee;// 现金支付金额	是	订单现金支付金额，详见支付金额
    private String cash_fee_type;// 现金支付货币类型 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private Integer coupon_fee;// 总代金券金额	代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额
    private Integer coupon_count;// 代金券使用数量
    private String coupon_type_$n;//该字段可能不会用到，不做细致处理 代金券类型 $n为下标 CASH--充值代金券 NO_CASH---非充值代金券 并且订单使用了免充值券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
    private String coupon_id_$n;//该字段可能不会用到，不做细致处理 代金券ID ,$n为下标，从0开始编号
    private Integer coupon_fee_$n;//该字段可能不会用到，不做细致处理 单个代金券支付金额,$n为下标，从0开始编号
    private String transaction_id;// 微信支付订单号
    private String out_trade_no;// 商户订单号		商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
    private String attach;// 商家数据包	商家数据包，原样返回
    private String time_end;// 支付完成时间，格式为yyyyMMddHHmmss

}
