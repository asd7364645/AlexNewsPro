package com.newspro.alexnewspro.adapter.vp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.newspro.alexnewspro.Presenter.FgNews;
import com.newspro.alexnewspro.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class NewsTypeVpAdapter extends FragmentStatePagerAdapter {

    private List<String> titles;
    private List<String> types;
    public NewsTypeVpAdapter(FragmentManager fm) {
        super(fm);
        titles = new ArrayList<>();
        types = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = Constant.NEWS_TITLES_MAP.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entrySet) {
            titles.add(stringStringEntry.getValue());
            types.add(stringStringEntry.getKey());
        }
    }

    @Override
    public Fragment getItem(int position) {
        FgNews fgNews = new FgNews();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NEWS_TYPE_STR,types.get(position));
        fgNews.setArguments(bundle);
        return fgNews;
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
