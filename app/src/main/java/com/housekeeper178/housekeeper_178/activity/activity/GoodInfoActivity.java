package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;
import com.base.util.Tool;
import com.google.gson.Gson;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.Chart;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class GoodInfoActivity extends BaseActivity {
    @BindView(R.id.goods_1)
    ImageView goods1;
    @BindView(R.id.goods_2)
    ImageView goods2;
    @BindView(R.id.goods_3)
    ImageView goods3;
    @BindView(R.id.tv_goodinfo)
    TextView tvGoodinfo;
    @BindView(R.id.tv_price_goodinfo)
    TextView tvPriceGoodinfo;
    @BindView(R.id.tv_Submission_CardApplicationActivity)
    TextView tvSubmissionCardApplicationActivity;
    @BindView(R.id.goodsinfo_et_amount)
    EditText goodsinfoEtAmount;
    private int idididid;
    SharedPreferences sps;
    public String gid;
    public String g1;
    public String g2;
    public String g3;
    public String tginfo;
    public String tgprice;
    public String infoname;
    private int i = 1;

    Map<String, Integer> map = new HashMap<>();
    List<Map<String, Integer>> lm = new ArrayList<>();
    @BindView(R.id.good_info_name)
    TextView goodInfoName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goodinfo;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Bundle b = this.getIntent().getExtras();
        gid = (String) b.get("goodsid");
        g1 = (String) b.get("goods1");
        g2 = (String) b.get("goods2");
        g3 = (String) b.get("goods3");
        tginfo = (String) b.get("tvGoodinfo");
        tgprice = (String) b.get("tvPriceGoodinfo");
        infoname = (String) b.get("goodsinfoname");

        Picasso.get().load("http://47.105.161.233:8080" + g1).fit().into(goods1);
        Picasso.get().load("http://47.105.161.233:8080" + g2).fit().into(goods2);
        Picasso.get().load("http://47.105.161.233:8080" + g3).fit().into(goods3);
        tvGoodinfo.setText(tginfo);
        tvPriceGoodinfo.setText(tgprice);
        goodInfoName.setText(infoname);

        sps = getSharedPreferences("userinfo", 0);
        idididid = sps.getInt("id", 0);


    }

    public void addchart() {
        int et = Integer.parseInt(Tool.getTextViewContent(goodsinfoEtAmount));
        Chart gooooods = new Chart();
        Chart.ItemListBean itemListBean = new Chart.ItemListBean();
        List<Chart.ItemListBean> itemList = new ArrayList<>();
        itemListBean.setAmount(et);
        itemListBean.setGoods_id(Integer.parseInt(gid));
        itemList.add(itemListBean);
        gooooods.setItemList(itemList);
        gooooods.setPaytype(1);
        gooooods.setStatus(1);
        gooooods.setUser_id(idididid);
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

    @OnClick(R.id.tv_Submission_CardApplicationActivity)
    public void onViewClicked() {
        addchart();
    }
}
