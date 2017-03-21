package com.newspro.alexnewspro.view.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.listview.CommingSoonAdapter;
import com.newspro.alexnewspro.bean.doubanmovie.SubjectsBean;
import com.newspro.alexnewspro.presenter.movie.FgCommingSoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/2/17.
 * Alex
 */

public class FgCommingSoonView extends MvpBaseFragView<FgCommingSoon> {

    private XRecyclerView fg_comming_soon_rv;
    private ArrayList<SubjectsBean> subjectsBeanList;
    private CommingSoonAdapter commingSoonAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_comming_soon;
    }

    @Override
    public void findMvpViews() {
        fg_comming_soon_rv = findViewById(R.id.fg_comming_soon_rv);
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        if (savedInstanceState != null)
            subjectsBeanList = savedInstanceState.getParcelableArrayList("subjectsBeanList");
        else
            subjectsBeanList = new ArrayList<>();
        commingSoonAdapter = new CommingSoonAdapter(this.getContext(), R.layout.item_comming_soon, subjectsBeanList);

    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_comming_soon_rv.setLoadingListener(presenter);
    }

    @Override
    protected void setView() {
        super.setView();
        fg_comming_soon_rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        fg_comming_soon_rv.setRefreshProgressStyle(ProgressStyle.BallGridPulse);
        fg_comming_soon_rv.setLoadingMoreProgressStyle(ProgressStyle.BallGridPulse);
        fg_comming_soon_rv.setAdapter(commingSoonAdapter);
        if (subjectsBeanList.isEmpty())
            refreshGetCommingSoon();
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
        outState.putParcelableArrayList("subjectsBeanList", subjectsBeanList);
    }

    //-----------公共方法----------------

    public void refreshGetCommingSoon() {
        fg_comming_soon_rv.setRefreshing(true);
        presenter.getCommingForModel(true);
    }

    public void refreshCommingSoon(List<SubjectsBean> subjectsBeens) {
        this.subjectsBeanList.clear();
        this.subjectsBeanList.addAll(subjectsBeens);
        commingSoonAdapter.notifyDataSetChanged();
    }

    public void loadCommingSoon(List<SubjectsBean> subjectsBeens) {
        this.subjectsBeanList.addAll(subjectsBeens);
        commingSoonAdapter.notifyDataSetChanged();
    }

    public void refreshOver() {
        fg_comming_soon_rv.refreshComplete();
    }

    public void topNoMore() {
        fg_comming_soon_rv.setNoMore(true);
    }

}
