package com.housekeeper178.housekeeper_178.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.base.baseClass.BaseFragment;
import com.base.model.Base;
import com.base.util.Tool;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.GoodInfoActivity;
import com.housekeeper178.housekeeper_178.activity.activity.LoginActivity;
import com.housekeeper178.housekeeper_178.activity.adapter.AhomefragmentRv;

import com.housekeeper178.housekeeper_178.activity.model.GoodsInfo;
import com.housekeeper178.housekeeper_178.activity.model.Hotgood;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 2018/12/29
 *
 * @TODO:首页
 */
public class HomeFragment extends BaseFragment  {


    @BindView(R.id.home_rv)
    RecyclerView homeRv;
    Unbinder unbinder;
    List<String> price = new ArrayList<>();
    List<String> name = new ArrayList<>();
    List<String> imgurl = new ArrayList<>();
    @BindView(R.id.tv_search_ShopActivity)
    TextView tvSearchShopActivity;
    @BindView(R.id.et_content_ShopActivity)
    EditText etContentShopActivity;
    AhomefragmentRv adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    private void dosearch() {
        String keyword = Tool.getTextViewContent(etContentShopActivity);
        new API(this, GoodsInfo.getListClassType()).searchgoods(keyword);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        new API(this, Hotgood.getListClassType()).itemhot(2);


        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI) {
            case API.whichAPI.searchgoods:
                if (base.getCode().equals("true")) {
                    List<GoodsInfo> goodsInfos = (List<GoodsInfo>) base.getData();
                    Map<String,String> m = new HashMap<>();
                    m.put("goods1",goodsInfos.get(0).getCover());
                    m.put("goods2",goodsInfos.get(0).getImage1());
                    m.put("goods3",goodsInfos.get(0).getImage2());
                    m.put("tvGoodinfo",goodsInfos.get(0).getIntro());
                    m.put("tvPriceGoodinfo",goodsInfos.get(0).getPrice());
                    m.put("goodsinfoname",goodsInfos.get(0).getName());
                    m.put("goodsid",goodsInfos.get(0).getId());

                   goActivity(m,GoodInfoActivity.class);

                }

                break;


            case API.whichAPI.itemhot:
                if (base.getCode().equals("true")) {
                    List<Hotgood> hg = (List<Hotgood>) base.getData();
                    for (int i = 0; i < 5; i++) {
                        imgurl.add(hg.get(i).getCover());
                        name.add(hg.get(i).getName());
                        price.add(hg.get(i).getPrice());
                    }
                    homeRv.setAdapter(new AhomefragmentRv(imgurl, name, price, getContext()));
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                    homeRv.setLayoutManager(gridLayoutManager);


                }
                break;

        }

    }

    @OnClick(R.id.tv_search_ShopActivity)
    public void onViewClicked() {
        dosearch();
    }


}

