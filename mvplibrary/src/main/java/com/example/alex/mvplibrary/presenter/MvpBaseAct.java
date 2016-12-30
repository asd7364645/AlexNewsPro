package com.example.alex.mvplibrary.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.alex.mvplibrary.helper.GenericHelper;
import com.example.alex.mvplibrary.view.MvpView;

/**
 * Created by Alex on 2016/11/30.
 * Alex
 */

public abstract class MvpBaseAct<V extends MvpView> extends AppCompatActivity implements MvpPresenter<V> {

    protected V mvpView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create(savedInstanceState);
        try {
            //初始化mvpView
            mvpView = getViewClass().newInstance();
            mvpView.bindPresenter(this);
            setContentView(mvpView.createView(getLayoutInflater(), null, savedInstanceState));
            setToolBar(mvpView.getToolBar());
            if (getSupportActionBar() != null)
                mvpView.settingActionBar(getSupportActionBar());
            created(savedInstanceState);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Bundle saveInstance) {

    }

    @Override
    public void created(Bundle saveInstance) {
    }

//    @Override
//    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onPostCreate(savedInstanceState, persistentState);
//        mvpView.initViewSize();
//    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus){
//            mvpView.initViewSize();
//        }
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mvpView != null) {
            mvpView.saveInstanceState(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mvpView == null) {
            //初始化mvpView
            try {
                mvpView = getViewClass().newInstance();
                mvpView.bindPresenter(this);
                mvpView.createView(getLayoutInflater(), null, savedInstanceState);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mvpView.getOptionsMenu() != 0) {
            getMenuInflater().inflate(mvpView.getOptionsMenu(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        mvpView.ondestroy();
        mvpView = null;
        super.onDestroy();
    }

    @Override
    public Class<V> getViewClass() {
        return GenericHelper.GenericToClass(getClass());
    }

    public void setToolBar(Toolbar toolBar) {
        if (toolBar != null) {
            setSupportActionBar(toolBar);
        }
    }
}
