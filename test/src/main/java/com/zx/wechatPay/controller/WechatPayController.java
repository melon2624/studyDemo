package com.zx.wechatPay.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.zx.wechatPay.dto.*;
import com.zx.wechatPay.enums.ResultEnum;
import com.zx.wechatPay.exception.PayException;
import com.zx.wechatPay.util.*;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import net.sf.json.xml.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhangxin
 * @date 2022/7/27 8:33
 */
@RestController
@RequestMapping("/wx")
@Slf4j
public class WechatPayController {

    private Gson gson = new Gson();

    Logger logger = LoggerFactory.getLogger(WechatPayController.class);


    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/pay")
    public WxPayJsApiUnifiedOrderResultVo pay() {

        String secret="zVAgLz1zsWLzRJ2CLD1R2FMCZKeQQFKm";

        WxPayJsApiUnifiedOrderDto wxUnifiedOrderDto = new WxPayJsApiUnifiedOrderDto();

        WxPayJsApiUnifiedOrder wxUnifiedOrder = new WxPayJsApiUnifiedOrder();
        wxUnifiedOrder.setTotal_fee(20);
        String outTradeNo = "wx" + 2 + 1 + System.currentTimeMillis() + Util.getRandomString(5);
        wxUnifiedOrder.setOut_trade_no(outTradeNo);
        wxUnifiedOrder.setOpenid("oAJqrwPVUwBhPdLcHryTUZ_qksoE");//  openid
        wxUnifiedOrder.setAppid("wxf4d2433e9d33f01f");
        wxUnifiedOrder.setMch_id("1628631340");
        String nonceStr = Util.getRandomString(20);
        wxUnifiedOrder.setNonce_str(nonceStr);//随机数
        wxUnifiedOrder.setFee_type("CNY");//标价币种 默认人民币：CNY
        wxUnifiedOrder.setBody("微信充值");

        String spbillCreateIp = Util.getLocalIp();

        wxUnifiedOrder.setSpbill_create_ip(spbillCreateIp);

        String notifyUrl = "http://5029o6k186.xicp.fun:47594/wx/notify";

        wxUnifiedOrder.setNotify_url(notifyUrl);
        wxUnifiedOrder.setTrade_type("JSAPI");
        String openId="oHmdJ5tFFyF72W_J4hatpzIEaiII";
        wxUnifiedOrder.setOpenid(openId);
        wxUnifiedOrder.setSign_type("MD5");

        // 签名
        Map<String, String> paramMap = new TreeMap<>();
        BeanConverUtil.toMap(wxUnifiedOrder, paramMap);// 参数名称按照字典顺序排序    值为空的参数不参与计算sign值
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String paramStr = sb.toString();
        paramStr = paramStr + "key=" + secret;
        String sign = Md5Util.md5Digest(paramStr);
        paramMap.put("sign", sign);
        String xmlStr = XmlUtil.getXmlFromMap(paramMap);
        logger.info("微信统一下单 xml字报文为：" + xmlStr);

        String xmlResult = WxUtil.unifiedOrder(xmlStr);
        if (xmlResult == null || xmlResult.isEmpty()) {
            throw new RuntimeException("微信JSAPI统一下单接口返回为空");
        }
        logger.info("微信统一下单 返回：" + JSONObject.toJSONString(xmlResult));

        logger.info("微信统一下单 返回：" + JSONObject.toJSONString(xmlResult));
        XMLSerializer xmlSerializer = new XMLSerializer();
        String jsonResult = xmlSerializer.read(xmlResult).toString();
        WxPayJsApiUnifiedOrderResult wxUnifiedOrderResult = gson.fromJson(jsonResult, WxPayJsApiUnifiedOrderResult.class);
        String returnCode =  wxUnifiedOrderResult.getReturn_code();

        if(returnCode.equalsIgnoreCase("FAIL")){
            String returnMsg =  wxUnifiedOrderResult.getReturn_msg();
            throw new RuntimeException("微信JSAPI统一下单接口返回状态码为错误:"+ returnMsg);
        }
        String resultCode = wxUnifiedOrderResult.getResult_code();
        if(resultCode.equalsIgnoreCase("FAIL")){
            throw new RuntimeException("微信JSAPI统一下单接口返回结果码状态错误:"+ wxUnifiedOrderResult.getErr_code_des());
        }

        // 如果有必要，还可以对微信返回的结果进行签名校验
        // 至此  成功
        // 接下来做业务逻辑处理
        // 最后返回 wxUnifiedOrderResultVo  供前端JSAPI调用 getBrandWCPayRequest进行支付
        WxPayJsApiUnifiedOrderResultVo wxUnifiedOrderResultVo = new WxPayJsApiUnifiedOrderResultVo();
        wxUnifiedOrderResultVo.setAppId("wxf4d2433e9d33f01f");

        String timeStamp = System.currentTimeMillis()/1000+"";
        wxUnifiedOrderResultVo.setTimeStamp(timeStamp);

        String nonceStr_ = Util.getRandomString(20);// 随机字符串
        wxUnifiedOrderResultVo.setNonceStr(nonceStr_);

        String package_ = "prepay_id="+wxUnifiedOrderResult.getPrepay_id();// 订单详情扩展字符串 统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
        wxUnifiedOrderResultVo.setPackage_(package_);

        String signType_ = "MD5";
        wxUnifiedOrderResultVo.setSignType(signType_);

        String paySign = null;//签名  参与签名的参数为：appId、timeStamp、nonceStr、package、signType，参数区分大小写
        Map<String,String> paramMap2 = new TreeMap<>();

        BeanConverUtil.toMap(wxUnifiedOrderResultVo,paramMap2);// 参数名称按照字典顺序排序    值为空的参数不参与计算sign值
        paramMap2.remove("package_");// 参与签名的参数名称是package，不是package_  但是package时java的保留参数，所以...
        paramMap2.put("package",package_);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String,String> entry : paramMap2.entrySet()) {
            sb2.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String paramStr2 = sb2.toString();
        paramStr2 = paramStr2+"key="+secret;
        paySign = Md5Util.md5Digest(paramStr2);
        wxUnifiedOrderResultVo.setPaySign(paySign);
        return wxUnifiedOrderResultVo;


    }


    /**
     * 微信JSAPI支付回调
     * @return
     * 因为是响应给微信的，所以不允许抛出异常了，不论成功或者失败，都要有响应
     */
    @RequestMapping("/payNotify")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) {
        logger.info("微信JSAPI支付回调了");
        String returnCode = "FAIL";
        String returnMsg = "FAIL";
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/xml;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            InputStream in = request.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            String xmlStr = new String(out.toByteArray(), "utf-8");//xml数据
            XMLSerializer xmlSerializer = new XMLSerializer();
            String jsonStr = xmlSerializer.read(xmlStr).toString();
            logger.info("微信JSAPI支付回调接口的请求参数:" + jsonStr);
            WxPayJsApiNotify wxPayNotify = gson.fromJson(jsonStr, WxPayJsApiNotify.class);
           // wxPayJsApiNotifyService.payNotify(wxPayNotify);
            returnCode = "SUCCESS";
            returnMsg = "OK";
        }catch (Exception e){
            logger.error("微信JSAPI支付回调接口,异常："+e.getMessage()+e.getCause());
            logger.error("微信JSAPI支付回调接口,异常：",e);
            returnCode = "FAIL";
            returnMsg = "微信JSAPI支付回调接口,异常："+e.getMessage()+e.getCause();
            e.printStackTrace();
        }finally {
            try {
                String xmlResult = WxUtil.getXmlWithRetCodeAndMsg(returnCode, returnMsg);
                logger.info("微信JSAPI支付回调接口,返回："+xmlResult);
                response.getWriter().write(xmlResult);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1. 配置
        //2. 调用方法
        String url = "http://9rcmba.natappfree.cc/wx/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        log.info("[微信网页授权]获取code,result={}", redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new PayException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId=wxMpOAuth2AccessToken.getOpenId();
        System.out.println(openId);
        return "redirect:" + returnUrl + "?openid=" + openId;

    }

}
