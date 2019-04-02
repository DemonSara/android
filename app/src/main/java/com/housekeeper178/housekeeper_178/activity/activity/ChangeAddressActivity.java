package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;

import com.base.model.Base;
import com.base.net.HttpManager;
import com.base.net.UrlParameters;
import com.base.util.Tool;
import com.google.gson.Gson;
import com.housekeeper178.housekeeper_178.R;

import com.housekeeper178.housekeeper_178.activity.model.JsonChangeAddress;
import com.housekeeper178.housekeeper_178.activity.net.API;
import com.housekeeper178.housekeeper_178.activity.utils.PostJson;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ChangeAddressActivity extends BaseActivity {
    @BindView(R.id.et_name_change)
    EditText etNameChange;
    @BindView(R.id.et_phone_change)
    EditText etPhoneChange;
    @BindView(R.id.et_address_change)
    EditText etAddressChange;
    @BindView(R.id.tv_Submission_address)
    TextView tvSubmissionAddress;
    int id;
    private String name;
    private String phone;
    private String address;
    String json;
    private SharedPreferences sps;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_address;
    }

    @Override
    protected void initView() {

    }

    public void change() {
        name = Tool.getTextViewContent(etNameChange);
        phone = Tool.getTextViewContent(etPhoneChange);
        address = Tool.getTextViewContent(etAddressChange);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", name);
            jsonObject.put("phone", phone);
            jsonObject.put("address", address);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new API(this,Base.getClassType()).changeaddress(jsonObject);




//        PostJson postJson = new PostJson();
//        String result = null;
//        try {
//            result = postJson.post("http://47.105.161.233:8080/greenshop/app/user_changeaddress", jsonObject.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.print(result);
    }

//        PostJson postJson = new PostJson();
//        String result = postJson.post("http://47.105.161.233:8080/greenshop/app/user_changeaddress", jsonObject.toString());
//        System.out.print(result);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sps = getSharedPreferences("userinfo", 0);
        id = sps.getInt("id", 0);


    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI){
            case API.whichAPI.changeaddress:
                if (base.getCode().equals("true")){
                    Toast.makeText(this,"修改成功！",Toast.LENGTH_SHORT).show();
                    goActivity(MainActivity.class);
                }
        }
    }

    @OnClick(R.id.tv_Submission_address)
    public void onViewClicked() {
        change();
    }
}
