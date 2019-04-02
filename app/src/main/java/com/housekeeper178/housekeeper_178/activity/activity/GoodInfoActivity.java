package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.fragment.ShareFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    //    Bundle b = this.getIntent().getExtras();
////    String g1 = (String) b.get("goods1");
////    String g2 = (String) b.get("goods2");
////    String g3 = (String) b.get("goods3");
////    String tginfo = (String) b.get("tvGoodinfo");
////    String tgprice = (String) b.get("tvPriceGoodinfo");
    public  String gid;
    public String g1;
    public String g2;
    public String g3;
    public String tginfo;
    public String tgprice;
    public String infoname;
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
    }

    @OnClick(R.id.tv_Submission_CardApplicationActivity)
    public void onViewClicked() {

        Toast.makeText(this,"已添加到购物车",Toast.LENGTH_SHORT).show();

    }
}
