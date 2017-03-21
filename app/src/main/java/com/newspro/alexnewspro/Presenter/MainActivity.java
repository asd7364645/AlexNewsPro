package com.newspro.alexnewspro.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.presenter.user.LoginAct;
import com.newspro.alexnewspro.utils.BmobUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.MainView;

public class MainActivity extends MvpBaseAct<MainView, MvpModel>
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_navigation_news:
                mvpView.closeDrawer();
                mvpView.selectFg(0);
                break;
            case R.id.menu_navigation_imgs:
                mvpView.closeDrawer();
                mvpView.selectFg(1);
                break;
            case R.id.menu_navigation_movies:
                mvpView.closeDrawer();
                mvpView.selectFg(2);
                break;
        }
        return true;
    }


    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        BmobUtils.UserUtils.initUser();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BmobUtils.UserUtils.isLogin()) {
            mvpView.userIsLogin(BmobUtils.UserUtils.getmBmobUser().getUsername());
        } else {
            mvpView.userIsLogOut();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.md_header_login_tv:
                if (BmobUtils.UserUtils.isLogin()) {
                    BmobUtils.UserUtils.logout();
                    ToastUtils.showShort(this,"退出成功");
                    mvpView.userIsLogOut();
                } else {
                    startActivity(new Intent(this, LoginAct.class));
                }
                break;
        }
    }
}
