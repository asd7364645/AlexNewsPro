package com.newspro.alexnewspro.utils.image_loader_util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by Alex on 2017/1/23.
 * 为了更换其他图片库的时候更改较少，所以封装图片加载库
 * 图片加载的接口
 * Alex
 */

public interface ImageLoaderInterface {

    void display(ImageView imageView, String url);
    void display(ImageView imageView, int resId);

    void display(ImageView imageView, String url, int loadingImg, int errorImg);
    void display(ImageView imageView, int resId, int loadingImg, int errorImg);

    void displayCircleImg(ImageView imageView, int resId);

    void displayCircleImg(Context context, String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget);

    void displayCircleImg(ImageView imageView, String url);

}
