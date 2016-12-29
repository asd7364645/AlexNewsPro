package com.example.alex.mvplibrary.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.mvplibrary.helper.GenericHelper;
import com.example.alex.mvplibrary.view.MvpBaseFragView;

/**
 * Created by Alex on 2016/12/2.
 * Alex
 */

public abstract class MvpBaseFrag<V extends MvpBaseFragView> extends Fragment implements MvpPresenter<V> {
    protected V mvpView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        create(savedInstanceState);
        View rootView = null;
        try {
            //初始化mvpView
            mvpView = getViewClass().newInstance();
            mvpView.bindPresenter(this);
            rootView = mvpView.createView(inflater, container, savedInstanceState);
            created(savedInstanceState);
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return rootView;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mvpView != null) {
            mvpView.hiddenChanged();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpView.initViewSize();
    }

    @Override
    public void create(Bundle saveInstance) {

    }

    @Override
    public void created(Bundle saveInstance) {

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mvpView == null) {
            //初始化mvpView
            try {
                mvpView = getViewClass().newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mvpView!=null){
            mvpView.saveInstanceState(outState);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (mvpView.getOptionsMenu() != 0) {
            inflater.inflate(mvpView.getOptionsMenu(), menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroy() {
        mvpView.ondestroy();
        mvpView = null;
        super.onDestroy();
    }

    @Override
    public Class<V> getViewClass() {
        return GenericHelper.GenericToClass(getClass());
    }

}
