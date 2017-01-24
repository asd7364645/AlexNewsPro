package com.newspro.alexnewspro.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.alex.mvplibrary.view.MvpBaseView;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.adapter.vp.NewsBigImgAdapter;
import com.newspro.alexnewspro.customviews.BounceBackViewPager;
import com.newspro.alexnewspro.customviews.ZoomImgView;
import com.newspro.alexnewspro.presenter.BigImgAct;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;

import java.util.ArrayList;

/**
 * Created by Alex on 2017/1/5.
 * Alex
 */

public class BigImgView extends MvpBaseView<BigImgAct> {

    private BounceBackViewPager big_img_viewpager;
    private NewsBigImgAdapter bigImgAdapter;
    private Button big_img_save_btn;
    private ArrayList<ZoomImgView> zoomImgViews;

    @Override
    public int setLayoutId() {
        return R.layout.activity_big_img;
    }

    @Override
    protected void setData(Bundle savedInstanceState) {
        super.setData(savedInstanceState);
        zoomImgViews = new ArrayList<>();
    }

    @Override
    public void bindEvent() {
        super.bindEvent();
        big_img_save_btn.setOnClickListener(presenter);
        big_img_viewpager.setOnPageChangeListener(presenter);
    }

    @Override
    public void findMvpViews() {
        big_img_viewpager = findViewById(R.id.big_img_viewpager);
        big_img_save_btn = findViewById(R.id.big_img_save_btn);
    }

    public void show(ArrayList<String> imgs,int posi){
        for (String string : imgs)  {
            ZoomImgView zoomImgView = new ZoomImgView(this.getContext());
            zoomImgView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            zoomImgView.setPager(big_img_viewpager);
            GlideLoader.getInstance().display(zoomImgView, string, new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    ToastUtils.showShort(presenter,"加载失败！");
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    return false;
                }
            });
            zoomImgViews.add(zoomImgView);
        }
        bigImgAdapter = new NewsBigImgAdapter(zoomImgViews,presenter);
        big_img_viewpager.setAdapter(bigImgAdapter);
        big_img_viewpager.setCurrentItem(posi);
    }

    public void gongSave(){
        big_img_save_btn.setVisibility(View.GONE);
    }

}
