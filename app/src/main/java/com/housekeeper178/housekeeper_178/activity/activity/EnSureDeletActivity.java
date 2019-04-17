package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.LinearLayout;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.fragment.ShareFragment;
import com.housekeeper178.housekeeper_178.activity.net.API;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnSureDeletActivity extends BaseActivity {
    @BindView(R.id.lalasdhwdu)
    LinearLayout lalasdhwdu;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ensuredelet;
    }

    public void delet() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        new API(this, Base.getClassType()).orderDelete(id);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("提示");
        alertDialog.setMessage("确定要删除此订单？");
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                delet();
                goActivity(DeletSuccessfulActivity.class);
            }
        });
        alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goActivity(MainActivity.class);
            }
        });
        alertDialog.show();
    }
}
