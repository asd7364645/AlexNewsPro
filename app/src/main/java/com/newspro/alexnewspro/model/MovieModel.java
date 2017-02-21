package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModelInterface;
import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.http.httpinterface.DouBanMovieInterface;
import com.newspro.alexnewspro.model.bean.doubanmovie.DetailsSubjectBean;
import com.newspro.alexnewspro.model.bean.doubanmovie.MoviesListBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 2017/1/24.
 * Alex
 */

public class MovieModel implements MvpModelInterface {

    private Call<MoviesListBean> inTheaters;
    private Call<MoviesListBean> top250;
    private Call<MoviesListBean> commingSoon;

    private Call<DetailsSubjectBean> detailsSubject;

    /**
     * 通过城市查询正在上映的电影
     *
     * @param city
     * @param success
     * @param error
     */
    public void getInTheaters(String city, final MvpModelCallBack<MoviesListBean> success, final MvpModelCallBack<String> error) {
        inTheaters = RetrofitUtil.retrofitUtil(Constant.MOVIE_API_URL, GsonConverterFactory.create())
                .create(DouBanMovieInterface.class).getInTheaters(city);
        inTheaters.enqueue(new Callback<MoviesListBean>() {
            @Override
            public void onResponse(Call<MoviesListBean> call, Response<MoviesListBean> response) {
                MoviesListBean moviesListBean = response.body();
                success.result(moviesListBean);
            }

            @Override
            public void onFailure(Call<MoviesListBean> call, Throwable t) {
                error.result(t.getMessage());
            }
        });
    }

    /**
     * 查询TOP250电影信息
     *
     * @param start
     * @param success
     * @param error
     */
    public void getTop250(int start, final MvpModelCallBack<MoviesListBean> success, final MvpModelCallBack<String> error) {
        top250 = RetrofitUtil.retrofitUtil(Constant.MOVIE_API_URL, GsonConverterFactory.create())
                .create(DouBanMovieInterface.class).getTop250Movies(start);
        top250.enqueue(new Callback<MoviesListBean>() {
            @Override
            public void onResponse(Call<MoviesListBean> call, Response<MoviesListBean> response) {
                MoviesListBean moviesListBean = response.body();
                success.result(moviesListBean);
            }

            @Override
            public void onFailure(Call<MoviesListBean> call, Throwable t) {
                error.result(t.getMessage());
            }
        });
    }

    public void getCommingSoon(int start, final MvpModelCallBack<MoviesListBean> success, final MvpModelCallBack<String> error) {
        commingSoon = RetrofitUtil.retrofitUtil(Constant.MOVIE_API_URL, GsonConverterFactory.create())
                .create(DouBanMovieInterface.class).getCommingSoon(start);
        commingSoon.enqueue(new Callback<MoviesListBean>() {
            @Override
            public void onResponse(Call<MoviesListBean> call, Response<MoviesListBean> response) {
                MoviesListBean moviesListBean = response.body();
                success.result(moviesListBean);
            }

            @Override
            public void onFailure(Call<MoviesListBean> call, Throwable t) {
                error.result(t.getMessage());
            }
        });
    }

    public void getDetailsSubject(String movieId, final MvpModelCallBack<DetailsSubjectBean> success, final MvpModelCallBack<String> error){
        detailsSubject = RetrofitUtil.retrofitUtil(Constant.MOVIE_API_URL,GsonConverterFactory.create())
                .create(DouBanMovieInterface.class).getDetailsSubject(movieId);
        detailsSubject.enqueue(new Callback<DetailsSubjectBean>() {
            @Override
            public void onResponse(Call<DetailsSubjectBean> call, Response<DetailsSubjectBean> response) {
                DetailsSubjectBean detailsSubjectBean = response.body();
                success.result(detailsSubjectBean);
            }

            @Override
            public void onFailure(Call<DetailsSubjectBean> call, Throwable t) {
                error.result(t.getMessage());
            }
        });
    }

    public void destroyCall(Call call) {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

    public Call<MoviesListBean> getInTheaters() {
        return inTheaters;
    }

    public Call<MoviesListBean> getTop250() {
        return top250;
    }

    public Call<MoviesListBean> getCommingSoon() {
        return commingSoon;
    }
}
