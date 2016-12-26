package com.newspro.alexnewspro.Presenter;

import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.model.bean.NewsBean.ResultBean.DataBean;
import com.newspro.alexnewspro.view.FgNewsView;

import java.util.List;

/**
 * Created by Alex on 2016/12/25.
 */

public class FgNews extends MvpBaseFrag<FgNewsView> {

    private NewsModel newsModel;
    private String type;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        newsModel = new NewsModel();
        Bundle arguments = getArguments();
        type = arguments.getString(Constant.NEWS_TYPE_STR);
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        //初始化完毕自动调用一次获取头条列表
        newsModel.getNewsOfType(type, new MvpModel.MvpCallback() {
            @Override
            public void result(Object data) {
                if (data instanceof List){
                    mvpView.refresh((List<DataBean>) data);
                }else {

                }
            }
        });
    }
}
