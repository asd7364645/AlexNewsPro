package com.newspro.alexnewspro.http.httpinterface;

import com.newspro.alexnewspro.model.bean.doubanmovie.DetailsSubjectBean;
import com.newspro.alexnewspro.model.bean.doubanmovie.MoviesListBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public interface DouBanMovieInterface {

    @GET("in_theaters")
    Call<MoviesListBean> getInTheaters(@Query("city") String city);

    @GET("top250?count=10")
    Call<MoviesListBean> getTop250Movies(@Query("start") int start);

    @GET("coming_soon?count=10")
    Call<MoviesListBean> getCommingSoon(@Query("start") int start);

    @GET("subject/{id}")
    Call<DetailsSubjectBean> getDetailsSubject(@Path("id") String id);

}
