package com.zx.wechatPay.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class HttpUtil {

    /**
     * get请求
     *
     * @param url
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String doGet(String url) {
        CloseableHttpResponse response = null;
        String result = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000)
                    .build();
            httpGet.setConfig(requestConfig);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consume(entity);
        }catch (Exception e){
            log.error("HttpUtil doGet error ", e);
        } finally {
            try {
                response.close();
            }catch (Exception e2){
                log.error("HttpUtil doGet error ", e2);
            }
        }
        return result;
    }

    /**
     * POST请求
     *
     * @param url
     * @param outStr
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String doPost(String url, String outStr){
        CloseableHttpResponse response = null;
        String result = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            if(outStr!=null&&!outStr.isEmpty()){
                httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
            }
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            //消耗掉response
            EntityUtils.consume(entity);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                response.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return result;
    }


    /**
     * POST请求
     *
     * @param url
     * @param xmlStr
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String doXmlPost(String url, String xmlStr){
        CloseableHttpResponse response = null;
        String result = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            if(xmlStr!=null&&!xmlStr.isEmpty()){
                httpPost.setEntity(new StringEntity(xmlStr, ContentType.create("application/xml", Consts.UTF_8)));
            }
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            //消耗掉response
            EntityUtils.consume(entity);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                response.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return result;
    }
}
