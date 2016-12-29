package com.example.alex.mvplibrary.view;

import com.example.alex.mvplibrary.presenter.MvpPresenter;

/**
 * Created by Alex on 2016/11/30.
 * Alex
 */

public abstract class MvpBaseFragView<P extends MvpPresenter> extends MvpBaseView<P> implements MvpFragmentView {
    @Override
    public void hiddenChanged() {

    }

}
