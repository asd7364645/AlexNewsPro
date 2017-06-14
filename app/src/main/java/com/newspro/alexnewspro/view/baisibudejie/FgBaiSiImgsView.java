package com.newspro.alexnewspro.view.baisibudejie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.BaiSiImgsAdapter;
import com.newspro.alexnewspro.presenter.baisibudejie.FgBaiSiImgs;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class FgBaiSiImgsView extends MvpBaseFragView<FgBaiSiImgs> {

    private XRecyclerView fg_baisi_imgs_rv;
    private BaiSiImgsAdapter adapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_baisi_imgs;
    }

    @Override
    public void findMvpViews() {
        fg_baisi_imgs_rv = findViewById(R.id.fg_baisi_imgs_rv);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        adapter = new BaiSiImgsAdapter(this.getContext(),presenter.getDatas());
    }

    @Override
    protected void setView() {
        super.setView();
        fg_baisi_imgs_rv.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        fg_baisi_imgs_rv.setRefreshProgressStyle(ProgressStyle.BallGridPulse);
        fg_baisi_imgs_rv.setLoadingMoreProgressStyle(ProgressStyle.BallGridPulse);
        fg_baisi_imgs_rv.setAdapter(adapter);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_baisi_imgs_rv.setLoadingListener(presenter);
    }

    //-------------------------------------------
    public void refreshList(){
        this.adapter.notifyDataSetChanged();
    }
    public void stopRefreshOrLoading(boolean isRefresh){
        if (isRefresh)
        fg_baisi_imgs_rv.refreshComplete();
        else
        fg_baisi_imgs_rv.loadMoreComplete();
    }

    public void startRefresh(){
        fg_baisi_imgs_rv.setRefreshing(true);
    }

}
