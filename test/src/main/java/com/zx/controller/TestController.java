package com.zx.controller;

import com.zx.Annotation.MyAnnotation;
import com.zx.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    public String a = "com/zx";

    @Autowired
    RedisUtils redisUtils;


    @Value("${spring.redis.host}")
    String aaa;

    @RequestMapping("/zx/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {

        String code = request.getParameter("code");
        String cmd = request.getParameter("cmd");//区分不同的业务
        String wxid = request.getParameter("wxid");//微信id  用来区分不同公众号
        String clientId = request.getParameter("clientId");//机构id

        Map<String, String[]> map = request.getParameterMap();

        HashMap<String, String> map1 = new HashMap<>();

        for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
            String key = stringEntry.getKey();
            String[] values = stringEntry.getValue();
            String value = "";
            for (String s : values) {
                value = value + s;
            }
            map1.put(key, value);
        }
        map1.remove("code");
        map1.remove("cmd");
        map1.remove("state");

        String callUrl = "192.168.1.148";
        String appPort = "8080";

        callUrl = callUrl + ":" + appPort + "/#/?wxid=" + wxid;
        for (Map.Entry<String,String> entry : map1.entrySet()) {
            callUrl = callUrl + "&" + entry.getKey() + "=" + entry.getValue().toString();
        }

        System.out.println(callUrl);

       /* User user = new User();
        user.setId(1);
        user.setName("zhangxin");
        String userEntityJson = JSONObject.toJSONString(user);
        redisUtils.setString("zx", userEntityJson);*/
        return callUrl  ;
    }

    @RequestMapping("/zhangxin")
    @MyAnnotation(value = "zhangxinaopppppppp")
    public  void  aopTest(HttpServletRequest request, HttpServletResponse response){
        redisUtils.setString("zzz","hhhhhh");
        System.out.println(aaa);
        System.out.printf("-------------");
    }

}
