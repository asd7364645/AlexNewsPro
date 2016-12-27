package com.newspro.alexnewspro.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alex.mvplibrary.presenter.MvpPresenter;
import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsAdapter;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNewsView extends MvpBaseFragView {

    private SwipeRefreshLayout fg_news_refresh;
    private RecyclerView fg_news_recycler;

    private NewsAdapter newsAdapter;
    private List<ShowapiResBodyBean.PagebeanBean.ContentlistBean> dataBeenList;

    @Override
    public int setLayoutId() {
        return R.layout.fg_news;
    }

    @Override
    public void findMvpViews() {
        fg_news_refresh = findViewById(R.id.fg_news_refresh);
        fg_news_recycler = findViewById(R.id.fg_news_recycler);
    }

    @Override
    public void bindEvent(MvpPresenter presenter) {
        super.bindEvent(presenter);
        fg_news_refresh.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) presenter);
    }

    @Override
    protected void setData() {
        super.setData();
        dataBeenList = new ArrayList<>();
        newsAdapter = new NewsAdapter(this.getContext(), dataBeenList);
        fg_news_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_news_recycler.setAdapter(newsAdapter);
    }

    @Override
    public void ondestroy() {
        super.ondestroy();
        System.out.println("œ˙ªŸ¡À£°£°£°");
    }

    public void refreshOver(List<ShowapiResBodyBean.PagebeanBean.ContentlistBean> dataBeens) {
        dataBeenList.clear();
        dataBeenList.addAll(dataBeens);
        newsAdapter.notifyDataSetChanged();
        setRefresh(false);
    }

    public void setRefresh(final boolean refresh){
        fg_news_refresh.post(new Runnable() {
            @Override
            public void run() {
                fg_news_refresh.setRefreshing(refresh);
            }
        });
    }


}
