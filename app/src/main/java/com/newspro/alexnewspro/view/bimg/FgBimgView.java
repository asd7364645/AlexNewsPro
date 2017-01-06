package com.newspro.alexnewspro.view.bimg;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.BImgsAdapter;
import com.newspro.alexnewspro.model.bean.BImgListBean;
import com.newspro.alexnewspro.presenter.bimgs.FgBImg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBimgView extends MvpBaseFragView<FgBImg> {

    private SwipeRefreshLayout fg_bimg_refresh_layout;
    private RecyclerView fg_bimg_recycler;
    private ImageView fg_bimg_error_img;
    private List<BImgListBean.TngouBean> bImgListBeen;
    private BImgsAdapter bImgsAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_bimg;
    }

    @Override
    public void findMvpViews() {
        fg_bimg_error_img = findViewById(R.id.fg_bimg_error_img);
        fg_bimg_refresh_layout = findViewById(R.id.fg_bimg_refresh_layout);
        fg_bimg_recycler = findViewById(R.id.fg_bimg_recycler);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_bimg_refresh_layout.setOnRefreshListener(presenter);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        bImgListBeen = new ArrayList<>();
        bImgsAdapter = new BImgsAdapter(this.getContext(),bImgListBeen);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_bimg_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        fg_bimg_recycler.setAdapter(bImgsAdapter);
        //初始化完毕自动调用一次获取美图列表
        if (bImgListBeen.isEmpty()){
            refresh();
        }
    }

    public void refresh(){
        presenter.refreshBImgs(true);
        setRefreshLayoutRefresh(true);
    }

    /**
     * 显示成功后状态
     * @param bImgBeans
     * @param isRefresh
     */
    public void showSuccess(List<BImgListBean.TngouBean> bImgBeans, boolean isRefresh) {
        if (isRefresh)
            bImgListBeen.clear();
        bImgListBeen.addAll(bImgBeans);
        bImgsAdapter.notifyDataSetChanged();
        setRefreshLayoutRefresh(false);
        showError();
    }

    /**
     * 设置是否加载refresh动画
     * @param refresh
     */
    public void setRefreshLayoutRefresh(final boolean refresh) {
        fg_bimg_refresh_layout.post(new Runnable() {
            @Override
            public void run() {
                fg_bimg_refresh_layout.setRefreshing(refresh);
            }
        });
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
}
