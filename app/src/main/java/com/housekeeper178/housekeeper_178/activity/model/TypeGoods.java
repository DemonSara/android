package com.housekeeper178.housekeeper_178.activity.model;

import com.base.model.Base;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class TypeGoods implements Serializable {
    private String encodeName;

    public String getEncodeName() {
        return encodeName;
    }

    public void setEncodeName(String encodeName) {
        this.encodeName = encodeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    public static Type getListClassType(){
        return new TypeToken<Base<List<TypeGoods>>>() {
        }.getType();
    }
}
