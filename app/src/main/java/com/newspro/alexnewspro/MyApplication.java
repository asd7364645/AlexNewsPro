package com.newspro.alexnewspro;

import android.app.Application;

import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.utils.BmobUtils;

import cn.bmob.v3.Bmob;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.BMOB_APPKEY);
        BmobUtils.UserUtils.initUser();
    }
}
