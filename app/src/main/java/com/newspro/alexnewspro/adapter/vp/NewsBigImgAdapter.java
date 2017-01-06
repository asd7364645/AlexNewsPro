package com.newspro.alexnewspro.adapter.vp;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.customviews.ZoomImgView;

import java.util.ArrayList;

/**
 * Created by Alex on 2017/1/5.
 * Alex
 */

public class NewsBigImgAdapter extends PagerAdapter {

    private ArrayList<ZoomImgView> zoomImgViews;
    private Activity activity;

    public NewsBigImgAdapter(ArrayList<ZoomImgView> zoomImgViews, Activity activity) {
        this.zoomImgViews = zoomImgViews;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return zoomImgViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ZoomImgView zoomImgView = zoomImgViews.get(position);
        container.addView(zoomImgView);
        zoomImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
                activity.overridePendingTransition(0, R.anim.activity_anim_out);
            }
        });
        return zoomImgView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(zoomImgViews.get(position));
    }
}
