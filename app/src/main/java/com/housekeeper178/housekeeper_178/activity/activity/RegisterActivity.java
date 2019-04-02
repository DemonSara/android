package com.housekeeper178.housekeeper_178.activity.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.base.util.Tool;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.net.API;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 2018/12/28
 *
 * @TODO:注册
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.et_username_registerActivity)
    EditText etUsernameRegisterActivity;
    @BindView(R.id.et_psw1_registerActivity)
    EditText etPsw1RegisterActivity;
    @BindView(R.id.et_psw2_registerActivity)
    EditText etPsw2RegisterActivity;
    @BindView(R.id.et_Inviter_registerActivity)
    EditText etInviterRegisterActivity;
    @BindView(R.id.bt_next_registerActivity)
    Button btNextRegisterActivity;
    @BindView(R.id.et_name_registerActivity)
    EditText etNameRegisterActivity;
    @BindView(R.id.et_phonenum_registerActivity)
    EditText etPhonenumRegisterActivity;
    @BindView(R.id.et_address_registerActivity)
    EditText etAddressRegisterActivity;
    @BindView(R.id.bt_golo_registerActivity)
    Button btGoloRegisterActivity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
    }


    private void register() {
        String username = Tool.getTextViewContent(etUsernameRegisterActivity);
        String password = Tool.getTextViewContent(etPsw1RegisterActivity);
        String password2 = Tool.getTextViewContent(etPsw2RegisterActivity);
        String email = Tool.getTextViewContent(etInviterRegisterActivity);
        String realname = Tool.getTextViewContent(etNameRegisterActivity);
        String phonenum = Tool.getTextViewContent(etPhonenumRegisterActivity);
        String address = Tool.getTextViewContent(etAddressRegisterActivity);
        if (password == null) {
            initReturnBack("密码不能为空");
            return;
        }
        if (password2 == null || !password2.equals(password)) {
            initReturnBack("两次密码不一致");
            return;
        }
        new API(this, Base.getClassType()).register(username, password, email, realname, phonenum, address);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        btNextRegisterActivity.setOnClickListener((View v) -> {
            register();
        });
    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.register:
                if (base.getCode().equals("true")) {
                    goActivity(LoginActivity.class);
                } else {
                    initReturnBack(base.getMsg());
                }
        }

    }

    @OnClick(R.id.bt_golo_registerActivity)
    public void onViewClicked() {

        goActivity(LoginActivity.class);
    }
}

