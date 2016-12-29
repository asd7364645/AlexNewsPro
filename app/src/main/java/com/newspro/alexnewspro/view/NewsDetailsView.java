package com.newspro.alexnewspro.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.Presenter.NewsDetailsAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.NewsDetailsContentAdapter;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2016/12/28.
 * Alex
 */

public class NewsDetailsView extends MvpBaseView<NewsDetailsAct> {

    private TextView news_details_title,news_details_desc;
    private RecyclerView news_details_recycler;
    private List<String> contents;

    private NewsDetailsContentAdapter newsDetailsContentAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    public void findMvpViews() {
        news_details_title = findViewById(R.id.news_details_title);
        news_details_desc = findViewById(R.id.news_details_desc);
        news_details_recycler = findViewById(R.id.news_details_recycler);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        contents = new ArrayList<>();
        newsDetailsContentAdapter = new NewsDetailsContentAdapter(contents,this.getContext());
        news_details_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        news_details_recycler.setAdapter(newsDetailsContentAdapter);
    }

    public void showContentsAll(List<String> contents){
        this.contents.clear();
        this.contents.addAll(contents);
        newsDetailsContentAdapter.notifyDataSetChanged();
    }

    public void showNews(ContentlistBean contentlistBean){

    }

}
