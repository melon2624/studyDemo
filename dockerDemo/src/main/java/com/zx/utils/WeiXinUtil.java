package com.zx.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;

/**
 * @author zhangxin
 * @date 2023/1/11 11:08
 */
public class WeiXinUtil {

    //获取临时素材url
    public static String getTempMaterial_url = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    public static void getTempMaterial(String accessToken, String mediaId, String savePath)  throws UnsupportedEncodingException {

        //1.拼接请求url
        getTempMaterial_url=getTempMaterial_url.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);

        savePath=savePath+mediaId;
        //2.调用接口，发送请求，获取临时素材
        File file=null;
        try {
            file = getFile(getTempMaterial_url,savePath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("file:"+file.getName());
    }

    public static File getFile(String requestUrl,String savePath) throws Exception {
        //String path=System.getProperty("user.dir")+"/img//1.png";
        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        URL url = new URL(requestUrl);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
        httpUrlConn.setSSLSocketFactory(ssf);

        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setUseCaches(false);
        // 设置请求方式（GET/POST）
        httpUrlConn.setRequestMethod("GET");
        httpUrlConn.connect();
        //获取文件扩展名
        String ext=getExt(httpUrlConn.getContentType());
        savePath=savePath+ext;
        System.out.println("savePath"+savePath);
        //下载文件到f文件
        File file = new File(savePath);
        // 获取微信返回的输入流
        InputStream in = httpUrlConn.getInputStream();
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

        int len;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) != -1) {
            byteArrayOut.write(buffer, 0, len);
        }
        InputStream newFile = new ByteArrayInputStream(byteArrayOut.toByteArray());
        //输出流，将微信返回的输入流内容写到文件中
        FileOutputStream out = new FileOutputStream(file);
        int length=1024;
        byte[] byteBuffer = new byte[length]; //存储文件内容
        int byteread =0;

        while (( byteread=newFile.read(byteBuffer)) != -1) {
            out.write(byteBuffer,0,byteread);
            out.flush();
        }

        if (in != null) {
            in.close();
        }

        // 释放资源
        out.close();
        in = null;
        out=null;

        httpUrlConn.disconnect();

        return file;
    }

    private static String getExt(String contentType){
        if("image/jpeg".equals(contentType)){
            return ".jpg";
        }else if("image/png".equals(contentType)){
            return ".png";
        }else if("image/gif".equals(contentType)){
            return ".gif";
        }
        return null;
    }

    public static void doTis() throws UnsupportedEncodingException {

        String accestaken="J5EqzWrMfKqdqn0DT49Z5ir4ADnmhWBzUDk3_iEjYsFEfNf60Zfh0oc2EkU1YUrkY8yHBguXwLOUsPIRQIG4yXPgqTJVI7zlCDo90VB7wldBYe0lvw1flR4Sx3OY5SGy8EB4zCIcOiusgMlrYvV59MF-V7GTlLJpY7Byaqrsn-fFoclfGDSHGzv3FQ7MKG2yJUbUj-v2ObTOgYlAsTmz-g";
        String  mediaId="3wWb7XtbKXztZYqq2BQB4UxXzc__I7qOTytK5Lfk66X2fhLyhc8GQSOLX67w1V7RY";

        String mediaId1="3XFNMpn59a301y92JfLMajICQJUoRuIcAKsdV6ge9EMJqP46MQfjmQgo_sTErpfbB";

       // String path = "/home/uploadImg/";
        String path = "C:/12525/3/";
        try {
            getTempMaterial(accestaken,mediaId,path);
            getTempMaterial(accestaken,mediaId1,path);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
