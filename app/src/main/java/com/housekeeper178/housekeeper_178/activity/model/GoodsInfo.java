package com.housekeeper178.housekeeper_178.activity.model;

import com.base.model.Base;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GoodsInfo implements Serializable {
    private String cover;
    private String id;
    private String image1;
    private String image2;
    private String intro;
    private boolean isHot;
    public static Type getClassType() {
        return new TypeToken<Base<GoodsInfo>>() {
        }.getType();
    }

    public static Type getListClassType(){
        return new TypeToken<Base<List<GoodsInfo>>>() {
        }.getType();
    }


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isScroll() {
        return isScroll;
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Map<String, Object> getType() {
        return type;
    }

    public void setType(Map<String, Object> type) {
        this.type = type;
    }

    private boolean isNew;
    private boolean isScroll;
    private String name;
    private String price;
    private String stock;
    private Map<String,Object> type;



}
