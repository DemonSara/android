package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.adapter.AllOrderAdapter;

import com.housekeeper178.housekeeper_178.activity.model.ChartList;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckAllOrderActivity extends BaseActivity {
    @BindView(R.id.checkallorder_rv)
    RecyclerView checkallorderRv;
    private SharedPreferences sps;
    List<String> goodsname = new ArrayList<>();
    List<String> price = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_all_order;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sps = getSharedPreferences("userinfo", 0);
        int userid = sps.getInt("id", 0);
        new API(this, ChartList.getListClassType()).orderListSimple(userid, 2);

    }
    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.orderListSimple:
                if (base.getCode().equals("true")){
                    List<ChartList> chalist = (List<ChartList>) base.getData();
                    for (int i = 0; i < chalist.size(); i++){
                        goodsname.add(chalist.get(i).getGoodsName());
                        price.add(chalist.get(i).getTotal());
                    }
                    checkallorderRv.setAdapter(new AllOrderAdapter(this,goodsname,price));
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    checkallorderRv.setLayoutManager(layoutManager);

                }


        }
    }
}
