package com.newspro.alexnewspro.presenter;

import android.os.Bundle;

import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.view.BigImgView;

import java.util.ArrayList;

public class BigImgAct extends MvpBaseAct<BigImgView> {

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        ArrayList<String> imgs = getIntent().getStringArrayListExtra("imgs");
        int posi = getIntent().getIntExtra("selectPosi",0);
        mvpView.show(imgs,posi);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.activity_anim_out);
    }
}
