package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.adapter.AhomefragmentRv;
import com.housekeeper178.housekeeper_178.activity.model.Hotgood;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeileiGoodshowActivity extends BaseActivity {
    @BindView(R.id.showfenlei_tv)
    TextView showfenleiTv;
    @BindView(R.id.fenleigoodshowrv)
    RecyclerView fenleigoodshowrv;
    int ididid;
    List<String> price = new ArrayList<>();
    List<String> name = new ArrayList<>();
    List<String> imgurl = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fenleigoodshow;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("typename");
        ididid = intent.getIntExtra("id", 0);
        showfenleiTv.setText(name);
        new API(this, Hotgood.getListClassType()).goodsList(ididid);

    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.goodsList:
                if (base.getCode().equals("true")) {
                    List<Hotgood> hotgoods = (List<Hotgood>) base.getData();
                    for (int i = 0; i < hotgoods.size(); i++) {
                        imgurl.add(hotgoods.get(i).getCover());
                        name.add(hotgoods.get(i).getName());
                        price.add(hotgoods.get(i).getPrice());
                    }
                    fenleigoodshowrv.setAdapter(new AhomefragmentRv(imgurl, name, price, this));
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                    fenleigoodshowrv.setLayoutManager(gridLayoutManager);


                }
        }
    }
}
