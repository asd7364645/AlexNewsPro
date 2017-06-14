package com.newspro.alexnewspro.http.httpinterface;

import com.newspro.alexnewspro.bean.ShowApiBaseBean;
import com.newspro.alexnewspro.bean.baisi.BaiSiBean;
import com.newspro.alexnewspro.constant.Constant;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 新闻接口
 */
public interface ShowApiInterface {
    /**
     * 获取新闻列表
     *
     * @param channelId 新闻类型
     * @param page      当前页数
     * @return
     */
    @GET(Constant.NEWS_DEF_PARAM + "&needAllList=1")
    Call<JSONObject> getNews(@Query("channelId") String channelId, @Query("page") int page);

    @GET(Constant.BAISIBUDEJIE_DEF_PARAM)
    Call<ShowApiBaseBean<BaiSiBean>> getBaiSiWithType(@Query("type") int type, @Query("page") int page);

}