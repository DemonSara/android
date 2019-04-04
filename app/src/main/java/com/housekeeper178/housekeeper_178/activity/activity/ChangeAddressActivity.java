package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;

import com.base.model.Base;
import com.base.util.Tool;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.net.API;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
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

    private SharedPreferences sps;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

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
            System.out.println(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://47.105.161.233:8080/greenshop/app/user_changeaddress")
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("motherfucker");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null) {
                    goActivity(MainActivity.class);

                }
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sps = getSharedPreferences("userinfo", 0);
        id = sps.getInt("id", 0);


    }



    @OnClick(R.id.tv_Submission_address)
    public void onViewClicked() {
        change();
    }
}
