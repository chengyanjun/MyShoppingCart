package com.shopping.chengzi.myshoppingcart.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yuanfeng on 2016/12/15.
 */

public class ToastUtil {
    /**
     * Toast 统一管理类，参考鸿洋大神博客
     */
    public ToastUtil() {
          /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     * @param context
     * @param msg
     */
    public static void showShort(Context context,String msg){
        if (isShow){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间显示Toast
     * @param context
     * @param msg
     */
    public static void showLong(Context context,String msg){
        if (isShow){
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }


    /**
     * 自定义显示时间
     * @param context
     * @param msg
     * @param duration
     */
    public static void show(Context context,String msg,int duration){
        if (isShow){
            Toast.makeText(context, msg, duration).show();
        }
    }

}
