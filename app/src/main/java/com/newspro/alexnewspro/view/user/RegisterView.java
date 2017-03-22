package com.newspro.alexnewspro.view.user;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.presenter.user.RegisterAct;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class RegisterView extends MvpBaseView<RegisterAct> {

    private Toolbar register_toolbar;

    private RadioGroup register_rg;
    private LinearLayout phone_code_layout;

    private TextInputEditText register_acc,
            register_pwd, phone_edit, auth_code,
            register_repeat_pwd;
    private Button register_register_btn, send_code_btn;

    @Override
    public int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void findMvpViews() {
        register_toolbar = findViewById(R.id.base_toolbar);
        phone_code_layout = findViewById(R.id.register_phone_layout);
        phone_edit = findViewById(R.id.phone_edit);
        auth_code = findViewById(R.id.auth_code);
        send_code_btn = findViewById(R.id.send_code_btn);
        register_rg = findViewById(R.id.register_rg);
        register_acc = findViewById(R.id.register_acc);
        register_pwd = findViewById(R.id.register_pwd);
        register_repeat_pwd = findViewById(R.id.register_repeat_pwd);
        register_register_btn = findViewById(R.id.register_register_btn);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        register_register_btn.setOnClickListener(presenter);
        register_rg.setOnCheckedChangeListener(presenter);
        send_code_btn.setOnClickListener(presenter);
    }

    @Override
    public Toolbar getToolBar() {
        return register_toolbar;
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);
        register_toolbar.setTitle(R.string.register);
        actionBar.setDisplayHomeAsUpEnabled(true);
        register_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.finish();
            }
        });
    }

    /**
     * 设置是否是手机注册模式
     *
     * @param isPhone
     */
    public void setIsPhoneRegister(boolean isPhone) {
        if (isPhone) {
            phone_code_layout.setVisibility(View.VISIBLE);
        } else {
            phone_code_layout.setVisibility(View.GONE);
        }
    }

    public void setSendBtnEnable(boolean isEnable){
        send_code_btn.setEnabled(isEnable);
    }

    public void setSendBtnText(String s){
        send_code_btn.setText(s);
    }

    public String getAcc() {
        return register_acc.getText().toString();
    }

    public String getPwd() {
        return register_pwd.getText().toString();
    }

    public String getRePwd() {
        return register_repeat_pwd.getText().toString();
    }

    public void setAccError(String s) {
        register_acc.setError(s);
    }

    public void setPwdError(String s) {
        register_pwd.setError(s);
    }

    public void setRePwdError(String s) {
        register_repeat_pwd.setError(s);
        register_repeat_pwd.setText("");
    }

    public String getPhone() {
        return phone_edit.getText().toString();
    }

    public void setPhoneError(String s) {
        phone_edit.setError(s);
    }

    public String getAuthCode() {
        return auth_code.getText().toString();
    }

    public void setAuthCodeError(String s) {
        auth_code.setError(s);
    }
}
