package com.newspro.alexnewspro.view.baisibudejie;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.alex.mvplibrary.view.MvpBaseFragView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.presenter.baisibudejie.FgBaiSiDuanZi;

/**
 * Created by Alex on 2017/6/8.
 * Alex
 */

public class FgBaiSiDuanZiView extends MvpBaseFragView<FgBaiSiDuanZi> {
    private ImageView test_glide_img;
    @Override
    public int setLayoutId() {
        return R.layout.fg_baisi_duanzi;
    }

    @Override
    public void findMvpViews() {
        test_glide_img = findViewById(R.id.test_glide_img);
    }

    @Override
    protected void setView() {
        super.setView();
        Glide.with(this.getContext())
                .load("http://wimg.spriteapp.cn/ugc/2017/06/12/593e36d491fc8.gif")
                .asGif().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(test_glide_img);
//        GlideLoader.getInstance().display(test_glide_img,"http://wimg.spriteapp.cn/ugc/2017/06/09/593a8e1f9bde0_1.jpg");
    }
}
