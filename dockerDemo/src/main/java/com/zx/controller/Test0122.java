package com.zx.controller;

import java.util.HashMap;
import java.util.Map;

public class Test0122 {


    public static void main(String[] args) {

        HashMap<String,String> aaa=new HashMap<>();
        aaa.put("aaa",null);
        aaa.put("bbb","zhangxin");

        for (Map.Entry<String,String> entry:aaa.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }

    }

}


