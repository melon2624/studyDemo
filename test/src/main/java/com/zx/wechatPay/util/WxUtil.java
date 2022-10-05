package com.zx.wechatPay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zhangxin
 * @date 2022/7/27 8:56
 */
public class WxUtil {

    public static Logger logger = LoggerFactory.getLogger(WxUtil.class);

    /**
     * 统一下单接口地址
     */

    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 微信支付：统一下单
     *
     * @return
     * @throws
     * @throws IOException
     */
    public static String unifiedOrder(String xmlStr) {
        if(xmlStr==null||xmlStr.trim().isEmpty()){
            throw new RuntimeException("xml字符串为空");
        }
        String xmlResult = null;
        try {
            String url = UNIFIEDORDER_URL;
            logger.info("统一下单:"+xmlStr);
            xmlResult = HttpUtil.doXmlPost(url, xmlStr);
            logger.info("统一下单返回："+xmlResult);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return xmlResult;
    }


    /**
     * 返回
     * <xml>
     *   <return_code><![CDATA[SUCCESS]]></return_code>
     *   <return_msg><![CDATA[OK]]></return_msg>
     * </xml>
     * 这样的xml格式
     * @param returnCode
     * @param returnMsg
     * @return
     */
    public static String getXmlWithRetCodeAndMsg(String returnCode,String returnMsg){
        return "<xml><return_code><![CDATA["+returnCode+"]]></return_code><return_msg><![CDATA["+returnMsg+"]]></return_msg></xml>";
    }
}
