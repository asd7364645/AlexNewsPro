package com.newspro.alexnewspro.presenter.baisibudejie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.NewsModel;
import com.newspro.alexnewspro.view.baisibudejie.FgBaiSiView;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class FgBaiSi extends MvpBaseFrag<FgBaiSiView, NewsModel> {

    private SparseArray<Fragment> fragmentSparseArray;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        fragmentSparseArray = new SparseArray<>();
        FgBaiSiImgs fgBaiSiImgs = new FgBaiSiImgs();
        FgBaiSiDuanZi fgBaiSiDuanZi = new FgBaiSiDuanZi();
        FgBaiSiYinPin fgBaiSiYinPin = new FgBaiSiYinPin();
        FgBaiSiMedia fgBaiSiMedia = new FgBaiSiMedia();
        fragmentSparseArray.put(Constant.BAISIBUDEJIE_IMGS_TYPE, fgBaiSiImgs);
        fragmentSparseArray.put(Constant.BAISIBUDEJIE_DUANZI_TYPE, fgBaiSiDuanZi);
        fragmentSparseArray.put(Constant.BAISIBUDEJIE_MUSIC_TYPE, fgBaiSiYinPin);
        fragmentSparseArray.put(Constant.BAISIBUDEJIE_MEDIA_TYPE, fgBaiSiMedia);
    }

    public SparseArray<Fragment> getFragmentSparseArray() {
        return fragmentSparseArray;
    }
}
