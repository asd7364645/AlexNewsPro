package com.example.alex.mvplibrary.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.mvplibrary.presenter.MvpPresenter;

/**
 * Created by Alex on 2016/11/30.
 * Alex
 */

public abstract class MvpBaseView implements MvpView {

    /**
     * create方法生成的View
     */
    protected View rootView;

    protected MvpPresenter presenter ;

    @Override
    public void bindPresenter(MvpPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        rootView = layoutInflater.inflate(setLayoutId(),viewGroup,false);
        findMvpViews();
        bindEvent(presenter);
        setData();
        setView();
        return rootView;
    }

    /**
     * 设置和控件无关的东西，不可以包括model
     */
    protected void setData(){

    }

    @Override
    public void settingActionBar(ActionBar actionBar) {

    }

    protected void setView() {

    }

    @Override
    public <V extends View> V findViewById(int id) {
        return (V) rootView.findViewById(id);
    }

    @Override
    public void bindEvent(MvpPresenter presenter) {

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

    protected <T extends AppCompatActivity> T getContext(){
        return (T) rootView.getContext();
    }

    @Override
    public void initViewSize() {

    }
}
