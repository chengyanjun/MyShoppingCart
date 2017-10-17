package com.shopping.chengzi.myshoppingcart.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by yuanfeng on 2016/12/16.
 */

public class JsonMessage {

    public JsonMessage() {
         /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int jsonStatus(String str) {
        JSONObject jsonObject = JSON.parseObject(str);
        int status = jsonObject.getInteger("code");
        return status;
    }

    public static String jsonMsg(String str) {
        JSONObject jsonObject = JSON.parseObject(str);
        String msgg = jsonObject.getString("error");
        return msgg;
    }

}
