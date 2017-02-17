package com.newspro.alexnewspro.presenter.bimgs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.BImgsAdapter;
import com.newspro.alexnewspro.model.BImgsModel;
import com.newspro.alexnewspro.model.bean.BImgListBean;
import com.newspro.alexnewspro.presenter.BigImgAct;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.bimg.FgBimgView;

import java.util.ArrayList;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBImg extends MvpBaseFrag<FgBimgView,BImgsModel> implements XRecyclerView.LoadingListener, BImgsAdapter.BImgsAdapterClickListener, View.OnClickListener {

//    private BImgsModel bImgsModel;
    private int page = 1;
    private BImgListBean bImgListBean;
    private boolean isLoading = false;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
//        mvpModel = new BImgsModel();
    }


    public void refreshBImgs(final boolean isRefresh) {
        isLoading = true;
        if (isRefresh)
            page = 1;
        else
            page = ++page;
        mvpModel.getImgsList(page, new MvpModelCallBack<BImgListBean>() {
            @Override
            public void result(BImgListBean data) {
                bImgListBean = data;
                isLoading = false;
                if (mvpView != null) {
                    mvpView.showSuccess(data.getResults(), isRefresh);
                    mvpView.setRefreshLayoutRefresh(isRefresh);
                }
                ToastUtils.showShort(getContext(), "加载成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                isLoading = false;
                if (page > 1)
                    page--;
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "加载失败,原因：" + data);
                    mvpView.setRefreshLayoutRefresh(isRefresh);
                    mvpView.showError();
                }
            }
        });
    }


    @Override
    public void onRefresh() {
        refreshBImgs(true);
    }

    @Override
    public void onLoadMore() {
        if (isNoLoadingMore()) {
            mvpView.setNoLoadMore();
            return;
        }
        if (!isLoading)
            refreshBImgs(false);
    }

    private boolean isNoLoadingMore() {
        return bImgListBean != null && bImgListBean.getResults() != null && bImgListBean.getResults().isEmpty();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mvpModel.getImgListCall() != null && !mvpModel.getImgListCall().isCanceled()) {
            mvpModel.getImgListCall().cancel();
        }
    }

    @Override
    public void click(int position) {
        //点击查看大图，进入大图的界面
        Intent intent = new Intent(getActivity(), BigImgAct.class);
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) mvpView.getbImgListBeen());
        intent.putExtra("selectPosi", position);
        intent.putExtra("isBImg",true);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fg_bimg_act_btn:
                mvpView.showTop();
                break;
        }
    }
}
