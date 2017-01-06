package com.newspro.alexnewspro.adapter.vp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.newspro.alexnewspro.presenter.news.FgNews;
import com.newspro.alexnewspro.constant.Constant;

import java.util.ArrayList;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class NewsTypeVpAdapter extends FragmentStatePagerAdapter {

    private ArrayList<FgNews> newsFrag;
    private ArrayList<String> titles;

    public NewsTypeVpAdapter(FragmentManager fm,ArrayList<FgNews> newsFrag,ArrayList<String> titles) {
        super(fm);
        this.newsFrag = newsFrag;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {

        return newsFrag.get(position);
    }

    @Override
    public int getCount() {
        return Constant.NEWS_TITLES_MAP.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
