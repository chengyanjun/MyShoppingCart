package com.shopping.chengzi.myshoppingcart.bean;

import java.util.List;

/**
 * Created by chengzi on 2017/3/13.
 */

public class BeanClassifyDetail {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"1578","gc_name":"奶粉"},{"gc_id":"1582","gc_name":"宝宝用品"},{"gc_id":"1583","gc_name":"童装童鞋"},{"gc_id":"1581","gc_name":"营养辅食"},{"gc_id":"1651","gc_name":"孕妈必备"},{"gc_id":"1579","gc_name":"纸尿裤/拉拉裤"}]}
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
             * gc_id : 1578
             * gc_name : 奶粉
             */

            private String gc_id;
            private String gc_name;

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
        }
    }
}
