package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/8.
 */

public class BeanHomeGoodsList {


    /**
     * code : 200
     * hasmore : true
     * page_total : 10
     * datas : {"goods_list":[{"goods_id":"101091","goods_name":"MAYSU/美素精华瑰蜜露面部女保湿补水滋养精华补水保湿护肤品","goods_price":"300.00","goods_marketprice":"350.00","goods_image":"2_05341859410460622.jpg","goods_salenum":"1","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05341859410460622_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101090","goods_name":"蛟蓓项链女日韩甜美双层珍珠饰品百搭配饰短款简约锁骨链脖子颈链 a 1 2","goods_price":"90.00","goods_marketprice":"100.00","goods_image":"2_05324538544970273.jpg","goods_salenum":"6","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324538544970273_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101089","goods_name":"雪纺打底衫蕾丝小衫 2016春秋装新款女装 长袖修身百搭娃娃领上衣 a 1 2","goods_price":"60.00","goods_marketprice":"70.00","goods_image":"2_05324536391989808.jpg","goods_salenum":"8","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324536391989808_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101088","goods_name":"围巾女冬季披肩毛线针织情侣款男加厚秋冬天长款学生韩版韩国百搭 a 1 2","goods_price":"28.88","goods_marketprice":"98.00","goods_image":"2_05324532466606253.jpg","goods_salenum":"5","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101087","goods_name":"阳光萝莎牛仔衬衫女蓝色百搭收腰秋冬新款V领棉衬衣女秋打底修身 a 1 2","goods_price":"69.00","goods_marketprice":"130.00","goods_image":"2_05324530117112520.jpg","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324530117112520_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101086","goods_name":"测试图片显示问题 b 1 2","goods_price":"120.00","goods_marketprice":"150.00","goods_image":"2_05324459016377515.jpg","goods_salenum":"15","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324459016377515_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101085","goods_name":"测试图片显示问题 a 1 2","goods_price":"110.00","goods_marketprice":"150.00","goods_image":"2_05324458358025080.jpg","goods_salenum":"8","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324458358025080_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101084","goods_name":"测试colorid","goods_price":"100.00","goods_marketprice":"200.00","goods_image":"2_05320109850576109.jpg","goods_salenum":"2","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05320109850576109_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101035","goods_name":"fadsfdsf","goods_price":"100.00","goods_marketprice":"200.00","goods_image":"2_05319994975241395.jpg","goods_salenum":"1","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05319994975241395_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""},{"goods_id":"101034","goods_name":"fafasd","goods_price":"100.00","goods_marketprice":"200.00","goods_image":"2_05319994975241395.jpg","goods_salenum":"0","evaluation_good_star":"5","evaluation_count":"0","group_flag":false,"xianshi_flag":false,"goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05319994975241395_240.jpg","goods_rate":100,"store_id":"2","promotion_type":"","promotion_price":""}]}
     */

    private int code;
    private boolean hasmore;
    private int page_total;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<GoodsListBean> goods_list;

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            /**
             * goods_id : 101091
             * goods_name : MAYSU/美素精华瑰蜜露面部女保湿补水滋养精华补水保湿护肤品
             * goods_price : 300.00
             * goods_marketprice : 350.00
             * goods_image : 2_05341859410460622.jpg
             * goods_salenum : 1
             * evaluation_good_star : 5
             * evaluation_count : 0
             * group_flag : false
             * xianshi_flag : false
             * goods_image_url : http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05341859410460622_240.jpg
             * goods_rate : 100
             * store_id : 2
             * promotion_type :
             * promotion_price :
             */

            private String goods_id;
            private String goods_name;
            private String goods_price;
            private String goods_marketprice;
            private String goods_image;
            private String goods_salenum;
            private String evaluation_good_star;
            private String evaluation_count;
            private boolean group_flag;
            private boolean xianshi_flag;
            private String goods_image_url;
            private int goods_rate;
            private String store_id;
            private String promotion_type;
            private String promotion_price;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public String getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(String evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
            }

            public String getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(String evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public boolean isGroup_flag() {
                return group_flag;
            }

            public void setGroup_flag(boolean group_flag) {
                this.group_flag = group_flag;
            }

            public boolean isXianshi_flag() {
                return xianshi_flag;
            }

            public void setXianshi_flag(boolean xianshi_flag) {
                this.xianshi_flag = xianshi_flag;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }

            public int getGoods_rate() {
                return goods_rate;
            }

            public void setGoods_rate(int goods_rate) {
                this.goods_rate = goods_rate;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getPromotion_type() {
                return promotion_type;
            }

            public void setPromotion_type(String promotion_type) {
                this.promotion_type = promotion_type;
            }

            public String getPromotion_price() {
                return promotion_price;
            }

            public void setPromotion_price(String promotion_price) {
                this.promotion_price = promotion_price;
            }
        }
    }
}
