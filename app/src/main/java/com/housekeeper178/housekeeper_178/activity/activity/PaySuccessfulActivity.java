package com.housekeeper178.housekeeper_178.activity.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySuccessfulActivity extends BaseActivity {
    @BindView(R.id.tv_ViewPlan_SuccessfulPlanActivity)
    TextView tvViewPlanSuccessfulPlanActivity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_successful;
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

    @OnClick(R.id.tv_ViewPlan_SuccessfulPlanActivity)
    public void onViewClicked() {
        goActivity(MainActivity.class);
    }
}
