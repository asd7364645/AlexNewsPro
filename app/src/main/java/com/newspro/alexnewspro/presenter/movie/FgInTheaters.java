package com.newspro.alexnewspro.presenter.movie;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.model.MovieModel;
import com.newspro.alexnewspro.bean.doubanmovie.MoviesListBean;
import com.newspro.alexnewspro.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.movie.FgInTheatersView;

import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class FgInTheaters extends MvpBaseFrag<FgInTheatersView, MovieModel> implements XRecyclerView.LoadingListener {

    public void getInTheatersFromModel() {
        mvpModel.getInTheaters("深圳", new MvpModelCallBack<MoviesListBean>() {
            @Override
            public void result(MoviesListBean data) {
                List<SubjectsBean> subjectsBeen = data.getSubjects();
                if (mvpView == null)
                    return;
                mvpView.refreshTheatersView(subjectsBeen);
                mvpView.refreshOver();
                System.out.println("成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView == null)
                    return;
                ToastUtils.showShort(getContext(), "获取失败：" + data);
                mvpView.refreshOver();
            }
        });
    }

    @Override
    public void onRefresh() {
        getInTheatersFromModel();
    }

    @Override
    public void onLoadMore() {
        System.out.println("aaa");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在销毁时如果网络访问没结束则取消网络访问
        mvpModel.destroyCall(mvpModel.getInTheaters());
    }
}
