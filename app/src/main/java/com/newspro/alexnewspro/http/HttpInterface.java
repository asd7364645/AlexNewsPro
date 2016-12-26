package com.newspro.alexnewspro.http;

import com.newspro.alexnewspro.model.bean.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public interface HttpInterface {
    interface NewsInterface{
        @GET("index?key=5ae42453047b457b665593a901bbebba")
        Call<NewsBean> getNews(@Query("type") String type);
    }
}
