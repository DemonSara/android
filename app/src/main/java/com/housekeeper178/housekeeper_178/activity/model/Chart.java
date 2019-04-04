package com.housekeeper178.housekeeper_178.activity.model;

import java.io.Serializable;
import java.util.List;

public class Chart implements Serializable {


    /**
     * itemList : [{"goods_id":185,"amount":3}]
     * paytype : 1
     * status : 2
     * user_id : 25
     */

    private int paytype;
    private int status;
    private int user_id;
    private List<ItemListBean> itemList;

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * goods_id : 185
         * amount : 3
         */

        private int goods_id;
        private int amount;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
