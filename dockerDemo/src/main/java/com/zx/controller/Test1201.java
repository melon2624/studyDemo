package com.zx.controller;


import org.json.JSONArray;
import org.json.JSONObject;

public class Test1201 {

    public static void main(String[] args) {
        JSONArray tableList = new JSONArray();
        JSONObject data = new JSONObject();
        data.put("zzz","aaa");
        tableList.put(data);
        JSONObject returnObject = new JSONObject();
        returnObject.put("tableData",tableList.toString());
        JSONArray data1 = new JSONArray((String) returnObject.get("tableData") );
        int  aaaaaa=data1.length();
        System.out.println(aaaaaa);

        //JSONArray jsonArray = returnObject.getJSONArray();

    }


}
