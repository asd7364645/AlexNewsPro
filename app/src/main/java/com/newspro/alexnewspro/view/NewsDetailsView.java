package com.newspro.alexnewspro.view;

import android.widget.TextView;

import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.Presenter.NewsDetailsAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

/**
 * Created by Alex on 2016/12/28.
 * Alex
 */

public class NewsDetailsView extends MvpBaseView<NewsDetailsAct> {

    private ContentlistBean contentlistBean;

    private TextView news_details_title,news_details_desc,news_details_content;

    @Override
    public int setLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    public void findMvpViews() {
        news_details_title = findViewById(R.id.news_details_title);
        news_details_desc = findViewById(R.id.news_details_desc);
        news_details_content = findViewById(R.id.news_details_content);
    }

    public void showNews(ContentlistBean contentlistBean){
        this.contentlistBean = contentlistBean;
        news_details_title.setText(contentlistBean.getTitle());
        news_details_desc.setText(contentlistBean.getDesc());
        news_details_content.setText(contentlistBean.getContent());
    }

}
