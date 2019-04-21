package com.housekeeper178.housekeeper_178.activity.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.base.util.Tool;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_phone_loginActivity)
    EditText etPhoneLoginActivity;
    @BindView(R.id.et_psw_loginActivity)
    EditText etPswLoginActivity;
    @BindView(R.id.bt_loginActivity)
    Button btLoginActivity;
    @BindView(R.id.bt_gogggg_loginActivity)
    Button btGoggggLoginActivity;
    private String username;
    private String password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    private void login() {
        username = Tool.getTextViewContent(etPhoneLoginActivity);
        password = Tool.getTextViewContent(etPswLoginActivity);
        new API(this, UserInfo.getListClassType()).Login(username, password);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.Login:
                if (base.getCode().equals("true")) {
                    List<UserInfo> list = (List<UserInfo>) base.getData();
                    //储存用户信息
                    SharedPreferences.Editor sharedata = getSharedPreferences("userinfo", 0).edit();
                    sharedata.putString("address", list.get(0).getAddress());
                    sharedata.putString("email", list.get(0).getEmail());
                    sharedata.putInt("id", list.get(0).getId());
                    sharedata.putString("name", list.get(0).getName());
                    sharedata.putString("password", list.get(0).getPassword());
                    sharedata.putString("phone", list.get(0).getPhone());
                    sharedata.putString("username", list.get(0).getUsername());
                    sharedata.apply();
                    goActivity(MainActivity.class);
                } else {
                    initReturnBack(base.getMsg());

                }
        }
    }

    @OnClick({R.id.bt_loginActivity, R.id.bt_gogggg_loginActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_loginActivity:
                login();
                break;
            case R.id.bt_gogggg_loginActivity:
                goActivity(RegisterActivity.class);
                break;
        }
    }

//    @OnClick(R.id.bt_loginActivity)
//    public void onViewClicked() {
//        login();
//    }
//
//    @OnClick(R.id.bt_gogggg_loginActivity)
//    public void onViewClicked() {
//        goActivity(RegisterActivity.class);
//    }
}
