package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.base.baseClass.BaseActivity;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.fragment.HomeFragment;
import com.housekeeper178.housekeeper_178.activity.fragment.MyFragment;
import com.housekeeper178.housekeeper_178.activity.fragment.SchoolFragment;
import com.housekeeper178.housekeeper_178.activity.fragment.ShareFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_layout)
    FrameLayout mainLayout;
    @BindView(R.id.img_home_mainActivity)
    ImageView imgHome;
    @BindView(R.id.tv_home_mainActivity)
    TextView tvHome;
    @BindView(R.id.img_school_mainActivity)
    ImageView imgSchool;
    @BindView(R.id.tv_school_mainActivity)
    TextView tvSchool;
    @BindView(R.id.img_share_mainActivity)
    ImageView imgShare;
    @BindView(R.id.tv_share_mainActivity)
    TextView tvShare;
    @BindView(R.id.img_my_mainActivity)
    ImageView imgMy;
    @BindView(R.id.tv_my_mainActivity)
    TextView tvMy;
    @BindView(R.id.linear_home_mainActivity)
    LinearLayout linearHomeMainActivity;
    @BindView(R.id.linear_share_mainActivity)
    LinearLayout linearShareMainActivity;
    @BindView(R.id.linear_my_mainActivity)
    LinearLayout linearMyMainActivity;
    private Fragment[] fgtArr;
    private int prePosition = -1;
    long time = 0;
    Context context;
    HomeFragment homeFragment;
    SchoolFragment schoolFragment;
    ShareFragment shareFragment;
    MyFragment myFragment;

    @Override
    protected void onBackKey() {
        long cur = System.currentTimeMillis();
        if (cur - time > 2000) {
            showToast("再按一次退出程序");
            time = cur;
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        context = this;
        fgtArr = new Fragment[4];
        homeFragment = new HomeFragment();
        schoolFragment = new SchoolFragment();
        shareFragment = new ShareFragment();
        myFragment = new MyFragment();
        fgtArr[0] = homeFragment;
        fgtArr[1] = schoolFragment;
        fgtArr[2] = shareFragment;
        fgtArr[3] = myFragment;
        changeFgt(0);
    }

    public void changeFgt(int curPosition) {
        if (curPosition == prePosition) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        if (prePosition != -1)
            transaction.hide(fgtArr[prePosition]);

        if (fgtArr[curPosition].isAdded()) {
            transaction.show(fgtArr[curPosition]);
        } else {
            transaction.add(R.id.main_layout, fgtArr[curPosition]).show(fgtArr[curPosition]);
        }
        transaction.commit();
        prePosition = curPosition;
    }

    private void setView() {
        tvHome.setTextColor(ContextCompat.getColor(context, R.color.text));
        tvSchool.setTextColor(ContextCompat.getColor(context, R.color.text));
        tvShare.setTextColor(ContextCompat.getColor(context, R.color.text));
        tvMy.setTextColor(ContextCompat.getColor(context, R.color.text));
        imgHome.setImageResource(R.mipmap.main_home);
        imgSchool.setImageResource(R.mipmap.main_type);
        imgShare.setImageResource(R.mipmap.main_cart);
        imgMy.setImageResource(R.mipmap.main_user);

    }

    public void setNavigationChange(ImageView img1, int icon_home_pre, TextView tv1, int themeColor) {
        setView();
        img1.setImageResource(icon_home_pre);
        tv1.setTextColor(ContextCompat.getColor(context, themeColor));
    }


    @OnClick({R.id.linear_home_mainActivity, R.id.linear_school_mainActivity, R.id.linear_share_mainActivity, R.id.linear_my_mainActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linear_home_mainActivity:
                setNavigationChange(imgHome, R.mipmap.main_home_press, tvHome, R.color.red_light);
                changeFgt(0);
                break;
            case R.id.linear_school_mainActivity:
                setNavigationChange(imgSchool, R.mipmap.main_type_press, tvSchool, R.color.red_light);
                changeFgt(1);
                break;
            case R.id.linear_share_mainActivity:
                setNavigationChange(imgShare, R.mipmap.main_cart_press, tvShare, R.color.red_light);
                changeFgt(2);
                break;
            case R.id.linear_my_mainActivity:
                setNavigationChange(imgMy, R.mipmap.main_user_press, tvMy, R.color.red_light);
                changeFgt(3);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra("pos", 0);
        changeFgt(id);


    }


}
