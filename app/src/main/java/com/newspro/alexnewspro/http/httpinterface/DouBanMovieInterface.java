package com.newspro.alexnewspro.http.httpinterface;

import com.newspro.alexnewspro.model.bean.doubanmovie.InTheatersMoviesBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public interface DouBanMovieInterface {

    @GET("in_theaters")
    Call<InTheatersMoviesBean> getInTheaters(@Query("city") String city);

}
