package com.newspro.alexnewspro.http.httpinterface;

import com.newspro.alexnewspro.constant.Constant;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 新闻接口
 */
public interface NewsInterface {
    /**
     * 获取新闻列表
     *
     * @param channelId 新闻类型
     * @param page      当前页数
     * @return
     */
    @GET(Constant.NEWS_DEF_PARAM)
    Call<JSONObject> getNews(@Query("channelId") String channelId, @Query("page") int page);
}