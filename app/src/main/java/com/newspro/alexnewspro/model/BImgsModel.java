package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.bean.BImgListBean;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.http.httpinterface.BImgsInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 2017/1/6.
 * Alex
 */

public class BImgsModel extends MvpModel {

    private Call<BImgListBean> imgListCall;

    public void getImgsList(int page, final MvpModelCallBack<BImgListBean> successCallback, final MvpModelCallBack<String> failedCallback){
        imgListCall = RetrofitUtil.retrofitUtil(Constant.BIMG_URL, GsonConverterFactory.create())
                .create(BImgsInterface.class).getBImgList(page);
        imgListCall.enqueue(new Callback<BImgListBean>() {
            @Override
            public void onResponse(Call<BImgListBean> call, Response<BImgListBean> response) {
                successCallback.result(response.body());
            }

            @Override
            public void onFailure(Call<BImgListBean> call, Throwable t) {
                failedCallback.result("获取图片失败，请刷新！");
            }
        });
    }

    public Call<BImgListBean> getImgListCall() {
        return imgListCall;
    }
}
