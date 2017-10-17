package com.shopping.chengzi.myshoppingcart.bean;

/**
 * Created by chengzi on 2017/3/16.
 */

public class BeanLogin {


    /**
     * code : 200
     * datas : {"username":"13022757572","key":"34bdc5041cfbb61edc5e2f1fd5eccadb","member_id":"172","defaultAddress":{"address_id":"","member_id":"","true_name":"","area_id":"","city_id":"","area_info":"","address":"","tel_phone":"","mob_phone":"","is_default":""},"cartNum":"1","logo":"http://123.56.203.196/bbcmall/data/upload/shop/avatar/172_05348791585424930.jpg"}
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
         * username : 13022757572
         * key : 34bdc5041cfbb61edc5e2f1fd5eccadb
         * member_id : 172
         * defaultAddress : {"address_id":"","member_id":"","true_name":"","area_id":"","city_id":"","area_info":"","address":"","tel_phone":"","mob_phone":"","is_default":""}
         * cartNum : 1
         * logo : http://123.56.203.196/bbcmall/data/upload/shop/avatar/172_05348791585424930.jpg
         */

        private String username;
        private String key;
        private String member_id;
        private DefaultAddressBean defaultAddress;
        private String cartNum;
        private String logo;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getMember_id() {
            return member_id;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }

        public DefaultAddressBean getDefaultAddress() {
            return defaultAddress;
        }

        public void setDefaultAddress(DefaultAddressBean defaultAddress) {
            this.defaultAddress = defaultAddress;
        }

        public String getCartNum() {
            return cartNum;
        }

        public void setCartNum(String cartNum) {
            this.cartNum = cartNum;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public static class DefaultAddressBean {
            /**
             * address_id :
             * member_id :
             * true_name :
             * area_id :
             * city_id :
             * area_info :
             * address :
             * tel_phone :
             * mob_phone :
             * is_default :
             */

            private String address_id;
            private String member_id;
            private String true_name;
            private String area_id;
            private String city_id;
            private String area_info;
            private String address;
            private String tel_phone;
            private String mob_phone;
            private String is_default;

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTel_phone() {
                return tel_phone;
            }

            public void setTel_phone(String tel_phone) {
                this.tel_phone = tel_phone;
            }

            public String getMob_phone() {
                return mob_phone;
            }

            public void setMob_phone(String mob_phone) {
                this.mob_phone = mob_phone;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }
        }
    }
}
