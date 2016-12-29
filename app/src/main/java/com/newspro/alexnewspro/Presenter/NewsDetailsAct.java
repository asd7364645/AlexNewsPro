package com.newspro.alexnewspro.Presenter;

import android.content.Intent;
import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.view.NewsDetailsView;

public class NewsDetailsAct extends MvpBaseAct<NewsDetailsView> {

    private NewsModel newsModel;
    private Intent intent;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        newsModel = new NewsModel();
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        intent = getIntent();
        newsModel.changeNewsContentSpaceToEnter((ContentlistBean) intent.getParcelableExtra("newsBean"), new MvpModelCallBack<ContentlistBean>() {
            @Override
            public void result(ContentlistBean data) {
                mvpView.showNews(data);
            }
        });
    }
}
