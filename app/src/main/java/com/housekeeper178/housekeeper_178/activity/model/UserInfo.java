package com.housekeeper178.housekeeper_178.activity.model;

import com.base.model.Base;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class UserInfo implements Serializable{
   private String address;
    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public boolean isIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private boolean isadmin;
    private boolean isvalidate;
    private String name;
    private String password;
    private String phone;
    private String username;

    public static Type getClassType() {
        return new TypeToken<Base<UserInfo>>() {
        }.getType();
    }
    public static Type getListClassType(){
        return new TypeToken<Base<List<UserInfo>>>() {
        }.getType();
    }
}
