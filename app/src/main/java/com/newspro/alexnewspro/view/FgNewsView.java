package com.newspro.alexnewspro.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.alex.mvplibrary.presenter.MvpPresenter;
import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.Presenter.FgNews;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsAdapter;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNewsView extends MvpBaseFragView<FgNews> {

    private ImageView fg_news_error_img;

    private SwipeRefreshLayout fg_news_refresh;
    private RecyclerView fg_news_recycler;

    private NewsAdapter newsAdapter;
    private ArrayList<ShowapiResBodyBean.PagebeanBean.ContentlistBean> dataBeenList;

    @Override
    public int setLayoutId() {
        return R.layout.fg_news;
    }

    @Override
    public void findMvpViews() {
        fg_news_refresh = findViewById(R.id.fg_news_refresh);
        fg_news_recycler = findViewById(R.id.fg_news_recycler);
        fg_news_error_img = findViewById(R.id.fg_news_error_img);
    }

    @Override
    public void bindEvent(MvpPresenter presenter) {
        super.bindEvent(presenter);
        fg_news_refresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) presenter);
    }

    @Override
    protected void setView() {
        super.setView();
        if (dataBeenList.isEmpty()) {
            //初始化完毕自动调用一次获取头条列表
            setRefresh(true);
            presenter.refreshNewsList();
        }

    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        if (savedInstanceState != null) {
            dataBeenList = savedInstanceState.getParcelableArrayList("fgNewsSaveState");
        } else {
            dataBeenList = new ArrayList<>();
        }
        newsAdapter = new NewsAdapter(presenter.getActivity(), dataBeenList);
        fg_news_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_news_recycler.setAdapter(newsAdapter);
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putParcelableArrayList("fgNewsSaveState", dataBeenList);
    }

    public void refreshOver(List<ShowapiResBodyBean.PagebeanBean.ContentlistBean> dataBeens) {
        dataBeenList.clear();
        dataBeenList.addAll(dataBeens);
        newsAdapter.notifyDataSetChanged();
        setRefresh(false);
        if (dataBeenList.isEmpty()) {
            fg_news_error_img.setVisibility(View.VISIBLE);
        } else {
            fg_news_error_img.setVisibility(View.GONE);
        }
    }

    public void setRefresh(final boolean refresh) {
        fg_news_refresh.post(new Runnable() {
            @Override
            public void run() {
                fg_news_refresh.setRefreshing(refresh);
            }
        });
    }

    public void showError() {
        if (dataBeenList.isEmpty()) {
            fg_news_error_img.setVisibility(View.VISIBLE);
        }
    }


}
