package com.newspro.alexnewspro.view.baisibudejie;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.BaiSiAdapter;
import com.newspro.alexnewspro.presenter.baisibudejie.FgBaiSi;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class FgBaiSiView extends MvpBaseFragView<FgBaiSi> {

    private TabLayout base_tablayout;
    private ViewPager fg_baisi_vp;

    @Override
    public int setLayoutId() {
        return R.layout.fg_baisi;
    }

    @Override
    public void findMvpViews() {
        base_tablayout = findViewById(R.id.base_tablayout);
        fg_baisi_vp = findViewById(R.id.fg_baisi_vp);
    }



    @Override
    protected void setView() {
        super.setView();
        BaiSiAdapter baiSiAdapter = new BaiSiAdapter(presenter.getChildFragmentManager(),presenter.getFragmentSparseArray());
        fg_baisi_vp.setAdapter(baiSiAdapter);
        base_tablayout.setupWithViewPager(fg_baisi_vp,true);
    }
}
