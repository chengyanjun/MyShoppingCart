package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/13.
 */

public class BeanClassify {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"1","gc_name":"母婴儿童","type_id":"0","type_name":"口味、毫升","gc_parent_id":"0","commis_rate":"10","gc_sort":"0","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"05291564115675992_sm.jpg","is_mobile_display":"1","image":"http://123.56.203.196/bbcmall/data/upload/mobile/category/05286862803081526.jpeg","text":"奶粉/宝宝用品/童装童鞋/营养辅食/孕妈必备/纸尿裤/拉拉裤"},{"gc_id":"1120","gc_name":"美容彩妆","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"1","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"http://123.56.203.196/bbcmall/data/upload/mobile/category/05286853586202303.png","text":"茶叶/保健美容/土产干货"},{"gc_id":"1566","gc_name":"服饰鞋帽","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"2","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"茶叶/保健美容/酒水"},{"gc_id":"1575","gc_name":"家居生活","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"3","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"休闲食品"},{"gc_id":"1438","gc_name":"营养保健","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"4","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"保健美容/土产干货/熟食"},{"gc_id":"1576","gc_name":"海外直邮","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"5","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"休闲食品/海产品"},{"gc_id":"1338","gc_name":"数码家电","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"6","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"酒水/休闲食品/熟食/果蔬/土产干货/保健美容/饮料/粮油/茶叶/调味品"},{"gc_id":"3","gc_name":"环球美食","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"225","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"粮油/酒水/保健美容/土产干货/果蔬/茶叶/调味品/休闲食品/饮料/宿迁特产/淮安特产/连云港特产/熟食"},{"gc_id":"1574","gc_name":"运动户外","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"225","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"土产干货/粮油/果蔬/熟食/饮料/休闲食品/调味品/保健美容/茶叶/酒水"},{"gc_id":"1061","gc_name":"水果生鲜","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"252","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"休闲食品/调味品/粮油/酒水/饮料/保健美容/熟食/土产干货/果蔬/茶叶"},{"gc_id":"2","gc_name":"绿色生态","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"255","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"保健美容/果蔬/熟食/土产干货/饮料/酒水/粮油/茶叶/调味品/休闲食品"},{"gc_id":"256","gc_name":"米面杂粮","type_id":"0","type_name":"","gc_parent_id":"0","commis_rate":"10","gc_sort":"255","gc_virtual":"0","gc_title":"","gc_keywords":"","gc_description":"","gc_show":"1","gc_mobile_picture":"","is_mobile_display":"1","image":"","text":"茶叶/饮料/酒水/粮油/保健美容/调味品/果蔬/休闲食品/熟食/土产干货"}]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 1
             * gc_name : 母婴儿童
             * type_id : 0
             * type_name : 口味、毫升
             * gc_parent_id : 0
             * commis_rate : 10
             * gc_sort : 0
             * gc_virtual : 0
             * gc_title :
             * gc_keywords :
             * gc_description :
             * gc_show : 1
             * gc_mobile_picture : 05291564115675992_sm.jpg
             * is_mobile_display : 1
             * image : http://123.56.203.196/bbcmall/data/upload/mobile/category/05286862803081526.jpeg
             * text : 奶粉/宝宝用品/童装童鞋/营养辅食/孕妈必备/纸尿裤/拉拉裤
             */

            private String gc_id;
            private String gc_name;
            private String type_id;
            private String type_name;
            private String gc_parent_id;
            private String commis_rate;
            private String gc_sort;
            private String gc_virtual;
            private String gc_title;
            private String gc_keywords;
            private String gc_description;
            private String gc_show;
            private String gc_mobile_picture;
            private String is_mobile_display;
            private String image;
            private String text;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getGc_parent_id() {
                return gc_parent_id;
            }

            public void setGc_parent_id(String gc_parent_id) {
                this.gc_parent_id = gc_parent_id;
            }

            public String getCommis_rate() {
                return commis_rate;
            }

            public void setCommis_rate(String commis_rate) {
                this.commis_rate = commis_rate;
            }

            public String getGc_sort() {
                return gc_sort;
            }

            public void setGc_sort(String gc_sort) {
                this.gc_sort = gc_sort;
            }

            public String getGc_virtual() {
                return gc_virtual;
            }

            public void setGc_virtual(String gc_virtual) {
                this.gc_virtual = gc_virtual;
            }

            public String getGc_title() {
                return gc_title;
            }

            public void setGc_title(String gc_title) {
                this.gc_title = gc_title;
            }

            public String getGc_keywords() {
                return gc_keywords;
            }

            public void setGc_keywords(String gc_keywords) {
                this.gc_keywords = gc_keywords;
            }

            public String getGc_description() {
                return gc_description;
            }

            public void setGc_description(String gc_description) {
                this.gc_description = gc_description;
            }

            public String getGc_show() {
                return gc_show;
            }

            public void setGc_show(String gc_show) {
                this.gc_show = gc_show;
            }

            public String getGc_mobile_picture() {
                return gc_mobile_picture;
            }

            public void setGc_mobile_picture(String gc_mobile_picture) {
                this.gc_mobile_picture = gc_mobile_picture;
            }

            public String getIs_mobile_display() {
                return is_mobile_display;
            }

            public void setIs_mobile_display(String is_mobile_display) {
                this.is_mobile_display = is_mobile_display;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
