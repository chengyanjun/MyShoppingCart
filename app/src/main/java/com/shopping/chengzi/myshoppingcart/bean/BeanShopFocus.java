package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/31.
 */

public class BeanShopFocus {


    /**
     * code : 200
     * hasmore : false
     * page_total : 1
     * datas : {"favorites_list":[{"store_id":"2","store_name":"官方自营店铺","fav_time":"1490940161","fav_time_text":"2017-03-31 14:02","goods_count":"38","store_collect":"6","store_label":"05268610934940592.jpg","store_avatar_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/05268610934940592.jpg"},{"store_id":"25","store_name":"一壶美酒，甲天下","fav_time":"1481514233","fav_time_text":"2016-12-12 11:43","goods_count":"30","store_collect":"8","store_label":"05284632690234439.gif","store_avatar_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/05284632690234439.gif"}]}
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
             * store_id : 2
             * store_name : 官方自营店铺
             * fav_time : 1490940161
             * fav_time_text : 2017-03-31 14:02
             * goods_count : 38
             * store_collect : 6
             * store_label : 05268610934940592.jpg
             * store_avatar_url : http://123.56.203.196/bbcmall/data/upload/shop/store/05268610934940592.jpg
             */

            private String store_id;
            private String store_name;
            private String fav_time;
            private String fav_time_text;
            private String goods_count;
            private String store_collect;
            private String store_label;
            private String store_avatar_url;

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getFav_time() {
                return fav_time;
            }

            public void setFav_time(String fav_time) {
                this.fav_time = fav_time;
            }

            public String getFav_time_text() {
                return fav_time_text;
            }

            public void setFav_time_text(String fav_time_text) {
                this.fav_time_text = fav_time_text;
            }

            public String getGoods_count() {
                return goods_count;
            }

            public void setGoods_count(String goods_count) {
                this.goods_count = goods_count;
            }

            public String getStore_collect() {
                return store_collect;
            }

            public void setStore_collect(String store_collect) {
                this.store_collect = store_collect;
            }

            public String getStore_label() {
                return store_label;
            }

            public void setStore_label(String store_label) {
                this.store_label = store_label;
            }

            public String getStore_avatar_url() {
                return store_avatar_url;
            }

            public void setStore_avatar_url(String store_avatar_url) {
                this.store_avatar_url = store_avatar_url;
            }
        }
    }
}
