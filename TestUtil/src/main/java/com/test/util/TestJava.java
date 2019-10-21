package com.test.util;

import com.alibaba.fastjson.JSONObject;

public class TestJava {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        long minTim_now = System.currentTimeMillis() / 60000;
        System.out.println("currentTime:" + currentTime + ",minTim_now:" + minTim_now);
        String param = "{'msgType':'shell'," +
                "      'method':'/home/edb/zyy/test.sh'," +
                "     'params':[" +
                "      {'param':'first'}," +
                "      {'param':'second'}," +
                "      {'param':'third'}]}";
        JSONObject paramJson = JSONObject.parseObject(param);
        System.out.println(paramJson.getString("msgType"));


    }
}
