package com.newspro.alexnewspro.http;

import com.newspro.alexnewspro.constant.Constant;
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
        /**
         * 获取新闻列表
         * @param channelId 新闻类型
         * @param page      当前页数
         * @return
         */
        @GET(Constant.NEWS_DEF_PARAM)
        Call<NewsBean> getNews(@Query("channelId") String channelId,@Query("page") int page);
    }
}
