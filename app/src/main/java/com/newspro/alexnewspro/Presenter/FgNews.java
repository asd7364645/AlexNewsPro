package com.newspro.alexnewspro.Presenter;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.FgNewsView;

import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNews extends MvpBaseFrag<FgNewsView> implements SwipeRefreshLayout.OnRefreshListener {

    private NewsModel newsModel;
    private String type;
    private int page = 0;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        newsModel = new NewsModel();
        Bundle arguments = getArguments();
        type = arguments.getString(Constant.NEWS_TYPE_STR);
    }

    @Override
    public void onRefresh() {
        refreshNewsList();
    }

    public void refreshNewsList() {
        newsModel.getNewsOfType(type, 0, new MvpModelCallBack<List>() {
            @Override
            public void result(List data) {
                if (mvpView != null)
                    mvpView.refreshOver((List<PagebeanBean.ContentlistBean>) data);
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "类型：" + Constant.NEWS_TITLES_MAP.get(type) + ",原因：" + data);
                    mvpView.setRefresh(false);
                    mvpView.showError();
                }
            }
        });
    }
}
