package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModel;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.http.HttpInterface;
import com.newspro.alexnewspro.http.RetrofitUtil;
import com.newspro.alexnewspro.model.bean.NewsBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class NewsModel extends MvpModel {

    /**
     * 根据type来获取新闻列表
     *
     * @param type
     * @param callback
     */
    public void getNewsOfType(String type, int page, final MvpCallback callback) {
        Call<NewsBean> newsBeanCall = RetrofitUtil.RetrofitUtil(Constant.NEWS_URL).create(HttpInterface.NewsInterface.class).getNews(type, page);
        newsBeanCall.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                if (response != null&&response.body().getShowapi_res_code() == 0) {
                    callback.result(response.body().getShowapi_res_body().getPagebean().getContentlist());
                }else {
                    callback.result(response.body().getShowapi_res_error());
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                callback.result("错误");
            }
        });
    }

}
