package com.newspro.alexnewspro.presenter.bimgs;

import android.os.Bundle;
import android.view.View;

import com.example.alex.mvplibrary.presenter.MvpBaseFrag;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.view.bimg.FgBImgTypeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class FgBImgsType extends MvpBaseFrag<FgBImgTypeView> implements View.OnClickListener{

    private List<FgBImg> fgBImgs;
    private List<String> titles;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        fgBImgs = new ArrayList<>();
        titles = new ArrayList<>();
        int size = Constant.BIMG_TITLE_SPARSEARRAY.size();
        for (int i = 0; i < size; i++) {
            //设置fragment
            FgBImg fgBImg = new FgBImg();
            Bundle bundle = new Bundle();
            bundle.putInt("bImgType",Constant.BIMG_TITLE_SPARSEARRAY.keyAt(i));
            fgBImg.setArguments(bundle);
            fgBImgs.add(fgBImg);
            //设置标题
            titles.add(Constant.BIMG_TITLE_SPARSEARRAY.get(Constant.BIMG_TITLE_SPARSEARRAY.keyAt(i)));
        }
    }

    @Override
    public void onClick(View v) {

    }

    public List<FgBImg> getFgBImgs() {
        return fgBImgs;
    }

    public List<String> getTitles() {
        return titles;
    }
}
