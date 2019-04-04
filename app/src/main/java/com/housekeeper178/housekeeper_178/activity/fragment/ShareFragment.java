package com.housekeeper178.housekeeper_178.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.base.baseClass.BaseFragment;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.MainActivity;
import com.housekeeper178.housekeeper_178.activity.activity.OrderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 购物车
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends BaseFragment {


    @BindView(R.id.ll_shop_cart_all)
    RelativeLayout llShopCartAll;
    @BindView(R.id.charta_rv)
    RecyclerView chartaRv;
    @BindView(R.id.delete_shop_cart_all)
    Button deleteShopCartAll;
    @BindView(R.id.btn_shop_cart_to_pay)
    Button btnShopCartToPay;
    @BindView(R.id.rl_shop_cart_all)
    RelativeLayout rlShopCartAll;
    @BindView(R.id.btn_shop_cart_visit)
    Button btnShopCartVisit;
    @BindView(R.id.ll_shop_cart_visit)
    LinearLayout llShopCartVisit;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_share;
    }

    @Override
    protected void initView() {

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
                break;
            case R.id.btn_shop_cart_to_pay:
                goActivity(OrderActivity.class);
                break;
            case R.id.btn_shop_cart_visit:
                goActivity(MainActivity.class);
                break;
        }
    }
}
