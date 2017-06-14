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
import com.newspro.alexnewspro.event.user.UserIsLoginEvent;
import com.newspro.alexnewspro.presenter.user.LoginAct;
import com.newspro.alexnewspro.utils.BmobUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends MvpBaseAct<MainView, MvpModel>
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private long oldTime;

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
            case R.id.menu_navigation_uinfo:
                BmobUtils.UserUtils.logout();
                ToastUtils.showShort(this, "退出成功");
                mvpView.userIsLogOut();
                break;
            case R.id.menu_navigation_baisibudejie:
                mvpView.closeDrawer();
                mvpView.selectFg(3);
                break;
        }
        return true;
    }


    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        //注册用户登录状态改变事件
        EventBus.getDefault().register(this);
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        if (BmobUtils.UserUtils.isLogin()) {
            mvpView.userIsLogin(BmobUtils.UserUtils.getmBmobUser().getUsername());
        } else {
            mvpView.userIsLogOut();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void changeLogin(UserIsLoginEvent event) {
        if (event.isLogin()) {
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
                    ToastUtils.showShort(this, "退出成功");
                    mvpView.userIsLogOut();
                    EventBus.getDefault().post(new UserIsLoginEvent(false));
                } else {
                    startActivity(new Intent(this, LoginAct.class));
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        if (mvpView.isOpenDrawer()) {
            mvpView.closeDrawer();
        } else {
            long currentTime = System.currentTimeMillis();
            if (currentTime - oldTime > 2000) {
                ToastUtils.showShort(this, "再次点击返回键退出");
                oldTime = currentTime;
            } else {
                finish();
                System.exit(0);
            }
        }
    }
}
