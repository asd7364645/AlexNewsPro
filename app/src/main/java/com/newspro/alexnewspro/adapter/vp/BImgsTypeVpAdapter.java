package com.newspro.alexnewspro.adapter.vp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.newspro.alexnewspro.presenter.bimgs.FgBImg;

import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class BImgsTypeVpAdapter extends FragmentStatePagerAdapter {

    private List<FgBImg> fgBImgs;
    private List<String> titles;

    public BImgsTypeVpAdapter(FragmentManager fm, List<FgBImg> fgBImgs, List<String> titles) {
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
