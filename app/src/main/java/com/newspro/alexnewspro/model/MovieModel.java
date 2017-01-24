package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.http.httpinterface.DouBanMovieInterface;
import com.newspro.alexnewspro.model.bean.doubanmovie.InTheatersMoviesBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class MovieModel  {

    /**
     * 通过城市查询正在上映的电影
     * @param city
     * @param success
     * @param error
     */
    public void getInTheaters(String city, final MvpModelCallBack<InTheatersMoviesBean> success, final MvpModelCallBack<String> error){
        Call<InTheatersMoviesBean> inTheaters = RetrofitUtil.retrofitUtil(Constant.MOVIE_API_URL, GsonConverterFactory.create())
                .create(DouBanMovieInterface.class).getInTheaters(city);
        inTheaters.enqueue(new Callback<InTheatersMoviesBean>() {
            @Override
            public void onResponse(Call<InTheatersMoviesBean> call, Response<InTheatersMoviesBean> response) {
                InTheatersMoviesBean inTheatersMoviesBean = response.body();
                success.result(inTheatersMoviesBean);
            }

            @Override
            public void onFailure(Call<InTheatersMoviesBean> call, Throwable t) {
                error.result(t.getMessage());
            }
        });
    }

}
