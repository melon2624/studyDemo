package com.zx.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zx.entity.HongGuanDto;
import com.zx.entity.HgBean;
import com.zx.entity.Tbuser;
import com.zx.mapper.TbuserMapper;
import com.zx.service.TbuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/5/5 10:33
 */
@RestController
public class TestController {

    @Autowired
    TbuserService tbuserService;

    @Autowired
    TbuserMapper tbuserMapper;

    @Resource
    private TaskExecutor taskExecutor;

    @PostMapping("/zhangxin")
    public String test() {
        LambdaQueryWrapper<Tbuser> tbuserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Tbuser> tbusers = tbuserService.list(tbuserLambdaQueryWrapper);
        System.out.printf("zhangxinxinxinxinxinxinxinxinxin");
        return "zhangxin";

    }

    @PostMapping("/test")
    public void test1() {

        String path = "C:\\zx\\a.txt";
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件
            int i = 0;
            HashMap<String, String> map = new HashMap();
            String s = null;
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> listList = new ArrayList<>();
            int j = 0;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                j++;
                if (i != 100) {
                    list.add(Integer.valueOf(s));
                    i++;
                } else {
                    if (j<=5800){
                        Integer test = tbuserMapper.test(list);
                        if (test != 100) {
                            listList.add(list);
                        }
                        list = new ArrayList<>();
                        i = 0;
                    }else {
                        Integer test = tbuserMapper.test(list);

                    }
                }
          /*    //  result.append(s+",");
                Integer test = tbuserMapper.test(Integer.parseInt(s));
                if (!ObjectUtil.isNotEmpty(test)){
                    map.put(s,s);
                }*/
                //  map.put(s,s);
            }
            br.close();
          /*  HashMap<String,String> map1=new HashMap<>();
            for (Map.Entry<String,String> entry:map.entrySet()) {
                taskExecutor.execute(() -> {
                    // 人员总数
                    try {
                        Integer test = tbuserMapper.test(Integer.parseInt(entry.getKey()));
                        if (!ObjectUtil.isNotEmpty(test)){
                            map1.put(entry.getKey(),entry.getValue());
                        }
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                });
            }*/
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/getSiAndPa")
    public JSONObject test(@RequestBody HgBean json) {

        String s = JSONUtil.toJsonStr(json);

        String si = Md5EncryptionUtils.getMd5(s);
        String aes = encrypt("9C345E37DF2240C084FCD8B4AF60E726", s);
        String ba64 = Base64Util.encode(aes);

        HongGuanDto hongGuanDto = new HongGuanDto();
        hongGuanDto.setSi(si);
        hongGuanDto.setPa(ba64);
        //----------------------------------------------------------------------------------
        String decodePa = decrypt("9C345E37DF2240C084FCD8B4AF60E726", Base64Util.decode(hongGuanDto.getPa()));

        //  System.out.printf(decodePa);
        JSONObject jsonObject = JSONObject.parseObject(decodePa);
        return jsonObject;
    }

    public static String encrypt(String key, String text) {
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //加密
        return aes.encryptHex(text);
    }

    public static String decrypt(String key, String text) {
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //加密
        return aes.decryptStr(text);
    }


}
