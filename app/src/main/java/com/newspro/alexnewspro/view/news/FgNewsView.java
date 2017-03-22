package com.newspro.alexnewspro.view.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsAdapter;
import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.presenter.news.FgNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNewsView extends MvpBaseFragView<FgNews> {

    private ImageView fg_news_error_img;
    private XRecyclerView fg_news_recycler;

    private NewsAdapter newsAdapter;
    private ArrayList<ContentlistBean> dataBeenList;

    @Override
    public int setLayoutId() {
        return R.layout.fg_news;
    }

    @Override
    public void findMvpViews() {
        fg_news_recycler = findViewById(R.id.fg_news_recycler);
        fg_news_error_img = findViewById(R.id.fg_news_error_img);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_news_recycler.setLoadingListener(presenter);
    }

    public void refresh() {
//        setRefreshOver(true);
        fg_news_recycler.setRefreshing(true);
        presenter.refreshNewsList(true);
    }

    public void scrollToTop() {
        fg_news_recycler.scrollToPosition(0);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        if (savedInstanceState != null) {
            dataBeenList = (ArrayList<ContentlistBean>) savedInstanceState.getSerializable("fgNewsSaveState");
        } else {
            dataBeenList = new ArrayList<>();
        }
        newsAdapter = new NewsAdapter(presenter.getActivity(), dataBeenList);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_news_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_news_recycler.setRefreshProgressStyle(ProgressStyle.BallGridPulse);
        fg_news_recycler.setLoadingMoreProgressStyle(ProgressStyle.BallGridPulse);
        fg_news_recycler.setAdapter(newsAdapter);
        //判断如果是空的或者是第一次加载则调用加载
        if (dataBeenList.isEmpty()) {
            //初始化完毕自动调用一次获取头条列表
            refresh();
        }

    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putSerializable("fgNewsSaveState",dataBeenList);
//        outState.putParcelableArrayList("fgNewsSaveState", dataBeenList);
    }

    //------------------对外开放的方法---------------------

    public void refreshOver(List<ContentlistBean> dataBeens, boolean isRefresh) {
        if (isRefresh)
            dataBeenList.clear();
        dataBeenList.addAll(dataBeens);
        newsAdapter.notifyDataSetChanged();
        setRefreshOver(isRefresh);
        if (dataBeenList.isEmpty()) {
            fg_news_error_img.setVisibility(View.VISIBLE);
        } else {
            fg_news_error_img.setVisibility(View.GONE);
        }
    }

    public void setRefreshOver(boolean isRefresh) {
        if (isRefresh)
            fg_news_recycler.refreshComplete();
        else
            fg_news_recycler.loadMoreComplete();
    }

    public void setNoMore(){
        fg_news_recycler.setNoMore(true);
    }

    public void showError() {
        if (dataBeenList.isEmpty()) {
            fg_news_error_img.setVisibility(View.VISIBLE);
        }
    }


}
