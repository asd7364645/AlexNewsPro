package com.newspro.alexnewspro.view.user;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.presenter.user.LoginAct;
import com.statusbar_alexleo.alexstatusbarutilslib.AlexStatusBarUtils;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class LoginView extends MvpBaseView<LoginAct> {

    private Toolbar login_toolbar;
    private TextInputEditText login_pwd, login_access;
    private TextView login_register,
            login_forgot_password;
    private Button login_login_btn;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void findMvpViews() {
        login_toolbar = findViewById(R.id.base_toolbar);
        login_pwd = findViewById(R.id.login_pwd);
        login_access = findViewById(R.id.login_access);
        login_register = findViewById(R.id.login_register);
        login_forgot_password = findViewById(R.id.login_forgot_password);
        login_login_btn = findViewById(R.id.login_login_btn);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        login_login_btn.setOnClickListener(presenter);
        login_register.setOnClickListener(presenter);
    }

    @Override
    public Toolbar getToolBar() {
        login_toolbar.setTitle(R.string.login);
        return login_toolbar;
    }

    @Override
    public void settingActionBar(ActionBar actionBar) {
        super.settingActionBar(actionBar);
        AlexStatusBarUtils.setTransparentStatusBar(presenter, login_toolbar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        login_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.finish();
            }
        });
    }

    //----------公共方法----------
    public String getAcc(){
        return login_access.getText().toString();
    }

    public String getPwd(){
        return login_pwd.getText().toString();
    }

    public void setAccText(String accText){
        login_access.setText(accText);
    }

    public void setAccErr(String message){
        login_access.setError(message);
    }
    public void setPwdErr(String message){
        login_pwd.setError(message);
    }

//    public void resetError() {
//        login_access.setError(null);
//        login_pwd.setError(null);
//    }
}
