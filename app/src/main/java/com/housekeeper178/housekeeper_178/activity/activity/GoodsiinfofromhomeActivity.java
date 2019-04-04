package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.google.gson.Gson;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.Chart;
import com.housekeeper178.housekeeper_178.activity.model.GoodsInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.housekeeper178.housekeeper_178.activity.activity.ChangeAddressActivity.JSON;

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
    private String goodid;
    private int userid;
    SharedPreferences sps;

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
        sps = getSharedPreferences("userinfo", 0);
        userid = sps.getInt("id", 0);
    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.searchgoods:
                if (base.getCode().equals("true")) {
                    List<GoodsInfo> gdifs = (List<GoodsInfo>) base.getData();
                    goodid = gdifs.get(0).getId();
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
    private void addcharttt(){
        Chart gooooods = new Chart();
        Chart.ItemListBean itemListBean = new Chart.ItemListBean();
        List<Chart.ItemListBean> itemList = new ArrayList<>();
        itemListBean.setAmount(1);
        itemListBean.setGoods_id(Integer.parseInt(goodid));
        itemList.add(itemListBean);
        gooooods.setItemList(itemList);
        gooooods.setPaytype(1);
        gooooods.setStatus(1);
        gooooods.setUser_id(userid);
        String jsonObject = new Gson().toJson(gooooods);
        System.out.println(jsonObject);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, jsonObject);
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://47.105.161.233:8080/greenshop/app/order_confirm")
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("motherfucker");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null) {
                    goActivity(MainActivity.class);

                }
            }
        });
    }

    @OnClick(R.id.tv_Submission_homejiarugouwuche)
    public void onViewClicked() {
        addcharttt();
    }
}
