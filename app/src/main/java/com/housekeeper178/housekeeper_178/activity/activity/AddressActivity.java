package com.housekeeper178.housekeeper_178.activity.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {
    @BindView(R.id.tv_title_ReceivingAddressActivity)
    TextView tvTitleReceivingAddressActivity;
    @BindView(R.id.tv_name_receibingaddressactivity)
    TextView tvNameReceibingaddressactivity;
    @BindView(R.id.tv_phone_receibingaddressactivity)
    TextView tvPhoneReceibingaddressactivity;
    @BindView(R.id.tv_address_receibingaddressactivity)
    TextView tvAddressReceibingaddressactivity;
    @BindView(R.id.tv_edit_receibingaddressactivity)
    TextView tvEditReceibingaddressactivity;
    private SharedPreferences sharedPreferences;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView() {
         sharedPreferences= getSharedPreferences("userinfo",0);
tvNameReceibingaddressactivity.setText(sharedPreferences.getString("name",""));
tvPhoneReceibingaddressactivity.setText(sharedPreferences.getString("phone",""));
tvAddressReceibingaddressactivity.setText(sharedPreferences.getString("address",""));



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_edit_receibingaddressactivity)
    public void onViewClicked() {
        goActivity(ChangeAddressActivity.class);
    }
}
