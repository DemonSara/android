package com.housekeeper178.housekeeper_178.activity.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.base.baseClass.BaseFragment;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.MainActivity;
import com.housekeeper178.housekeeper_178.activity.activity.OrderActivity;
import com.housekeeper178.housekeeper_178.activity.adapter.ChartListAdapter;
import com.housekeeper178.housekeeper_178.activity.model.Chart;
import com.housekeeper178.housekeeper_178.activity.model.ChartList;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.btn_shop_cart_to_pay)
    Button btnShopCartToPay;
    @BindView(R.id.rl_shop_cart_all)
    RelativeLayout rlShopCartAll;
    @BindView(R.id.btn_shop_cart_visit)
    Button btnShopCartVisit;
    @BindView(R.id.ll_shop_cart_visit)
    LinearLayout llShopCartVisit;
    private SharedPreferences spss;
    Unbinder unbinder;
    List<String> price = new ArrayList<>();
    List<String> goodsname = new ArrayList<>();
    List<Integer> did = new ArrayList<>();
     List<String> amount = new ArrayList<>();
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
        llShopCartVisit.setVisibility(View.VISIBLE);
        spss = getActivity().getSharedPreferences("userinfo", 0);
        int userid = spss.getInt("id", 0);
        new API(this, ChartList.getListClassType()).orderListSimple(userid, 1);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({ R.id.btn_shop_cart_to_pay, R.id.btn_shop_cart_visit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_shop_cart_to_pay:
                goActivity(OrderActivity.class);
                break;
            case R.id.btn_shop_cart_visit:
                goActivity(MainActivity.class);
                break;
        }
    }


    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.orderListSimple:
                if (base.getCode().equals("true")){
                    llShopCartVisit.setVisibility(View.GONE);
                    List<ChartList> chartLists = (List<ChartList>) base.getData();
                    for (int i = 0; i < chartLists.size(); i++) {
                        goodsname.add(chartLists.get(i).getGoodsName());
                        price.add(chartLists.get(i).getTotal());
                        amount.add(chartLists.get(i).getAmount());
                        did.add(chartLists.get(i).getId());
                    }
                    chartaRv.setAdapter(new ChartListAdapter(getContext(),goodsname,price,did,amount));
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    chartaRv.setLayoutManager(layoutManager);
                }

        }
    }
}
