package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.fragment.ShareFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeletSuccessfulActivity extends BaseActivity {
    @BindView(R.id.tv_d_s)
    TextView tvDS;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deletsuccessful;
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

    @OnClick(R.id.tv_d_s)
    public void onViewClicked() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("pos",2);
        startActivity(intent);
    }
}
