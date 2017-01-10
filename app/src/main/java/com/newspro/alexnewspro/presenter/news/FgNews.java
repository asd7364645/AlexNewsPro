package com.newspro.alexnewspro.presenter.news;

import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.event.NewsActionBtnEvent;
import com.newspro.alexnewspro.event.NewsLoadingEvent;
import com.newspro.alexnewspro.event.NewsRefreshEvent;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.model.bean.NewsBean;
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

public class FgNews extends MvpBaseFrag<FgNewsView> implements XRecyclerView.LoadingListener {

    private NewsModel newsModel;
    private String type;
    private int page = 1;
    private boolean isLoading = false;
    private int maxPage = -1;

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

    @Override
    public void onLoadMore() {

        if (isNoMore()) {
            mvpView.setNoMore();
            return;
        }

        if (!isLoading)
            refreshNewsList(false);
    }

    /**
     * 刷新列表
     *
     * @param isRefresh 判断是否为刷新，true：刷新，false：加载
     */
    public void refreshNewsList(final boolean isRefresh) {
        isLoading = true;
        EventBus.getDefault().post(new NewsLoadingEvent(true));
        if (isRefresh) {
            page = 1;
        } else {
            page = ++page;
        }
        newsModel.getNewsOfType(type, page, new MvpModelCallBack<NewsBean.ShowapiResBodyBean.PagebeanBean>() {
            @Override
            public void result(NewsBean.ShowapiResBodyBean.PagebeanBean data) {
                maxPage = data.getAllPages();
                List<PagebeanBean.ContentlistBean> list = data.getContentlist();
                if (mvpView != null)
                    mvpView.refreshOver(list, isRefresh);
                isLoading = false;
                sendActionRefreshOverEvent();
                ToastUtils.showShort(getContext(), Constant.NEWS_TITLES_MAP.get(type) + " 加载成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (page > 1)
                    page--;
                isLoading = false;
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "类型：" + Constant.NEWS_TITLES_MAP.get(type) + ",原因：" + data);
                    mvpView.setRefreshOver(isRefresh);
                    mvpView.showError();
                    sendActionRefreshOverEvent();
                }
            }
        });
    }

    private boolean isNoMore() {
        return maxPage != -1 && page == maxPage;
    }

    /**
     * 发送点击刷新按钮并刷新成功事件的方法
     */
    private void sendActionRefreshOverEvent() {
        EventBus.getDefault().post(new NewsActionBtnEvent(true));
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

}
