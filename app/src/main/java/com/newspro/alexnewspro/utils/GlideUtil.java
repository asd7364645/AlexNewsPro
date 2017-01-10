package com.newspro.alexnewspro.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.newspro.alexnewspro.R;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */
public class GlideUtil {

    public static void loadImg(Context context, String url, final ImageView imageView) {

        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.img_place_holder_color)
                .error(R.mipmap.img_load_error)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        return false;
                    }
                })
                .into(imageView);
    }

    public static void loadImgNoSpecialEffects(Context context,String url,ImageView imageView){
        Glide.with(context)
                .load(url).into(imageView);
    }

    public static void loadImgToSetPlaceHolder(Context context,String url,ImageView imageView,int place){
        Glide.with(context)
                .load(url)
                .placeholder(place)
                .into(imageView);
    }

    /**
     * Glide 获得图片缓存路径
     */
    public static String getImagePath(Context context,String imgUrl) {
        String path = null;
        FutureTarget<File> future = Glide.with(context)
                .load(imgUrl)
                .downloadOnly(500, 500);
        try {
            File cacheFile = future.get();
            path = cacheFile.getAbsolutePath();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return path;
    }

}
