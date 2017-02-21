package com.newspro.alexnewspro.presenter.movie;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.model.MovieModel;
import com.newspro.alexnewspro.model.bean.doubanmovie.DetailsSubjectBean;
import com.newspro.alexnewspro.utils.LoadingDialogUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.movie.MovieDetailsView;

public class MovieDetailsAct extends MvpBaseAct<MovieDetailsView, MovieModel> {

    private Dialog loadingDialog;
    private String movieId;

    @Override
    public void create(Bundle saveInstance) {
        createLoadingDialog();
        Intent intent = getIntent();
        movieId = intent.getStringExtra("movieId");
    }

    private void createLoadingDialog() {
        loadingDialog = LoadingDialogUtils.createLoadingDialog(this, "请稍后...");
        loadingDialog.show();
    }

    public void dismissDialog(){
        loadingDialog.dismiss();
        loadingDialog = null;
    }

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        getMovieDetails(movieId);
    }

    public void getMovieDetails(String id){
        mvpModel.getDetailsSubject(id, new MvpModelCallBack<DetailsSubjectBean>() {
            @Override
            public void result(DetailsSubjectBean data) {
                mvpView.setMovieDetails(data);
                dismissDialog();
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                ToastUtils.showShort(MovieDetailsAct.this,"加载失败！");
                dismissDialog();
                finish();
            }
        });
    }

}
