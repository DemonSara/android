package com.housekeeper178.housekeeper_178.activity.net;

import com.base.interfaces.SNRequestDataListener;
import com.base.net.MCBaseAPI;
import com.base.net.UrlParameters;
import com.housekeeper178.housekeeper_178.activity.HKApplication;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class API extends MCBaseAPI {
    private UserInfo user;

    public API(SNRequestDataListener listener, Type type) {
        super(listener, type);
        user = HKApplication.getUserInfo();
    }

    public void register(String username, String password, String email, String realname, String phonenum, String address) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/user_register");
        params.add("username", username);
        params.add("password", password);
        params.add("email", email);
        params.add("name", realname);
        params.add("phone", phonenum);
        params.add("address", address);
        post(params, whichAPI.register);
    }

    public void Login(String loginName, String password) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/user_login");
        params.add("username", loginName);
        params.add("password", password);
        post(params, whichAPI.Login);
    }

    public void itemhot(int kindId) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/goodsByKind");
        params.add("kindId", kindId);
        post(params, whichAPI.itemhot);

    }

    public void searchgoods(String keyword) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/goodsSearch");
        params.add("keyword", keyword);
        post(params, whichAPI.searchgoods);

    }

    public void changeuserpsw(String loginName, String oldpassword, String newpassword) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/user_changepwd");
        params.add("username", loginName);
        params.add("password", oldpassword);
        params.add("newPassword", newpassword);
        post(params, whichAPI.changeuserpsw);
    }

    public void typelist() {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/goods_type");
        get(params, whichAPI.typelist);
    }

    public void goodsList(int typeId) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/goodsList");
        params.add("typeId", typeId);
        get(params, whichAPI.goodsList);
    }


    public void gouwuche(int goods_id, int amount, int paytype, int status, int user_id) {
        UrlParameters params = new UrlParameters();
        params.setUrl("app/order_confirm");
        params.add("goods_id", goods_id);
        params.add("amount", amount);
        params.add("paytype", paytype);
        params.add("status", status);
        params.add("user_id", user_id);
        post(params, whichAPI.gouwuche);

    }


    public class whichAPI {
        private static final int ONE = 10000;
        //用户注册
        public static final int register = ONE + 1;
        //用户登录
        public static final int Login = ONE + 2;
        //热销新品
        public static final int itemhot = ONE + 3;
        //查找
        public static final int searchgoods = ONE + 4;
        //修改密码
        public static final int changeuserpsw = ONE + 5;
        //购物车
        public static final int gouwuche = ONE + 6;
        //商品类别
        public static final int typelist = ONE + 7;
        //类别查询
        public static final int goodsList = ONE + 8;
    }
}
