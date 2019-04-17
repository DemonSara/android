package com.housekeeper178.housekeeper_178.activity.model;

import com.base.model.Base;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class ChartList implements Serializable {

    /**
     * datetime : 1553055531000
     * goodsName : 猕猴桃
     * id : 6
     * paytype : 1
     * status : 0
     * total : 6.010000228881836
     */
    public static Type getListClassType(){
        return new TypeToken<Base<List<ChartList>>>() {
        }.getType();
    }
    private long datetime;
    private String goodsName;
    private int id;
    private int paytype;
    private int status;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private String total;

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


}
