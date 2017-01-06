package com.example.alex.mvplibrary.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.mvplibrary.presenter.MvpPresenter;

/**
 * Created by Alex on 2016/11/29.
 * Alex
 */

public interface MvpView<P extends MvpPresenter> {

    /**
     * 由于View中需要Presenter来通知model处理事件，
     * 所以需要绑定Presenter
     *
     * @param presenter
     */
    void bindPresenter(P presenter);

    /**
     * View层中需要做UI处理，所以要设置布局
     *
     * @return
     */
    int setLayoutId();

    /**
     * 通过layoutInflater配合setLayoutId来创建布局的View
     *
     * @param layoutInflater
     * @param viewGroup
     * @param savedInstanceState
     * @return
     */
    View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState);

    /**
     * 查找控件
     *
     * @param id
     * @param <V>
     * @return
     */
    <V extends View> V findViewById(int id);

    void findMvpViews();

    /**
     * 设置各种事件，例如点击事件，长按事件等等
     */
    void bindEvent();

    int getOptionsMenu();

    Toolbar getToolBar();

    void ondestroy();

    /**
     * 在这里设置有关actionbar的东西，例如设置toolbar和drawerLayout
     * 例如：
     * if (actionBar != null) {
     * actionBar.setDisplayHomeAsUpEnabled(true);
     * }
     * actionBarDrawerToggle = new ActionBarDrawerToggle(this.getContext(),main_drawer_layout,base_toolbar,R.string.open,R.string.close);
     * main_drawer_layout.addDrawerListener(actionBarDrawerToggle);
     * actionBarDrawerToggle.syncState();
     *
     * @param actionBar
     */
    void settingActionBar(ActionBar actionBar);

    /**
     * 用于测量View大小并做处理
     */
    void initViewSize();

    /**
     * 在这里保存状态
     * @param outState
     */
    void saveInstanceState(Bundle outState);


}
