package com.newspro.alexnewspro.view.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.Top250Adapter;
import com.newspro.alexnewspro.model.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.presenter.movie.FgTop250;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/2/15.
 * Alex
 */

public class FgTop250View extends MvpBaseFragView<FgTop250> {

    private XRecyclerView fg_top250_rv;
    private Top250Adapter top250Adapter;
    private ArrayList<SubjectsBean> subjectsBeens;

    @Override
    public int setLayoutId() {
        return R.layout.fg_top250;
    }

    @Override
    public void findMvpViews() {
        fg_top250_rv = findViewById(R.id.fg_top250_rv);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_top250_rv.setLoadingListener(presenter);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        if (savedInstanceState != null)
            subjectsBeens = savedInstanceState.getParcelableArrayList("subjectsBeens");
        else
            subjectsBeens = new ArrayList<>();
        top250Adapter = new Top250Adapter(this.getContext(), R.layout.item_top250, subjectsBeens);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_top250_rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_top250_rv.setRefreshProgressStyle(ProgressStyle.BallGridPulse);
        fg_top250_rv.setLoadingMoreProgressStyle(ProgressStyle.BallGridPulse);
        fg_top250_rv.setAdapter(top250Adapter);

        if (subjectsBeens.isEmpty())
            refreshGetTop250();

    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putParcelableArrayList("subjectsBeens", subjectsBeens);
    }

    //-----------公共方法----------------

    public void refreshGetTop250() {
        fg_top250_rv.setRefreshing(true);
        presenter.getTop250ForModel(true);
    }

    public void refreshTop250(List<SubjectsBean> subjectsBeens) {
        this.subjectsBeens.clear();
        this.subjectsBeens.addAll(subjectsBeens);
        top250Adapter.notifyDataSetChanged();
    }

    public void loadTop250(List<SubjectsBean> subjectsBeens) {
        this.subjectsBeens.addAll(subjectsBeens);
        top250Adapter.notifyDataSetChanged();
    }

    public void refreshOver() {
        fg_top250_rv.refreshComplete();
    }

    public void topNoMore() {
        fg_top250_rv.setNoMore(true);
    }
}
