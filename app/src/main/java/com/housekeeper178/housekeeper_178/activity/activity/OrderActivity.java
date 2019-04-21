package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.ChartList;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.List;

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
    private int userid;
    SharedPreferences preferences;
    List<Integer> ddid = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        preferences = getSharedPreferences("userinfo", 0);
        tvNameOrderDetailsActivity.setText(preferences.getString("name", ""));
        tvPhoneOrderDetailsActivity.setText(preferences.getString("phone", ""));
        tvAddressOrderDetailsActivity.setText(preferences.getString("address", ""));
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

    private void changebillstatus() {

        preferences = getSharedPreferences("userinfo", 0);
        userid = preferences.getInt("id", 0);
        //获取用户ID
        new API(this, ChartList.getListClassType()).orderListSimple(userid, 1);

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
                changebillstatus();
                goActivity(PaySuccessfulActivity.class);
                break;
        }
    }


    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.orderListSimple:
                if (base.getCode().equals("true")) {
                    List<ChartList> cc = (List<ChartList>) base.getData();
                    for (int i = 0; i < cc.size(); i++) {
                        new API(this, Base.getClassType()).changestatus(cc.get(i).getId(), 2);
                    }
                }


        }
    }
}
