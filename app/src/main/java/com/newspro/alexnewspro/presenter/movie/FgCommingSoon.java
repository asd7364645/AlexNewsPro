package com.newspro.alexnewspro.presenter.movie;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.model.MovieModel;
import com.newspro.alexnewspro.model.bean.doubanmovie.MoviesListBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.movie.FgCommingSoonView;

/**
 * Created by Alex on 2017/2/17.
 * Alex
 */

public class FgCommingSoon extends MvpBaseFrag<FgCommingSoonView, MovieModel> implements XRecyclerView.LoadingListener {

    public static final int DEF_START = 0;
    public static final int DEF_PAGE_COUNT = 10;

    int total = 0;
    int start = DEF_START;

    public void getCommingForModel(final boolean isRefresh) {
        mvpModel.getCommingSoon(start, new MvpModelCallBack<MoviesListBean>() {
            @Override
            public void result(MoviesListBean data) {
                if (mvpView == null)
                    return;
                total = data.getTotal();
                if (isRefresh)
                    mvpView.refreshCommingSoon(data.getSubjects());
                else
                    mvpView.loadCommingSoon(data.getSubjects());
                mvpView.refreshOver();
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView == null)
                    return;
                mvpView.refreshOver();
                ToastUtils.showShort(getContext(), "获取即将上映列表失败！");
            }
        });
    }

    @Override
    public void onRefresh() {
        start = DEF_START;
        getCommingForModel(true);
    }

    @Override
    public void onLoadMore() {
        start += DEF_PAGE_COUNT;
        if (start >= total) {
            //到最后了
            mvpView.topNoMore();
        } else {
            getCommingForModel(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在销毁时如果网络访问没结束则取消网络访问
        mvpModel.destroyCall(mvpModel.getCommingSoon());
    }
}
