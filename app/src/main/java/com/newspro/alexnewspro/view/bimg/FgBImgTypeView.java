package com.newspro.alexnewspro.view.bimg;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.BImgsTypeVpAdapter;
import com.newspro.alexnewspro.presenter.bimgs.FgBImgsType;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBImgTypeView extends MvpBaseFragView<FgBImgsType> {

    private TabLayout fg_bimg_tablayout;
    private ViewPager fg_bimg_type_vp;
    private FloatingActionButton fg_bimg_type_action_btn;
    //ViewPager适配器
    private BImgsTypeVpAdapter bImgsTypeVpAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.fg_bimg_type;
    }

    @Override
    public void findMvpViews() {
        fg_bimg_tablayout = findViewById(R.id.type_tablayout);
        fg_bimg_type_vp = findViewById(R.id.fg_bimg_type_vp);
        fg_bimg_type_action_btn = findViewById(R.id.fg_bimg_type_action_btn);

    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        bImgsTypeVpAdapter = new BImgsTypeVpAdapter(presenter.getChildFragmentManager(), presenter.getFgBImgs(), presenter.getTitles());
        fg_bimg_type_vp.setAdapter(bImgsTypeVpAdapter);
        fg_bimg_tablayout.setupWithViewPager(fg_bimg_type_vp);
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        fg_bimg_type_action_btn.setOnClickListener(presenter);
    }



}
