package com.shopping.chengzi.myshoppingcart.utils;

import android.content.Context;

/**
 * Created by chengzi on 2017/3/2.
 */

public class Url {

    public static final String HOST = "http://123.56.203.196/bbcmall/mobile/index.php?";
    //主页
    public static final String HOME_DATA = "app=index";

    //首页商品展示
    public static final String HOME_GOODS_LIST = "app=goods&mod=getRecGoods";
    //分类页
    public static final String CATEGORY = "app=goods_class";
    public static final String CATEGORY2 = "app=goods_class&gc_id=1";

    //登陆
    public static final String LOGIN = "app=login";
    //注册
    public static final String REGISTER = "app=login_mobile&mod=mobileregister";
    //注销
    public static final String LOGOUT = "app=logout";

    public static final String USER_KEY = "user_key";
    public static final String USER_ID = "user_id";

    public static final String GOODS_ID = "goods_id";

    //我的订单
    public static final String ALL_ORDER = "";
    public static final String WAIT_PAYMENT = "wait_pay";
    public static final String ALREADY_PAYMENT = "order_payed";
    public static final String WAIT_RECEIVE = "wait_confirm_goods";
    public static final String WAIT_EVALUATE = "finish";
    public static final String WAIT_RETURN_GOODS = "wait_return_goods";

    public static String getKey(Context context) {
        return (String) SPUtil.get(context, USER_KEY, "");
    }

    public static String getUserId(Context context) {
        return (String) SPUtil.get(context, USER_ID, "");
    }

    //屏幕尺寸信息
    public static int HEIGHT_SCREEN;
    public static int WIDTH_SCREEN;

    //主页底部购物车数据变化
    public static boolean NUM_MAIN_ACTIVITY_CART = false;

    //商品详情
    public static final String GOODS_DETAILS = "app=goods&mod=goods_detail&goods_id=101088";
    //关注的商品
    public static final String FOCUS_GOODS = "app=member_favorites&mod=favorites_list";
    //关注的店铺
    public static final String FOCUS_SHOP_STORE = "app=member_store_favorites&mod=flist";
}
