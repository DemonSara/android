package com.housekeeper178.housekeeper_178.activity.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.base.baseClass.BaseFragment;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.MainActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 购物车
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends BaseFragment {

    Unbinder unbinder;


    @BindView(R.id.rl_shop_cart_all)
    RelativeLayout rlShopCartAll;

    @BindView(R.id.ll_shop_cart_visit)
    LinearLayout llShopCartVisit;
    @BindView(R.id.rcv_shop_cart)
    LinearLayout rcvShopCart;
    @BindView(R.id.img_gouwucheimage)
    ImageView imgGouwucheimage;
    @BindView(R.id.tv_shopname_myorderfragment)
    TextView tvShopnameMyorderfragment;
    @BindView(R.id.tv_gouwucheprice)
    TextView tvGouwucheprice;
    @BindView(R.id.tv_gouwuchename)
    TextView tvGouwuchename;
    @BindView(R.id.delete_shop_cart_all)
    Button deleteShopCartAll;
    @BindView(R.id.btn_shop_cart_to_pay)
    Button btnShopCartToPay;
    @BindView(R.id.btn_shop_cart_visit)
    Button btnShopCartVisit;


    private SharedPreferences sp;
    private String image;
    private String info;
    private String name;
    private String price;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_share;
    }

    @Override
    protected void initView() {
        sp = getActivity().getSharedPreferences("gouwuche", 0);
        image = sp.getString("image", "");
        info = sp.getString("info", "");
        name = sp.getString("name", "");
        price = sp.getString("price", "");
        if (name == null || name.equals("")) {
            rlShopCartAll.setVisibility(View.GONE);
            rcvShopCart.setVisibility(View.GONE);
            llShopCartVisit.setVisibility(View.VISIBLE);
        } else {
            rlShopCartAll.setVisibility(View.VISIBLE);
            rcvShopCart.setVisibility(View.VISIBLE);
            llShopCartVisit.setVisibility(View.GONE);
        }
        Picasso.get().load("http://47.105.161.233:8080" + image).fit().into(imgGouwucheimage);
        tvShopnameMyorderfragment.setText(info);
        tvGouwucheprice.setText(price);
        tvGouwuchename.setText(name);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.delete_shop_cart_all, R.id.btn_shop_cart_to_pay, R.id.btn_shop_cart_visit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.delete_shop_cart_all:
                rlShopCartAll.setVisibility(View.GONE);
                rcvShopCart.setVisibility(View.GONE);
                llShopCartVisit.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_shop_cart_to_pay:
                break;
            case R.id.btn_shop_cart_visit:
                goActivity(MainActivity.class);
                break;
        }
    }
}
