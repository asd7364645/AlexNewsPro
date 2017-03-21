package com.newspro.alexnewspro.presenter.movie;

import android.content.Intent;
import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.model.MovieModel;
import com.newspro.alexnewspro.bean.doubanmovie.DetailsSubjectBean;
import com.newspro.alexnewspro.utils.LoadingDialogUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.movie.MovieDetailsView;

public class MovieDetailsAct extends MvpBaseAct<MovieDetailsView, MovieModel> {

    private String movieId;

    @Override
    public void create(Bundle saveInstance) {
        LoadingDialogUtils.showLoadingDialog(this, "请稍后...");
        Intent intent = getIntent();
        movieId = intent.getStringExtra("movieId");
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        getMovieDetails(movieId);
    }

    @Override
    public void onBackPressed() {
        if (LoadingDialogUtils.isShowing()) {
            LoadingDialogUtils.dismissDialog();
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void getMovieDetails(String id) {
        mvpModel.getDetailsSubject(id, new MvpModelCallBack<DetailsSubjectBean>() {
            @Override
            public void result(DetailsSubjectBean data) {
                mvpView.setMovieDetails(data);
                LoadingDialogUtils.dismissDialog();
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                ToastUtils.showShort(MovieDetailsAct.this, "加载失败！");
                LoadingDialogUtils.dismissDialog();
                finish();
            }
        });
    }

}
