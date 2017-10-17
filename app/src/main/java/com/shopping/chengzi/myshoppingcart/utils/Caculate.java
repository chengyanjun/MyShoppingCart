package com.shopping.chengzi.myshoppingcart.utils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2015/10/16.
 *
 * 加减乘除
 */
public class Caculate {

    public static String addStr(String one, String two){
        BigDecimal bigDecimal = new BigDecimal(one);
        return bigDecimal.add(new BigDecimal(two)).toString();
    }

    public static String subStr(String one, String two){
        BigDecimal bigDecimal = new BigDecimal(one);
        return bigDecimal.subtract(new BigDecimal(two)).toString();
    }

    public static String multiply(String one, String two){
        BigDecimal bigDecimal = new BigDecimal(one);
        return bigDecimal.multiply(new BigDecimal(two)).toString();
    }

    public static String divide(String one, String two){
        BigDecimal bigDecimal = new BigDecimal(one);
        return bigDecimal.divide(new BigDecimal(two)).toString();
    }

}
