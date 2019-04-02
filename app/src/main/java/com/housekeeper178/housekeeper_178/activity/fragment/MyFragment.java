package com.housekeeper178.housekeeper_178.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.base.baseClass.BaseFragment;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.AddressActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.my_quanbudingdan)
    RelativeLayout myQuanbudingdan;
    @BindView(R.id.my_shouhuodizhi)
    RelativeLayout myShouhuodizhi;
    @BindView(R.id.my_xiugaiyonhumima)
    RelativeLayout myXiugaiyonhumima;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
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

    @OnClick({R.id.my_quanbudingdan, R.id.my_shouhuodizhi, R.id.my_xiugaiyonhumima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_quanbudingdan:
                break;
            case R.id.my_shouhuodizhi:
                goActivity(AddressActivity.class);
                break;
            case R.id.my_xiugaiyonhumima:
                break;
        }
    }
}
