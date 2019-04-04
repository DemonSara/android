package com.housekeeper178.housekeeper_178.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.baseClass.BaseFragment;
import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.LoginActivity;
import com.housekeeper178.housekeeper_178.activity.adapter.fenleitype;
import com.housekeeper178.housekeeper_178.activity.model.TypeGoods;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends BaseFragment {


    @BindView(R.id.fragmentfenlei_rv)
    RecyclerView fragmentfenleiRv;
    Unbinder unbinder;
    List<String> typename = new ArrayList<>();
    List<Integer> id = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_school;
    }

    @Override
    protected void initView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        new API(this, TypeGoods.getListClassType()).typelist();
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
            case API.whichAPI.typelist:
                if (base.getCode().equals("true")) {
                    List<TypeGoods> typeGoods = (List<TypeGoods>) base.getData();
                    for (int i = 0; i < typeGoods.size(); i++) {
                        typename.add(typeGoods.get(i).getName());
                        id.add(typeGoods.get(i).getId());

                    }
                    fragmentfenleiRv.setAdapter(new fenleitype(getContext(),typename,id));
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    fragmentfenleiRv.setLayoutManager(layoutManager);

                }
        }
    }
}
