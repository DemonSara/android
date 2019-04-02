package com.housekeeper178.housekeeper_178.activity;

import android.annotation.SuppressLint;
import android.content.Context;

import com.base.BPApplication;
import com.base.util.LoginManager;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;

public class HKApplication extends BPApplication {
    private static int type = 1;
    private static String NetPath;
    private static String NetFilePath;
    private static Context context;
    private static UserInfo userInfo;

    static {

            NetPath = "http://47.105.161.233:8080/greenshop/";
        NetFilePath = "http://47.105.161.233:8080/";
    }


    @SuppressLint("ResourceType")
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        setCACHE_PATH("Housekeeper");
        setNET_PATH(NetPath);
        setNET_FILE_PATH(NetFilePath);
        setAppThemeColor(getResources().getString(R.color.appThemeColor), getResources().getColor(R.color.appThemeColor));

    }

    public static UserInfo getUserInfo() {
        return userInfo;
    }

    public static void setUserInfo(UserInfo info) {
        userInfo = info;
    }

    public static void onRefreshLogin() {
        LoginManager.saveObject(context, userInfo);
    }

    public static void onRefreshLogin(UserInfo userInfo) {
        LoginManager.saveObject(context, userInfo);
    }
}
