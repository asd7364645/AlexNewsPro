package com.newspro.alexnewspro.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.newspro.alexnewspro.R;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class GlideUtil {

    public static void loadImg(Context context, String url, final ImageView imageView) {

        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 3);
        anim.setDuration(800);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();

        Glide.with(context)
                .load(url)
                .error(R.mipmap.img_load_error)
                .placeholder(R.drawable.img_loading_anim_drawable)
//                .placeholder(R.mipmap.img_loading)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                        anim.cancel();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                        anim.cancel();
                        return false;
                    }
                })
                .into(imageView);
    }

}
