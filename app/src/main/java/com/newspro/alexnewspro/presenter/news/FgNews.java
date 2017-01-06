package com.newspro.alexnewspro.presenter.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.adapter.listview.NewsAdapter;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.event.NewsActionBtnEvent;
import com.newspro.alexnewspro.event.NewsLoadingEvent;
import com.newspro.alexnewspro.event.NewsRefreshEvent;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.news.FgNewsView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNews extends MvpBaseFrag<FgNewsView> implements SwipeRefreshLayout.OnRefreshListener, NewsAdapter.IsEndListener {

    private NewsModel newsModel;
    private String type;
    private int page = 1;
    private boolean isLoading = false;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        newsModel = new NewsModel();
        Bundle arguments = getArguments();
        type = arguments.getString(Constant.NEWS_TYPE_STR);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onRefresh() {
        refreshNewsList(true);
    }

    /**
     * 刷新列表
     *
     * @param isRefresh 判断是否为刷新，true：刷新，false：加载
     */
    public void refreshNewsList(final boolean isRefresh) {
        isLoading = true;
        EventBus.getDefault().post(new NewsLoadingEvent(true));
        if (isRefresh)
            page = 1;
        else page = ++page;
        newsModel.getNewsOfType(type, page, new MvpModelCallBack<List>() {
            @Override
            public void result(List data) {
                if (mvpView != null)
                    mvpView.refreshOver((List<PagebeanBean.ContentlistBean>) data, isRefresh);
                isLoading = false;
                sendActionRefreshOverEvent();
                ToastUtils.showShort(getContext(),Constant.NEWS_TITLES_MAP.get(type)+" 加载成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                isLoading = false;
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "类型：" + Constant.NEWS_TITLES_MAP.get(type) + ",原因：" + data);
                    mvpView.setRefreshLayoutRefresh(false);
                    mvpView.showError();
                    sendActionRefreshOverEvent();
                }
            }
        });
    }

    /**
     * 发送点击刷新按钮并刷新成功事件的方法
     */
    private void sendActionRefreshOverEvent() {
        EventBus.getDefault().post(new NewsActionBtnEvent(true));
    }

    @Override
    public void isEnd() {
        if (!isLoading)
            refreshNewsList(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 接收eventBus发送来的数据并做处理
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void actionRefresh(NewsRefreshEvent event) {
        if (event.getType().equals(this.type)) {
            page = 1;
            mvpView.refresh();
            mvpView.scrollToTop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        //在销毁时如果网络访问没结束则取消网络访问
        if (newsModel.getNewsBeanCall() != null && !newsModel.getNewsBeanCall().isCanceled()) {
            newsModel.getNewsBeanCall().cancel();
        }
    }

    public String getType() {
        return type;
    }
}
