package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/31.
 */

public class BeanGoodsFocus {


    /**
     * code : 200
     * hasmore : true
     * page_total : 2
     * datas : {"favorites_list":[{"goods_id":"100433","goods_name":"特级雷公山雪芽200g","goods_price":"330.00","goods_image":"30_05037746318645269.jpg","store_id":"30","fav_id":"100433","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/30/30_05037746318645269_240.jpg"},{"goods_id":"100434","goods_name":"特级礼盒清明茶300g","goods_price":"228.00","goods_image":"30_05037747505220092.jpg","store_id":"30","fav_id":"100434","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/30/30_05037747505220092_240.jpg"},{"goods_id":"100442","goods_name":"特级雷公山翠芽200g","goods_price":"480.00","goods_image":"30_05037754184521764.jpg","store_id":"30","fav_id":"100442","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/30/30_05037754184521764_240.jpg"},{"goods_id":"101034","goods_name":"fafasd","goods_price":"100.00","goods_image":"2_05319994975241395.jpg","store_id":"2","fav_id":"101034","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05319994975241395_240.jpg"},{"goods_id":"101035","goods_name":"fadsfdsf","goods_price":"100.00","goods_image":"2_05319994975241395.jpg","store_id":"2","fav_id":"101035","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05319994975241395_240.jpg"},{"goods_id":"101084","goods_name":"测试colorid","goods_price":"100.00","goods_image":"2_05320109850576109.jpg","store_id":"2","fav_id":"101084","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05320109850576109_240.jpg"},{"goods_id":"101086","goods_name":"测试图片显示问题 b 1 2","goods_price":"120.00","goods_image":"2_05324459016377515.jpg","store_id":"2","fav_id":"101086","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324459016377515_240.jpg"},{"goods_id":"101087","goods_name":"阳光萝莎牛仔衬衫女蓝色百搭收腰秋冬新款V领棉衬衣女秋打底修身 a 1 2","goods_price":"69.00","goods_image":"2_05324530117112520.jpg","store_id":"2","fav_id":"101087","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324530117112520_240.jpg"},{"goods_id":"101088","goods_name":"围巾女冬季披肩毛线针织情侣款男加厚秋冬天长款学生韩版韩国百搭 a 1 2","goods_price":"28.88","goods_image":"2_05324532466606253.jpg","store_id":"2","fav_id":"101088","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_240.jpg"},{"goods_id":"101089","goods_name":"雪纺打底衫蕾丝小衫 2016春秋装新款女装 长袖修身百搭娃娃领上衣 a 1 2","goods_price":"60.00","goods_image":"2_05324536391989808.jpg","store_id":"2","fav_id":"101089","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324536391989808_240.jpg"}]}
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
        private List<FavoritesListBean> favorites_list;

        public List<FavoritesListBean> getFavorites_list() {
            return favorites_list;
        }

        public void setFavorites_list(List<FavoritesListBean> favorites_list) {
            this.favorites_list = favorites_list;
        }

        public static class FavoritesListBean {
            /**
             * goods_id : 100433
             * goods_name : 特级雷公山雪芽200g
             * goods_price : 330.00
             * goods_image : 30_05037746318645269.jpg
             * store_id : 30
             * fav_id : 100433
             * goods_image_url : http://123.56.203.196/bbcmall/data/upload/shop/store/goods/30/30_05037746318645269_240.jpg
             */

            private String goods_id;
            private String goods_name;
            private String goods_price;
            private String goods_image;
            private String store_id;
            private String fav_id;
            private String goods_image_url;

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

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getFav_id() {
                return fav_id;
            }

            public void setFav_id(String fav_id) {
                this.fav_id = fav_id;
            }

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }
        }
    }
}
