package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/21.
 */

public class BeanGoodsDetail {

    /**
     * code : 200
     * datas : {"goods_info":{"goods_commonid":"100584","goods_name":"围巾女冬季披肩毛线针织情侣款男加厚秋冬天长款学生韩版韩国百搭 a 1 2","goods_jingle":"冬季披肩毛线针织情侣款","gc_id_1":"0","gc_id_2":"0","gc_id_3":"0","store_id":"2","goods_specname":"","goods_price":"28.88","goods_marketprice":"98.00","goods_costprice":"20.00","goods_discount":"29","goods_serial":"131232","goods_storage_alarm":"0","transport_id":"0","transport_title":"","goods_freight":"0.00","goods_vat":"0","areaid_1":"0","areaid_2":"0","goods_stcids":",0,","plateid_top":"0","plateid_bottom":"0","goods_id":"101088","goods_promotion_price":"0.00","goods_promotion_type":"0","goods_click":"201","goods_salenum":"5","goods_collect":"0","goods_storage":"1106","color_id":"795","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","virtual_indate":"0","virtual_limit":"0","virtual_invalid_refund":"1","is_fcode":"0","is_appoint":"0","is_presell":"0","have_gift":"0","is_own_shop":"0","goods_rebate":"5","promotion_type":"","promotion_price":"","goods_url":"http://123.56.203.196/bbcmall/shop/index.php?app=goods&mod=index&goods_id=101088","qr_code":"http://123.56.203.196/bbcmall/data/upload/shop/store/2/101088.png","mobile_price":""},"spec_image":{"795":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_60.jpg"},"is_favorate":false,"cart_count":0,"goods_commend_list":[{"goods_id":"101025","goods_name":"手表的发生的 黑色 1 2","goods_price":"51.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05315847179011625_240.jpg"},{"goods_id":"101020","goods_name":"111 黄色 1 2","goods_price":"0.01","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05308807963426548_240.jpg"},{"goods_id":"100999","goods_name":"阿斯顿发士大夫 红色 1 2","goods_price":"100.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05034087419276480_240.jpg"},{"goods_id":"101086","goods_name":"测试图片显示问题 b 1 2","goods_price":"120.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324459016377515_240.jpg"},{"goods_id":"101014","goods_name":"aaa","goods_price":"50.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05308829883361993_240.jpg"},{"goods_id":"101085","goods_name":"测试图片显示问题 a 1 2","goods_price":"110.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324458358025080_240.jpg"}],"store_comment":{"store_credit":{"store_desccredit":{"text":"描述相符","credit":4},"store_servicecredit":{"text":"服务态度","credit":4},"store_deliverycredit":{"text":"发货速度","credit":4.8}},"store_credit_average":4.3,"store_credit_percent":86},"store_info":{"store_id":"2","store_name":"官方自营店铺","member_id":"2","address":"","store_qq":"1111111","store_ww":"1111","store_tel":"","store_phone":null,"member_name":"test01","avatar":"http://123.56.203.196/bbcmall/data/upload/shop/store/05268610934940592.jpg"},"goods_image":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532535872879_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532551485834_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532567982446_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532584557314_350.jpg","comment":[],"total_comment":{"good":"0","normal":"0","bad":"0","all":0,"good_percent":100,"normal_percent":0,"bad_percent":0,"good_star":5}}
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
        /**
         * goods_info : {"goods_commonid":"100584","goods_name":"围巾女冬季披肩毛线针织情侣款男加厚秋冬天长款学生韩版韩国百搭 a 1 2","goods_jingle":"冬季披肩毛线针织情侣款","gc_id_1":"0","gc_id_2":"0","gc_id_3":"0","store_id":"2","goods_specname":"","goods_price":"28.88","goods_marketprice":"98.00","goods_costprice":"20.00","goods_discount":"29","goods_serial":"131232","goods_storage_alarm":"0","transport_id":"0","transport_title":"","goods_freight":"0.00","goods_vat":"0","areaid_1":"0","areaid_2":"0","goods_stcids":",0,","plateid_top":"0","plateid_bottom":"0","goods_id":"101088","goods_promotion_price":"0.00","goods_promotion_type":"0","goods_click":"201","goods_salenum":"5","goods_collect":"0","goods_storage":"1106","color_id":"795","evaluation_good_star":"5","evaluation_count":"0","is_virtual":"0","virtual_indate":"0","virtual_limit":"0","virtual_invalid_refund":"1","is_fcode":"0","is_appoint":"0","is_presell":"0","have_gift":"0","is_own_shop":"0","goods_rebate":"5","promotion_type":"","promotion_price":"","goods_url":"http://123.56.203.196/bbcmall/shop/index.php?app=goods&mod=index&goods_id=101088","qr_code":"http://123.56.203.196/bbcmall/data/upload/shop/store/2/101088.png","mobile_price":""}
         * spec_image : {"795":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_60.jpg"}
         * is_favorate : false
         * cart_count : 0
         * goods_commend_list : [{"goods_id":"101025","goods_name":"手表的发生的 黑色 1 2","goods_price":"51.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05315847179011625_240.jpg"},{"goods_id":"101020","goods_name":"111 黄色 1 2","goods_price":"0.01","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05308807963426548_240.jpg"},{"goods_id":"100999","goods_name":"阿斯顿发士大夫 红色 1 2","goods_price":"100.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05034087419276480_240.jpg"},{"goods_id":"101086","goods_name":"测试图片显示问题 b 1 2","goods_price":"120.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324459016377515_240.jpg"},{"goods_id":"101014","goods_name":"aaa","goods_price":"50.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05308829883361993_240.jpg"},{"goods_id":"101085","goods_name":"测试图片显示问题 a 1 2","goods_price":"110.00","goods_image_url":"http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324458358025080_240.jpg"}]
         * store_comment : {"store_credit":{"store_desccredit":{"text":"描述相符","credit":4},"store_servicecredit":{"text":"服务态度","credit":4},"store_deliverycredit":{"text":"发货速度","credit":4.8}},"store_credit_average":4.3,"store_credit_percent":86}
         * store_info : {"store_id":"2","store_name":"官方自营店铺","member_id":"2","address":"","store_qq":"1111111","store_ww":"1111","store_tel":"","store_phone":null,"member_name":"test01","avatar":"http://123.56.203.196/bbcmall/data/upload/shop/store/05268610934940592.jpg"}
         * goods_image : http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532535872879_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532551485834_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532567982446_350.jpg,http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532584557314_350.jpg
         * comment : []
         * total_comment : {"good":"0","normal":"0","bad":"0","all":0,"good_percent":100,"normal_percent":0,"bad_percent":0,"good_star":5}
         */

        private GoodsInfoBean goods_info;
        private SpecImageBean spec_image;
        private boolean is_favorate;
        private int cart_count;
        private StoreCommentBean store_comment;
        private StoreInfoBean store_info;
        private String goods_image;
        private TotalCommentBean total_comment;
        private List<GoodsCommendListBean> goods_commend_list;
        private List<?> comment;

        public GoodsInfoBean getGoods_info() {
            return goods_info;
        }

        public void setGoods_info(GoodsInfoBean goods_info) {
            this.goods_info = goods_info;
        }

        public SpecImageBean getSpec_image() {
            return spec_image;
        }

        public void setSpec_image(SpecImageBean spec_image) {
            this.spec_image = spec_image;
        }

        public boolean isIs_favorate() {
            return is_favorate;
        }

        public void setIs_favorate(boolean is_favorate) {
            this.is_favorate = is_favorate;
        }

        public int getCart_count() {
            return cart_count;
        }

        public void setCart_count(int cart_count) {
            this.cart_count = cart_count;
        }

        public StoreCommentBean getStore_comment() {
            return store_comment;
        }

        public void setStore_comment(StoreCommentBean store_comment) {
            this.store_comment = store_comment;
        }

        public StoreInfoBean getStore_info() {
            return store_info;
        }

        public void setStore_info(StoreInfoBean store_info) {
            this.store_info = store_info;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public TotalCommentBean getTotal_comment() {
            return total_comment;
        }

        public void setTotal_comment(TotalCommentBean total_comment) {
            this.total_comment = total_comment;
        }

        public List<GoodsCommendListBean> getGoods_commend_list() {
            return goods_commend_list;
        }

        public void setGoods_commend_list(List<GoodsCommendListBean> goods_commend_list) {
            this.goods_commend_list = goods_commend_list;
        }

        public List<?> getComment() {
            return comment;
        }

        public void setComment(List<?> comment) {
            this.comment = comment;
        }

        public static class GoodsInfoBean {
            /**
             * goods_commonid : 100584
             * goods_name : 围巾女冬季披肩毛线针织情侣款男加厚秋冬天长款学生韩版韩国百搭 a 1 2
             * goods_jingle : 冬季披肩毛线针织情侣款
             * gc_id_1 : 0
             * gc_id_2 : 0
             * gc_id_3 : 0
             * store_id : 2
             * goods_specname :
             * goods_price : 28.88
             * goods_marketprice : 98.00
             * goods_costprice : 20.00
             * goods_discount : 29
             * goods_serial : 131232
             * goods_storage_alarm : 0
             * transport_id : 0
             * transport_title :
             * goods_freight : 0.00
             * goods_vat : 0
             * areaid_1 : 0
             * areaid_2 : 0
             * goods_stcids : ,0,
             * plateid_top : 0
             * plateid_bottom : 0
             * goods_id : 101088
             * goods_promotion_price : 0.00
             * goods_promotion_type : 0
             * goods_click : 201
             * goods_salenum : 5
             * goods_collect : 0
             * goods_storage : 1106
             * color_id : 795
             * evaluation_good_star : 5
             * evaluation_count : 0
             * is_virtual : 0
             * virtual_indate : 0
             * virtual_limit : 0
             * virtual_invalid_refund : 1
             * is_fcode : 0
             * is_appoint : 0
             * is_presell : 0
             * have_gift : 0
             * is_own_shop : 0
             * goods_rebate : 5
             * promotion_type :
             * promotion_price :
             * goods_url : http://123.56.203.196/bbcmall/shop/index.php?app=goods&mod=index&goods_id=101088
             * qr_code : http://123.56.203.196/bbcmall/data/upload/shop/store/2/101088.png
             * mobile_price :
             */

            private String goods_commonid;
            private String goods_name;
            private String goods_jingle;
            private String gc_id_1;
            private String gc_id_2;
            private String gc_id_3;
            private String store_id;
            private String goods_specname;
            private String goods_price;
            private String goods_marketprice;
            private String goods_costprice;
            private String goods_discount;
            private String goods_serial;
            private String goods_storage_alarm;
            private String transport_id;
            private String transport_title;
            private String goods_freight;
            private String goods_vat;
            private String areaid_1;
            private String areaid_2;
            private String goods_stcids;
            private String plateid_top;
            private String plateid_bottom;
            private String goods_id;
            private String goods_promotion_price;
            private String goods_promotion_type;
            private String goods_click;
            private String goods_salenum;
            private String goods_collect;
            private String goods_storage;
            private String color_id;
            private String evaluation_good_star;
            private String evaluation_count;
            private String is_virtual;
            private String virtual_indate;
            private String virtual_limit;
            private String virtual_invalid_refund;
            private String is_fcode;
            private String is_appoint;
            private String is_presell;
            private String have_gift;
            private String is_own_shop;
            private String goods_rebate;
            private String promotion_type;
            private String promotion_price;
            private String goods_url;
            private String qr_code;
            private String mobile_price;

            public String getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(String goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_jingle() {
                return goods_jingle;
            }

            public void setGoods_jingle(String goods_jingle) {
                this.goods_jingle = goods_jingle;
            }

            public String getGc_id_1() {
                return gc_id_1;
            }

            public void setGc_id_1(String gc_id_1) {
                this.gc_id_1 = gc_id_1;
            }

            public String getGc_id_2() {
                return gc_id_2;
            }

            public void setGc_id_2(String gc_id_2) {
                this.gc_id_2 = gc_id_2;
            }

            public String getGc_id_3() {
                return gc_id_3;
            }

            public void setGc_id_3(String gc_id_3) {
                this.gc_id_3 = gc_id_3;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getGoods_specname() {
                return goods_specname;
            }

            public void setGoods_specname(String goods_specname) {
                this.goods_specname = goods_specname;
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

            public String getGoods_costprice() {
                return goods_costprice;
            }

            public void setGoods_costprice(String goods_costprice) {
                this.goods_costprice = goods_costprice;
            }

            public String getGoods_discount() {
                return goods_discount;
            }

            public void setGoods_discount(String goods_discount) {
                this.goods_discount = goods_discount;
            }

            public String getGoods_serial() {
                return goods_serial;
            }

            public void setGoods_serial(String goods_serial) {
                this.goods_serial = goods_serial;
            }

            public String getGoods_storage_alarm() {
                return goods_storage_alarm;
            }

            public void setGoods_storage_alarm(String goods_storage_alarm) {
                this.goods_storage_alarm = goods_storage_alarm;
            }

            public String getTransport_id() {
                return transport_id;
            }

            public void setTransport_id(String transport_id) {
                this.transport_id = transport_id;
            }

            public String getTransport_title() {
                return transport_title;
            }

            public void setTransport_title(String transport_title) {
                this.transport_title = transport_title;
            }

            public String getGoods_freight() {
                return goods_freight;
            }

            public void setGoods_freight(String goods_freight) {
                this.goods_freight = goods_freight;
            }

            public String getGoods_vat() {
                return goods_vat;
            }

            public void setGoods_vat(String goods_vat) {
                this.goods_vat = goods_vat;
            }

            public String getAreaid_1() {
                return areaid_1;
            }

            public void setAreaid_1(String areaid_1) {
                this.areaid_1 = areaid_1;
            }

            public String getAreaid_2() {
                return areaid_2;
            }

            public void setAreaid_2(String areaid_2) {
                this.areaid_2 = areaid_2;
            }

            public String getGoods_stcids() {
                return goods_stcids;
            }

            public void setGoods_stcids(String goods_stcids) {
                this.goods_stcids = goods_stcids;
            }

            public String getPlateid_top() {
                return plateid_top;
            }

            public void setPlateid_top(String plateid_top) {
                this.plateid_top = plateid_top;
            }

            public String getPlateid_bottom() {
                return plateid_bottom;
            }

            public void setPlateid_bottom(String plateid_bottom) {
                this.plateid_bottom = plateid_bottom;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_promotion_price() {
                return goods_promotion_price;
            }

            public void setGoods_promotion_price(String goods_promotion_price) {
                this.goods_promotion_price = goods_promotion_price;
            }

            public String getGoods_promotion_type() {
                return goods_promotion_type;
            }

            public void setGoods_promotion_type(String goods_promotion_type) {
                this.goods_promotion_type = goods_promotion_type;
            }

            public String getGoods_click() {
                return goods_click;
            }

            public void setGoods_click(String goods_click) {
                this.goods_click = goods_click;
            }

            public String getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(String goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public String getGoods_collect() {
                return goods_collect;
            }

            public void setGoods_collect(String goods_collect) {
                this.goods_collect = goods_collect;
            }

            public String getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(String goods_storage) {
                this.goods_storage = goods_storage;
            }

            public String getColor_id() {
                return color_id;
            }

            public void setColor_id(String color_id) {
                this.color_id = color_id;
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

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public String getVirtual_indate() {
                return virtual_indate;
            }

            public void setVirtual_indate(String virtual_indate) {
                this.virtual_indate = virtual_indate;
            }

            public String getVirtual_limit() {
                return virtual_limit;
            }

            public void setVirtual_limit(String virtual_limit) {
                this.virtual_limit = virtual_limit;
            }

            public String getVirtual_invalid_refund() {
                return virtual_invalid_refund;
            }

            public void setVirtual_invalid_refund(String virtual_invalid_refund) {
                this.virtual_invalid_refund = virtual_invalid_refund;
            }

            public String getIs_fcode() {
                return is_fcode;
            }

            public void setIs_fcode(String is_fcode) {
                this.is_fcode = is_fcode;
            }

            public String getIs_appoint() {
                return is_appoint;
            }

            public void setIs_appoint(String is_appoint) {
                this.is_appoint = is_appoint;
            }

            public String getIs_presell() {
                return is_presell;
            }

            public void setIs_presell(String is_presell) {
                this.is_presell = is_presell;
            }

            public String getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(String have_gift) {
                this.have_gift = have_gift;
            }

            public String getIs_own_shop() {
                return is_own_shop;
            }

            public void setIs_own_shop(String is_own_shop) {
                this.is_own_shop = is_own_shop;
            }

            public String getGoods_rebate() {
                return goods_rebate;
            }

            public void setGoods_rebate(String goods_rebate) {
                this.goods_rebate = goods_rebate;
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

            public String getGoods_url() {
                return goods_url;
            }

            public void setGoods_url(String goods_url) {
                this.goods_url = goods_url;
            }

            public String getQr_code() {
                return qr_code;
            }

            public void setQr_code(String qr_code) {
                this.qr_code = qr_code;
            }

            public String getMobile_price() {
                return mobile_price;
            }

            public void setMobile_price(String mobile_price) {
                this.mobile_price = mobile_price;
            }
        }

        public static class SpecImageBean {
            /**
             * 795 : http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05324532466606253_60.jpg
             */

            private String value795;

            public String getValue795() {
                return value795;
            }

            public void setValue795(String value795) {
                this.value795 = value795;
            }
        }

        public static class StoreCommentBean {
            /**
             * store_credit : {"store_desccredit":{"text":"描述相符","credit":4},"store_servicecredit":{"text":"服务态度","credit":4},"store_deliverycredit":{"text":"发货速度","credit":4.8}}
             * store_credit_average : 4.3
             * store_credit_percent : 86
             */

            private StoreCreditBean store_credit;
            private double store_credit_average;
            private int store_credit_percent;

            public StoreCreditBean getStore_credit() {
                return store_credit;
            }

            public void setStore_credit(StoreCreditBean store_credit) {
                this.store_credit = store_credit;
            }

            public double getStore_credit_average() {
                return store_credit_average;
            }

            public void setStore_credit_average(double store_credit_average) {
                this.store_credit_average = store_credit_average;
            }

            public int getStore_credit_percent() {
                return store_credit_percent;
            }

            public void setStore_credit_percent(int store_credit_percent) {
                this.store_credit_percent = store_credit_percent;
            }

            public static class StoreCreditBean {
                /**
                 * store_desccredit : {"text":"描述相符","credit":4}
                 * store_servicecredit : {"text":"服务态度","credit":4}
                 * store_deliverycredit : {"text":"发货速度","credit":4.8}
                 */

                private StoreDesccreditBean store_desccredit;
                private StoreServicecreditBean store_servicecredit;
                private StoreDeliverycreditBean store_deliverycredit;

                public StoreDesccreditBean getStore_desccredit() {
                    return store_desccredit;
                }

                public void setStore_desccredit(StoreDesccreditBean store_desccredit) {
                    this.store_desccredit = store_desccredit;
                }

                public StoreServicecreditBean getStore_servicecredit() {
                    return store_servicecredit;
                }

                public void setStore_servicecredit(StoreServicecreditBean store_servicecredit) {
                    this.store_servicecredit = store_servicecredit;
                }

                public StoreDeliverycreditBean getStore_deliverycredit() {
                    return store_deliverycredit;
                }

                public void setStore_deliverycredit(StoreDeliverycreditBean store_deliverycredit) {
                    this.store_deliverycredit = store_deliverycredit;
                }

                public static class StoreDesccreditBean {
                    /**
                     * text : 描述相符
                     * credit : 4
                     */

                    private String text;
                    private int credit;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getCredit() {
                        return credit;
                    }

                    public void setCredit(int credit) {
                        this.credit = credit;
                    }
                }

                public static class StoreServicecreditBean {
                    /**
                     * text : 服务态度
                     * credit : 4
                     */

                    private String text;
                    private int credit;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getCredit() {
                        return credit;
                    }

                    public void setCredit(int credit) {
                        this.credit = credit;
                    }
                }

                public static class StoreDeliverycreditBean {
                    /**
                     * text : 发货速度
                     * credit : 4.8
                     */

                    private String text;
                    private double credit;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public double getCredit() {
                        return credit;
                    }

                    public void setCredit(double credit) {
                        this.credit = credit;
                    }
                }
            }
        }

        public static class StoreInfoBean {
            /**
             * store_id : 2
             * store_name : 官方自营店铺
             * member_id : 2
             * address :
             * store_qq : 1111111
             * store_ww : 1111
             * store_tel :
             * store_phone : null
             * member_name : test01
             * avatar : http://123.56.203.196/bbcmall/data/upload/shop/store/05268610934940592.jpg
             */

            private String store_id;
            private String store_name;
            private String member_id;
            private String address;
            private String store_qq;
            private String store_ww;
            private String store_tel;
            private Object store_phone;
            private String member_name;
            private String avatar;

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

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getStore_qq() {
                return store_qq;
            }

            public void setStore_qq(String store_qq) {
                this.store_qq = store_qq;
            }

            public String getStore_ww() {
                return store_ww;
            }

            public void setStore_ww(String store_ww) {
                this.store_ww = store_ww;
            }

            public String getStore_tel() {
                return store_tel;
            }

            public void setStore_tel(String store_tel) {
                this.store_tel = store_tel;
            }

            public Object getStore_phone() {
                return store_phone;
            }

            public void setStore_phone(Object store_phone) {
                this.store_phone = store_phone;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class TotalCommentBean {
            /**
             * good : 0
             * normal : 0
             * bad : 0
             * all : 0
             * good_percent : 100
             * normal_percent : 0
             * bad_percent : 0
             * good_star : 5
             */

            private String good;
            private String normal;
            private String bad;
            private int all;
            private int good_percent;
            private int normal_percent;
            private int bad_percent;
            private int good_star;

            public String getGood() {
                return good;
            }

            public void setGood(String good) {
                this.good = good;
            }

            public String getNormal() {
                return normal;
            }

            public void setNormal(String normal) {
                this.normal = normal;
            }

            public String getBad() {
                return bad;
            }

            public void setBad(String bad) {
                this.bad = bad;
            }

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }

            public int getGood_percent() {
                return good_percent;
            }

            public void setGood_percent(int good_percent) {
                this.good_percent = good_percent;
            }

            public int getNormal_percent() {
                return normal_percent;
            }

            public void setNormal_percent(int normal_percent) {
                this.normal_percent = normal_percent;
            }

            public int getBad_percent() {
                return bad_percent;
            }

            public void setBad_percent(int bad_percent) {
                this.bad_percent = bad_percent;
            }

            public int getGood_star() {
                return good_star;
            }

            public void setGood_star(int good_star) {
                this.good_star = good_star;
            }
        }

        public static class GoodsCommendListBean {
            /**
             * goods_id : 101025
             * goods_name : 手表的发生的 黑色 1 2
             * goods_price : 51.00
             * goods_image_url : http://123.56.203.196/bbcmall/data/upload/shop/store/goods/2/2_05315847179011625_240.jpg
             */

            private String goods_id;
            private String goods_name;
            private String goods_price;
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

            public String getGoods_image_url() {
                return goods_image_url;
            }

            public void setGoods_image_url(String goods_image_url) {
                this.goods_image_url = goods_image_url;
            }
        }
    }
}
