package com.shopping.chengzi.myshoppingcart.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by yuanfeng on 2016/12/15.
 */

public class ScreenUtil {

    public static int WIDTH_SCREEN;
    public static int HEIGHT_SCREEN;

    public ScreenUtil() {
         /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获得屏幕宽度
     * @param context
     * @return
     */
    public static int getWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        WIDTH_SCREEN=displayMetrics.widthPixels;
        return WIDTH_SCREEN;
    }

    /**
     * 获得屏幕高度
     * @param context
     * @return
     */
    public static int getHeight(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        HEIGHT_SCREEN=displayMetrics.heightPixels;
        return HEIGHT_SCREEN;
    }

    /**
     * 获取屏幕宽高
     * @param context
     */
    public static void initiScreenParam(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        WIDTH_SCREEN = displayMetrics.widthPixels;
        HEIGHT_SCREEN=displayMetrics.heightPixels;
    }


    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
