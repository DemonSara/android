package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {
    @BindView(R.id.tv_name_OrderDetailsActivity)
    TextView tvNameOrderDetailsActivity;
    @BindView(R.id.tv_phone_OrderDetailsActivity)
    TextView tvPhoneOrderDetailsActivity;
    @BindView(R.id.tv_address_OrderDetailsActivity)
    TextView tvAddressOrderDetailsActivity;
    @BindView(R.id.zhifubao)
    ImageButton zhifubao;
    @BindView(R.id.wechat)
    ImageButton wechat;
    @BindView(R.id.tv_cancel_OrderDetailsActivity)
    TextView tvCancelOrderDetailsActivity;
    @BindView(R.id.tv_payment_OrderDetailsActivity)
    TextView tvPaymentOrderDetailsActivity;
    @BindView(R.id.linear_OrderDetailsActivity)
    LinearLayout linearOrderDetailsActivity;
    SharedPreferences preferences;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        preferences=getSharedPreferences("userinfo",0);
        tvNameOrderDetailsActivity.setText(preferences.getString("name",""));
        tvPhoneOrderDetailsActivity.setText(preferences.getString("phone",""));
        tvAddressOrderDetailsActivity.setText(preferences.getString("address",""));
    }

    private void setview() {
        zhifubao.setBackgroundResource(R.mipmap.select_falses);
        wechat.setBackgroundResource(R.mipmap.select_falses);
    }

    private void changeview(ImageButton imb) {
        setview();
        imb.setBackgroundResource(R.mipmap.select_red_true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }

    @OnClick({R.id.zhifubao, R.id.wechat, R.id.tv_cancel_OrderDetailsActivity, R.id.tv_payment_OrderDetailsActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhifubao:
                changeview(zhifubao);
                break;
            case R.id.wechat:
                changeview(wechat);
                break;
            case R.id.tv_cancel_OrderDetailsActivity:
                goActivity(MainActivity.class);
                break;
            case R.id.tv_payment_OrderDetailsActivity:
                goActivity(PaySuccessfulActivity.class);
                break;
        }
    }
}
