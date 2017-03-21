package com.newspro.alexnewspro.presenter.movie;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.model.MovieModel;
import com.newspro.alexnewspro.bean.doubanmovie.MoviesListBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.movie.FgTop250View;

/**
 * Created by Alex on 2017/2/15.
 * Alex
 */

public class FgTop250 extends MvpBaseFrag<FgTop250View, MovieModel> implements XRecyclerView.LoadingListener {

    public static final int DEF_START = 0;
    public static final int DEF_PAGE_COUNT = 10;

    int total = 0;
    int start = DEF_START;

    public void getTop250ForModel(final boolean isRefresh) {
        mvpModel.getTop250(start, new MvpModelCallBack<MoviesListBean>() {
            @Override
            public void result(MoviesListBean data) {
                total = data.getTotal();
                if (mvpView == null)
                    return;
                if (isRefresh)
                    mvpView.refreshTop250(data.getSubjects());
                else
                    mvpView.loadTop250(data.getSubjects());
                mvpView.refreshOver();
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView == null)
                    return;
                mvpView.refreshOver();
                ToastUtils.showShort(getContext(), "获取TOP250失败！");
            }
        });
    }

    @Override
    public void onRefresh() {
        start = DEF_START;
        getTop250ForModel(true);
    }

    @Override
    public void onLoadMore() {
        start += DEF_PAGE_COUNT;
        if (start >= total) {
            //到最后了
            mvpView.topNoMore();
        } else {
            getTop250ForModel(false);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //在销毁时如果网络访问没结束则取消网络访问
        mvpModel.destroyCall(mvpModel.getTop250());
    }
}
