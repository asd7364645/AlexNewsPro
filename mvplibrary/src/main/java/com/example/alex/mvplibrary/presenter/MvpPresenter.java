package com.example.alex.mvplibrary.presenter;

import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelInterface;
import com.example.alex.mvplibrary.view.MvpView;

/**
 * Created by Alex on 2016/11/29.
 * presenter接口,用于连接view和model
 * Alex
 */

public interface MvpPresenter<V extends MvpView, M extends MvpModelInterface> {

    /**
     * 用于获取presenter中View的类，并在Mvp的基类中实例化它
     *
     * @return
     */
    Class<V> getViewClass();

    /**
     * 用于获取presenter中Model的类，并在Mvp的基类中实例化它
     *
     * @return
     */
    Class<M> getModelClass();

    /**
     * 在View初始化之前做一些事情,比如设置屏幕样式，全屏什么的
     *
     * @param saveInstance 用于在activity恢复
     */
    void create(Bundle saveInstance);

    /**
     * 在View初始化完毕做一些事情
     *
     * @param saveInstance
     */
    void created(Bundle saveInstance);

}
