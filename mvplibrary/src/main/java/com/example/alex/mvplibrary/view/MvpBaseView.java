package com.example.alex.mvplibrary.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.mvplibrary.presenter.MvpPresenter;

/**
 * Created by Alex on 2016/11/30.
 *
 * 在继承这个类的View层中一定要在确认Presenter泛型
 * 否则findViewById会报转化错误，还可能有其他的错误
 * Alex
 */

public abstract class MvpBaseView<P extends MvpPresenter> implements MvpView<P> {


    /**
     * create方法生成的View
     */
    protected View rootView;

    protected P presenter ;


    @Override
    public void bindPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        rootView = layoutInflater.inflate(setLayoutId(),viewGroup,false);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                initViewSize();
            }
        });
        findMvpViews();
        setData(savedInstanceState);
        bindEvent();
        setView();
        return rootView;
    }



    /**
     * 设置和控件无关的东西，不可以包括model
     * @param savedInstanceState
     */
    protected void setData(Bundle savedInstanceState){

    }

    @Override
    public void saveInstanceState(Bundle outState) {

    }

    @Override
    public void settingActionBar(ActionBar actionBar) {

    }

    /**
     * 设置控件以及布局等等
     */
    protected void setView() {

    }

    @Override
    public <V extends View> V findViewById(int id) {
        return (V) rootView.findViewById(id);
    }

    @Override
    public void bindEvent() {

    }

    @Override
    public Toolbar getToolBar() {
        return null;
    }

    @Override
    public int getOptionsMenu() {
        return 0;
    }

    @Override
    public void ondestroy() {

    }

    protected <T extends FragmentActivity> T getContext(){
        return (T) rootView.getContext();
    }

    @Override
    public void initViewSize() {

    }
}
