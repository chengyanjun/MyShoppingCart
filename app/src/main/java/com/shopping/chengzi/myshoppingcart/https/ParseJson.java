package com.shopping.chengzi.myshoppingcart.https;

import android.content.Context;

import com.shopping.chengzi.myshoppingcart.utils.SPUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;

import org.json.JSONObject;

/**
 * Created by chengzi on 2017/3/16.
 */

public class ParseJson {

    private String str;

    public ParseJson(String str) {
        this.str = str;
    }

    //解析状态值
    public static boolean parseStatus(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getInt("code") == 200 && object.getString("datas").equals("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //解析datas值
    public static boolean parseCode(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString("code") == "200" ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //登陆
    public static boolean parseLogin(Context context, String json) {
        try {
            JSONObject object = new JSONObject(json);
            JSONObject datas = object.getJSONObject("datas");
            String userName = datas.getString("username");
            String key = datas.getString("key");
            SPUtil.put(context, Url.USER_KEY, key);
            SPUtil.put(context, Url.USER_ID, userName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
