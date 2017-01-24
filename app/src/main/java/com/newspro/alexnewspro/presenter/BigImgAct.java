package com.newspro.alexnewspro.presenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.utils.common_util.FileUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.utils.image_loader_util.glide.GlideLoader;
import com.newspro.alexnewspro.view.BigImgView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BigImgAct extends MvpBaseAct<BigImgView> implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private int page;
    private ArrayList<String> imgs;

    @Override
    public void created(Bundle saveInstance) {
        super.created(saveInstance);
        Intent intent = getIntent();
        imgs = intent.getStringArrayListExtra("imgs");
        int posi = intent.getIntExtra("selectPosi", 0);
        boolean isBImg = intent.getBooleanExtra("isBImg", false);
        if (!isBImg)
            mvpView.gongSave();
        page = posi;
        mvpView.show(imgs, posi);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.activity_anim_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.big_img_save_btn:
                ToastUtils.showShort(this, "准备保存");
                saveBitmap();
                break;
        }
    }

    /**
     * 保存图片
     */
    public void saveBitmap() {
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap resultBitmap;
                String url = imgs.get(page);
                resultBitmap = BitmapFactory.decodeFile(GlideLoader.getInstance().getImagePath(BigImgAct.this, url));
                return resultBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                if (bitmap == null) {
                    ToastUtils.showShort(BigImgAct.this, "下载失败");
                    return;
                }
                if (bitmap != null) {
                    Date date = new Date(System.currentTimeMillis());
                    @SuppressLint("SimpleDateFormat") String bitName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(date) + ".jpg";
                    try {
                        FileUtils.saveBitmap(BigImgAct.this, bitName, bitmap);
                        ToastUtils.showShort(BigImgAct.this, "保存成功");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bitmap.recycle();
                }
            }
        }.execute();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        page = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
