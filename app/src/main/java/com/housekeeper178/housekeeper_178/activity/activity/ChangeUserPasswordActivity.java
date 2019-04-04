package com.housekeeper178.housekeeper_178.activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.base.baseClass.BaseActivity;
import com.base.model.Base;
import com.base.util.Tool;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.model.UserInfo;
import com.housekeeper178.housekeeper_178.activity.net.API;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeUserPasswordActivity extends BaseActivity {
    @BindView(R.id.et_username_changeActivity)
    EditText etUsernameChangeActivity;
    @BindView(R.id.et_oldpsw_changeActivity)
    EditText etOldpswChangeActivity;
    @BindView(R.id.et_newpsw_changeActivity)
    EditText etNewpswChangeActivity;
    @BindView(R.id.bt_golo_changeActivity)
    Button btGoloChangeActivity;
    @BindView(R.id.bt_ensure_changeActivity)
    Button btEnsureChangeActivity;
    private String username;
    SharedPreferences sharedPreferences;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changeuserpassword;
    }

    @Override
    protected void initView() {

    }

    private void changepsw() {
        String old = Tool.getTextViewContent(etOldpswChangeActivity);
        String ne = Tool.getTextViewContent(etNewpswChangeActivity);
        new API(this, Base.getClassType()).changeuserpsw(username, old, ne);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("userinfo", 0);
        username = sharedPreferences.getString("username", "");
        etUsernameChangeActivity.setText(username);
    }


    @OnClick({R.id.bt_ensure_changeActivity, R.id.bt_golo_changeActivity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ensure_changeActivity:
                changepsw();
                break;
            case R.id.bt_golo_changeActivity:
                goActivity(LoginActivity.class);
                break;
        }
    }

    @Override
    public void onCompleteData(Base base, int whichAPI) {
        super.onCompleteData(base, whichAPI);
        closeLoadingDialog();
        switch (whichAPI){
            case API.whichAPI.changeuserpsw:
                if (base.getCode().equals("true")){
                    Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                }
        }
    }
}
