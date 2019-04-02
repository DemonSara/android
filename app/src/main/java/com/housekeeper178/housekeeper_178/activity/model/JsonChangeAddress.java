package com.housekeeper178.housekeeper_178.activity.model;

import java.io.Serializable;

public class JsonChangeAddress implements Serializable {

    /**
     * id : 35
     * name : feizhen
     * phone : 123444
     * address : sadadsada
     */

    private int id;
    private String name;
    private String phone;
    private String address;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
