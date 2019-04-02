package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.GoodsInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsiinfofromhomeActivity extends BaseActivity {
    @BindView(R.id.home_goods1)
    ImageView homeGoods1;
    @BindView(R.id.home_goods2)
    ImageView homeGoods2;
    @BindView(R.id.home_goods3)
    ImageView homeGoods3;
    @BindView(R.id.home_goods_name)
    TextView homeGoodsName;
    @BindView(R.id.home_goods_info)
    TextView homeGoodsInfo;
    @BindView(R.id.home_goods_price)
    TextView homeGoodsPrice;
    @BindView(R.id.tv_Submission_homejiarugouwuche)
    TextView tvSubmissionHomejiarugouwuche;
    private String g1;
    private String info;
    private String price;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goodsinfofromhome;
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
        String name = intent.getStringExtra("name");
        new API(this, GoodsInfo.getListClassType()).searchgoods(name);
    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.searchgoods:
                if (base.getCode().equals("true")) {
                    List<GoodsInfo> gdifs = (List<GoodsInfo>) base.getData();
                    info = gdifs.get(0).getIntro();
                    price = gdifs.get(0).getPrice();
                    name = gdifs.get(0).getName();
                    g1 = gdifs.get(0).getCover();
                    String g2 = gdifs.get(0).getImage1();
                    String g3 = gdifs.get(0).getImage2();
                    Picasso.get().load("http://47.105.161.233:8080" + g1).fit().into(homeGoods1);
                    Picasso.get().load("http://47.105.161.233:8080" + g2).fit().into(homeGoods2);
                    Picasso.get().load("http://47.105.161.233:8080" + g3).fit().into(homeGoods3);
                    homeGoodsInfo.setText(info);
                    homeGoodsPrice.setText(price);
                    homeGoodsName.setText(name);
                }
        }
    }

    @OnClick(R.id.tv_Submission_homejiarugouwuche)
    public void onViewClicked() {
        SharedPreferences.Editor sharedata = getSharedPreferences("gouwuche", 0).edit();
        sharedata.putString("image", g1);
        sharedata.putString("info", info);
        sharedata.putString("name", name);
        sharedata.putString("price", price);
        sharedata.apply();
        Toast.makeText(this, "已添加到购物车", Toast.LENGTH_SHORT).show();
    }
}
