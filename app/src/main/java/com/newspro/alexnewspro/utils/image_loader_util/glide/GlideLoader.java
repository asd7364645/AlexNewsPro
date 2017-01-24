package com.newspro.alexnewspro.utils.image_loader_util.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.newspro.alexnewspro.utils.image_loader_util.ImageLoaderInterface;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */
public class GlideLoader implements ImageLoaderInterface {

    private static GlideLoader instance;

    private GlideLoader() {
    }

    public static GlideLoader getInstance() {
        if (instance == null) {
            instance = new GlideLoader();
        }
        return instance;
    }

    /**
     * Glide 获得图片缓存路径
     */
    public String getImagePath(Context context, String imgUrl) {
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

    //----------------------------------------------------------------------

    @Override
    public void display(ImageView imageView, String url) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, 0, 0).into(imageView);
    }

    @Override
    public void display(ImageView imageView, int resId) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, 0, 0).into(imageView);
    }

    @Override
    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, loadingImg, errorImg).into(imageView);
    }

    @Override
    public void display(ImageView imageView, int resId, int loadingImg, int errorImg) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, loadingImg, errorImg).into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, int resId) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, 0, 0).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);
    }

    @Override
    public void displayCircleImg(Context context, String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget) {
        displayForRequest(context, url, 0, 0).transform(new GlideCircleTransform(context)).into(glideDrawableImageViewTarget);
    }

    @Override
    public void displayCircleImg(ImageView imageView, String url) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, 0, 0).transform(new GlideCircleTransform(context)).into(imageView);
    }

    public void display(ImageView imageView, String url, RequestListener<? super String, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, 0, 0).listener(requestListener).into(imageView);
    }

    public void display(ImageView imageView, int resId, RequestListener<? super Integer, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, 0, 0).listener(requestListener).into(imageView);
    }

    public void display(ImageView imageView, String url, int loadingImg, int errorImg, RequestListener<? super String, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, loadingImg, errorImg).listener(requestListener).into(imageView);
    }

    public void display(ImageView imageView, int resId, int loadingImg, int errorImg, RequestListener<? super Integer, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, loadingImg, errorImg).listener(requestListener).into(imageView);
    }

    public void displayCircleImg(ImageView imageView, int resId, RequestListener<? super Integer, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, resId, 0, 0)
                .listener(requestListener)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    public void displayCircleImg(Context context, String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget, RequestListener<? super String, GlideDrawable> requestListener) {
        displayForRequest(context, url, 0, 0)
                .listener(requestListener)
                .transform(new GlideCircleTransform(context))
                .into(glideDrawableImageViewTarget);
    }

    public void displayCircleImg(ImageView imageView, String url, RequestListener<? super String, GlideDrawable> requestListener) {
        Context context = getContextFromImageView(imageView);
        displayForRequest(context, url, 0, 0).listener(requestListener).transform(new GlideCircleTransform(context)).into(imageView);
    }

    private <T> DrawableTypeRequest<T> displayForRequest(Context context, T url, int loadingImg, int errorImg) {

        DrawableTypeRequest<T> request = Glide.with(context).load(url);
        if (loadingImg != 0) {
            request.placeholder(loadingImg);
        }
        if (errorImg != 0) {
            request.error(errorImg);
        }
        request
                /*
                设置缓存策略，默认不缓存原始图，只缓存结果图
                现改为缓存所有图，否则断网时，类似于瀑布流效果
                （imageView长款不定时，glide本该去重新加载原始图，然后根据ImageView的目标尺寸进行相应调整）
                将无法正常显示；若缓存了原始图，则glide可以从缓存加载原始图，并且进行相应尺寸调整了
                 */
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //用原图的1/10作为缩略图，如果缩略图先被加载出来则先显示缩略图
                .thumbnail(0.1f)
                //解决加载出来的瞬间闪一下的问题
                .dontAnimate();
        return request;
    }

    private Context getContextFromImageView(ImageView imageView) {
        if (imageView == null) {
            throw new NullPointerException("imageView = null");
        }
        return imageView.getContext();
    }

}
