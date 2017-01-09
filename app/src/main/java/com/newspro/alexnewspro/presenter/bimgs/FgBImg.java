package com.newspro.alexnewspro.presenter.bimgs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
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

public class FgBImg extends MvpBaseFrag<FgBimgView> implements SwipeRefreshLayout.OnRefreshListener, BImgsAdapter.BImgsAdapterClickListener {

    private BImgsModel bImgsModel;
    private int page = 1;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        bImgsModel = new BImgsModel();
    }


    public void refreshBImgs(final boolean isRefresh) {
        if (isRefresh)
            page = 1;
        else
            page = ++page;
        bImgsModel.getImgsList(page, new MvpModelCallBack<BImgListBean>() {
            @Override
            public void result(BImgListBean data) {
                mvpView.showSuccess(data.getResults(), isRefresh);
                ToastUtils.showShort(getContext(), "加载成功");
            }
        }, new MvpModelCallBack<String>() {
            @Override
            public void result(String data) {
                if (mvpView != null) {
                    ToastUtils.showShort(getActivity(), "加载失败,原因：" + data);
                    mvpView.setRefreshLayoutRefresh(false);
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
    public void onDestroy() {
        super.onDestroy();
        if (bImgsModel.getImgListCall() != null && !bImgsModel.getImgListCall().isCanceled()) {
            bImgsModel.getImgListCall().cancel();
        }
    }

    @Override
    public void click(int position) {
        //点击查看大图，进入大图的界面
        Intent intent = new Intent(getActivity(), BigImgAct.class);
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) mvpView.getbImgListBeen());
        intent.putExtra("selectPosi", position);
        startActivity(intent);
    }
}
