package com.newspro.alexnewspro.view.bimg;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.BImgsAdapter;
import com.newspro.alexnewspro.bean.BImgListBean;
import com.newspro.alexnewspro.presenter.bimgs.FgBImg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBimgView extends MvpBaseFragView<FgBImg> {

    private XRecyclerView fg_bimg_recycler;
    private ImageView fg_bimg_error_img;
    private FloatingActionButton fg_bimg_act_btn;
    private List<BImgListBean.ResultsBean> bImgListBeen;
    private BImgsAdapter bImgsAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_bimg;
    }

    @Override
    public void findMvpViews() {
        fg_bimg_error_img = findViewById(R.id.fg_bimg_error_img);
        fg_bimg_recycler = findViewById(R.id.fg_bimg_recycler);
        fg_bimg_act_btn = findViewById(R.id.fg_bimg_act_btn);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_bimg_recycler.setLoadingListener(presenter);
        fg_bimg_act_btn.setOnClickListener(presenter);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        bImgListBeen = new ArrayList<>();
        bImgsAdapter = new BImgsAdapter(this.getContext(),bImgListBeen);
        bImgsAdapter.setClickListener(presenter);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_bimg_recycler.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        fg_bimg_recycler.setAdapter(bImgsAdapter);
        //初始化完毕自动调用一次获取美图列表
        if (bImgListBeen.isEmpty()){
            refresh();
        }
    }

    public void refresh(){
        presenter.refreshBImgs(true);
        fg_bimg_recycler.setRefreshing(true);
    }

    /**
     * 显示成功后状态
     * @param bImgBeans
     * @param isRefresh
     */
    public void showSuccess(List<BImgListBean.ResultsBean> bImgBeans, boolean isRefresh) {
        if (isRefresh)
            bImgListBeen.clear();
        bImgListBeen.addAll(bImgBeans);
        bImgsAdapter.notifyDataSetChanged();
        setRefreshLayoutRefresh(isRefresh);
        showError();
    }

    /**
     * 设置是否加载refresh动画
     * @param isRefresh
     */
    public void setRefreshLayoutRefresh(boolean isRefresh) {
        if (isRefresh)
            fg_bimg_recycler.refreshComplete();
        else
            fg_bimg_recycler.loadMoreComplete();
    }

    public void setNoLoadMore(){
        fg_bimg_recycler.setNoMore(true);
    }

    /**
     * 显示错误信息，如果列表为空则显示，不为空则不显示
     */
    public void showError() {
        if (bImgListBeen.isEmpty()) {
            fg_bimg_error_img.setVisibility(View.VISIBLE);
        } else {
            fg_bimg_error_img.setVisibility(View.GONE);
        }
    }

    public void showTop(){
        fg_bimg_recycler.scrollToPosition(0);
    }

    public List<String> getbImgListBeen() {
        List<String> imgs = new ArrayList<>();
        for (BImgListBean.ResultsBean resultsBean : bImgListBeen) {
            imgs.add(resultsBean.getUrl());
        }
        return imgs;
    }
}
