package com.newspro.alexnewspro.view.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.InTheatersAdapter;
import com.newspro.alexnewspro.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.presenter.movie.FgInTheaters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/1/24.
 * 正在热映fragment
 * Alex
 */

public class FgInTheatersView extends MvpBaseFragView<FgInTheaters> {

    private XRecyclerView fg_intheaters_rv;

    private ArrayList<SubjectsBean> subjectsBeens;
    private InTheatersAdapter inTheatersAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_intheaters;
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_intheaters_rv.setLoadingListener(presenter);
    }

    @Override
    public void findMvpViews() {
        fg_intheaters_rv = findViewById(R.id.fg_in_theaters_rv);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        if (savedInstanceState != null)
            subjectsBeens = savedInstanceState.getParcelableArrayList("subjectsBeens");
        else
            subjectsBeens = new ArrayList<>();
        inTheatersAdapter = new InTheatersAdapter(this.getContext(), R.layout.item_intheaters, subjectsBeens);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_intheaters_rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_intheaters_rv.setRefreshProgressStyle(ProgressStyle.BallGridPulse);
        fg_intheaters_rv.setLoadingMoreEnabled(false);
        fg_intheaters_rv.setAdapter(inTheatersAdapter);
        if (subjectsBeens.isEmpty())
            getTheaters();
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putParcelableArrayList("subjectsBeens", subjectsBeens);
    }

    //--------------公共方法--------------------
    public void getTheaters() {
        fg_intheaters_rv.setRefreshing(true);
        //获取正在上映电影
        presenter.getInTheatersFromModel();
    }

    public void refreshTheatersView(List<SubjectsBean> subjectsBeens) {
        this.subjectsBeens.clear();
        this.subjectsBeens.addAll(subjectsBeens);
        inTheatersAdapter.notifyDataSetChanged();
    }

    public void refreshOver() {
        fg_intheaters_rv.refreshComplete();
    }


}
