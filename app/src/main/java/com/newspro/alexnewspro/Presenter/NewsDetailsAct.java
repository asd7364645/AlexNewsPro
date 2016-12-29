package com.newspro.alexnewspro.Presenter;

import android.content.Intent;
import android.os.Bundle;

import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.model.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.newspro.alexnewspro.view.NewsDetailsView;

public class NewsDetailsAct extends MvpBaseAct<NewsDetailsView> {

    private Intent intent;

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        intent = getIntent();
        ContentlistBean contentlistBean = intent.getParcelableExtra("newsBean");
        mvpView.showContentsAll(contentlistBean.getAllList());
    }
}
