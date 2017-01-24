package com.newspro.alexnewspro.adapter.vp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class MovieVpAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fgBImgs;
    private List<String> titles;

    public MovieVpAdapter(FragmentManager fm, List<Fragment> fgBImgs, List<String> titles) {
        super(fm);
        this.fgBImgs = fgBImgs;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fgBImgs.get(position);
    }

    @Override
    public int getCount() {
        return fgBImgs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
