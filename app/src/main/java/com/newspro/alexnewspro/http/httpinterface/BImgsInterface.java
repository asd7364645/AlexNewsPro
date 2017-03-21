package com.newspro.alexnewspro.http.httpinterface;

import com.newspro.alexnewspro.bean.BImgListBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 美图列表接口
 */
public interface BImgsInterface {
    @GET("{page}")
    Call<BImgListBean> getBImgList(@Path("page") int page);
}