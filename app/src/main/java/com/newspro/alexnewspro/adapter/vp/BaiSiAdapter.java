package com.newspro.alexnewspro.adapter.vp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.newspro.alexnewspro.constant.Constant;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class BaiSiAdapter extends FragmentStatePagerAdapter {

    private SparseArray<Fragment> fragmentSparseArray;

    public BaiSiAdapter(FragmentManager fm, SparseArray<Fragment> fragmentSparseArray) {
        super(fm);
        this.fragmentSparseArray = fragmentSparseArray;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentSparseArray.get(Constant.BAISIBUDEJIE_SPARSE.keyAt(position));
    }

    @Override
    public int getCount() {
        return Constant.BAISIBUDEJIE_SPARSE.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.BAISIBUDEJIE_SPARSE.valueAt(position);
    }
}
