package com.newspro.alexnewspro.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.NewsTypeVpAdapter;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class FgNewsTypeView extends MvpBaseFragView {

    private TabLayout news_type_tablayout;
    private ViewPager news_type_viewpager;

    private NewsTypeVpAdapter newsTypeVpAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_news_type;
    }

    @Override
    public void findMvpViews() {
        news_type_tablayout = findViewById(R.id.news_type_tablayout);
        news_type_viewpager = findViewById(R.id.news_type_viewpager);
    }

    @Override
    protected void setData() {
        super.setData();
        newsTypeVpAdapter = new NewsTypeVpAdapter(getContext().getSupportFragmentManager());
        news_type_viewpager.setAdapter(newsTypeVpAdapter);
        news_type_tablayout.setupWithViewPager(news_type_viewpager);
    }

    @Override
    protected void setView() {
        super.setView();
    }


}
